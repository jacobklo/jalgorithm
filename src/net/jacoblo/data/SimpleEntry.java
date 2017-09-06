package net.jacoblo.data;

import java.util.Map;

import net.jacoblo.algorithm.Prime;

public class SimpleEntry<K,V> implements Map.Entry<K,V> {

	private K key;
	private V value;
	
	public SimpleEntry(K k, V v) {
		key = k;
		setValue(v);
	}
  @Override
  public K getKey() {
    return key;
  }

  @Override
  public V getValue() {
    return value;
  }

  @Override
  public V setValue(V arg0) {
    value = arg0;
  	return value;
  }

  @Override
  public int hashCode() {
    return Prime.nextPrime(key.hashCode() + value.hashCode());
  }
  
  @Override
  public boolean equals(Object o) {
  	if (o != null && o instanceof SimpleEntry<?,?>) {
  		SimpleEntry<?,?> s = (SimpleEntry<?,?>) o;
  		return s.key.equals(key) && s.value.equals(value);
  	}
  	return false;
  }
  
  @Override
  public String toString() {
  	String result = "{";
  	if (key != null ) {
  		result += key.toString();
  	}
  	result += ",";
  	if (value != null) {
  		result += value.toString();
  	}
  	result += "} ";
  	return result; 
  }
}
