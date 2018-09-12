
/**
 * http://practice.geeksforgeeks.org/problems/nuts-and-bolts-problem/0
 * Nuts and Bolts Problem
Medium
Given a set of N nuts of different sizes and N bolts of different sizes. There is a one-one mapping between nuts and bolts. Match nuts and bolts efficiently.

Comparison of a nut to another nut or a bolt to another bolt is not allowed. It means nut can only be compared with bolt and bolt can only be compared with nut to see which one is bigger/smaller.

Input:

The first line contains 'T' denoting the number of testcases. Then follows description of T testcases:
Each case begins with a single positive integer N denoting the number of nuts/bolts.

Then follows the array of nuts, each element separated by a space.

And finally the bolts array, again, each element is separated by a space here.

Array of Nuts/Bolts can only consist of the following elements:

{'@', '#', '$', '%', '^', '&', '~', '*', '!'}

And no element can be repeated.


Output:

For each test case, output the matched array of nuts and bolts in separate lines, where each element in the array is separated by a space. Print the elements in the following order ! # $ % & * @ ^ ~ 


Constraints:

1<= T <= 70
1<= N <= 9


Example:

Input:

2
5
@ % $ # ^
% @ # $ ^
9
^ & % @ # * $ ~ !
~ # @ % & * $ ^ ! 

Output:

# $ % @ ^
# $ % @ ^
! # $ % & * @ ^ ~
​! # $ % & * @ ^ ~
 */
package jacoblo.algorithm.array;

import java.util.Hashtable;

public class LocksAndKeys {
  public static void main(String[] args) {
//    char[] locks = { '^', '&', '%', '@', '#', '*', '$', '~', '!' };
//    char[] keys = { '~', '#', '@', '%', '&', '*', '$', '^', '!' };
    char[] locks = { '@', '%', '$', '#', '^' };
    char[] keys = { '%', '@', '#', '$', '^' };
    
    
    char[] result = locksAndKeys(locks, keys);
    System.out.println(printLocks(result));
  }
  
  public static String printLocks(char[] locks) {
  	if (locks == null || locks.length <= 0 ) return "";
  	
  	String s = "";
  	for ( int i = 0 ; i < locks.length ; i++ ) {
  		s += locks[i] + " ";
  	}
  	return s;
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
      	int toBeSwapLock = locksHash.get(outputsOrder[i]);
        swap(locks,lockIndex, toBeSwapLock);
        locksHash.put(locks[toBeSwapLock], toBeSwapLock);
        
        int toBeSwapKey = keysHash.get(outputsOrder[i]);
        swap(keys,keyIndex, toBeSwapKey);
        keysHash.put(locks[toBeSwapKey], toBeSwapKey);
        
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
