package net.jacoblo.dataStructure;

import java.util.ArrayList;
import java.util.Map;

import net.jacoblo.algorithm.Prime;
import net.jacoblo.data.SimpleEntry;
import net.jacoblo.data.Tuple;

public class Hashtable<K,V> 
{
  private Object[] table;
  private int capacity;
  private int numOfItems;
  
  public Hashtable() {
  	clear();
  }
  
  public void clear() {
  	capacity = Prime.nextPrime(10);
  	table = new Object[capacity];
  	numOfItems = 0;
  }
  
  public boolean contains(Object value) {
  	return false;
  }
  
  public boolean containsValue(Object value) {
  	return false;
  }
  
  public boolean containsKey(Object key) {
    return false;
  }
  
  @Override
  public boolean equals(Object o) {
    return false;
  }

  public V get(Object key) {
    return (V) getEntryPos(key).y;
  }
  
  private Tuple<Integer,Map.Entry<K,V>> getEntryPos(Object key) {
  	if (key == null) return new Tuple<>(-1,null);
  	
  	for (int i = 0, indexToSearch = key.hashCode() % capacity ; i < capacity; i++) {
  		if (table[indexToSearch] != null ) {
  			Map.Entry<K, V> currentEntry = (Map.Entry<K, V>) table[indexToSearch];
  			if (currentEntry.getKey() != null && currentEntry.getKey().equals(key)) {
  				return new Tuple<>(indexToSearch, currentEntry);
  			}
  			else {
    			indexToSearch += 1;
    			indexToSearch = indexToSearch % capacity;
    		}
  		}
  		// from hash to hash + x, we serach through all already. if it start become null, it will never be contains in this array, return
  		else //if (currentEntry == null) 
  		{
  			return new Tuple<>(-1,null);
  		}
  	}
  	return new Tuple<>(-1,null);
  }

  public V put(K key, V value) {
  	if (key == null || value == null) return null;
  	if (numOfItems + 1 >= capacity)	return null;
    return (V) put(table, new SimpleEntry(key, value));
  }
  
  private V put(Object[] table, Map.Entry<K,V> me) {
  	int indexToAdd = me.getKey().hashCode() % capacity;
  	while (table[indexToAdd] != null) {
  		indexToAdd += 1;
  		indexToAdd = indexToAdd % capacity;
  	}
  	table[indexToAdd] = me;
  	numOfItems++;
  	checkIfRehash();
  	return me.getValue();
  }
  
  public V remove(Object key) {
  	Tuple<Integer,Map.Entry<K,V>> tuple = getEntryPos(key);
  	if (numOfItems <= 0) return null;
  	if (tuple.x == -1)	return null;
  	table[tuple.x] = null;
  	numOfItems--;
  	
  	int nextTocheck = (tuple.x+1) % capacity;
  	ArrayList<Map.Entry<K,V>> rePositionEntries = new ArrayList<>();
  	while(table[nextTocheck] != null) {
  		Map.Entry<K, V> cur = (Map.Entry<K, V>) table[nextTocheck];
  		rePositionEntries.add(cur);
  		table[nextTocheck] = null;
  		nextTocheck++;
  	}
  	for (Map.Entry<K,V> me : rePositionEntries) {
  		put(table, me);
  	}
  	return (tuple.y == null? null : tuple.y.getValue());
  }
  
  private void checkIfRehash() {
  	if (numOfItems * 2 > capacity) {
  		rehash();
  	}
  }
  
  public void rehash() {
  	capacity = Prime.nextPrime(capacity*2);
  	Object[] newTable = new Object[capacity];
  	for (int i = 0 ; i < table.length ; i++) {
  		if (table[i] != null) {
  			Map.Entry<K,V> me = (Map.Entry<K,V> ) table[i];
  			put(newTable, me);
  		}
  	}
  	table = newTable;
  }
  
  public int size() {
    return numOfItems;
  }
  
  @Override
  public String toString() {
    String result = "[ ";
    for (int i = 0 ; i < table.length ; i++) {
    	if (table[i] == null) {
    		result += "null ";
    	}
    	else {
    		Map.Entry<K,V> me = (Map.Entry<K,V> ) table[i];
      	result += me.getValue()  + " ";
    	}
    }
    result += "]";
    return result;
  }
  
}
