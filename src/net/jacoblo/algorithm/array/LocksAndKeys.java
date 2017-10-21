package net.jacoblo.algorithm.array;

import java.util.Hashtable;

public class LocksAndKeys {
  public static void main(String[] args) {
    char[] locks = { '^', '&', '%', '@', '#', '*', '$', '~', '!' };
    char[] keys = { '~', '#', '@', '%', '&', '*', '$', '^', '!' };
    
    char[] result = locksAndKeys(locks, keys);
    System.out.println(result);
  }
  
  public static char[] locksAndKeys(char[] locks, char[] keys ) {
    if (locks == null || locks.length <= 0 || keys == null || keys.length <= 0 ) return new char[0];
    
    Hashtable<Character,Integer> locksHash = new Hashtable<>();
    Hashtable<Character,Integer> keysHash = new Hashtable<>();
    
    for (int i = 0 ; i < locks.length ; i++ ) {
      locksHash.put(locks[i], i);
    }
    for (int i = 0 ; i < keys.length ; i++ ) {
      keysHash.put(keys[i], i);
    }
    
    char[] outputsOrder = { '!', '#', '$', '%', '&', '*', '@', '^', '~' };
    
    for ( int i = 0, lockIndex = 0, keyIndex = 0 ; i < outputsOrder.length ; i++ ) {
      if ( locksHash.get((Character)outputsOrder[i]) != null) {
        swap(locks,lockIndex, locksHash.get(outputsOrder[i]));
        swap(keys,keyIndex, keysHash.get(outputsOrder[i]));
        lockIndex++;
        keyIndex++;
      }
    }
    
    return locks;
  }
  
  public static void swap(char[] array, int i , int j ) {
    if (array == null || array.length <= 0 ) return;
    
    char tmp = array[i];
    array[i] = array[j];
    array[j] = tmp;
  }
}
