package net.jacoblo.algorithm.array;
/**
 * Subarray with given sum
   MEDIUM
Given an unsorted array of non-negative integers, find a continuous sub-array which adds to a given number.

Input:

The first line of input contains an integer T denoting the number of test cases. Then T test cases follow. Each test case consists of two lines. The first line of each test case is N and S, where N is the size of array and S is the sum. The second line of each test case contains N space separated integers denoting the array elements.

Output:

Corresponding to each test case, in a new line, print the starting and ending positions of first such occuring subarray if sum equals to subarray, else print -1.

Note: Position of 1st element of the array should be considered as 1.

Expected Time Complexity: O(n)

Constraints:
1 <= T <= 100
1 <= N <= 100
1 <= an array element <= 200

Example:

Input:
2
5 12
1 2 3 7 5
10 15
1 2 3 4 5 6 7 8 9 10

Output:
2 4
1 5

Explanation : 
In first test case, sum of elements from 2nd position to 4th position is 12
In second test case, sum of elements from 1st position to 5th position is 15

 */

import static org.junit.Assert.*;

import org.junit.Test;

public class SubarrayWithGivenSum {
	
  /**
   * Time complexity : 
   * Space complexity : 
   * 
   * a : [1,2,3,4]
   * s1 : 1
   * r1 : [1, 1]
   * 
   * s2 : 1000
   * r2 : [-1, -1]
   * 
   * s3 : 2
   * r3 : [2, 2]
   * 
   * s4 : 3
   * r4 : [1, 2]
   * 
   * s5 : 6
   * r5 : [ -1, -1]
   * 
   * b : [ 4, 1, 3, 2 ]
   * s6 : 1
   * r6 : [ 2, 2 ]
   * 
   * 
   */
  
  public static int[] subarrayWithGivenSum(int[] array, int sum ) {
    int[] result = { -1, -1 };
    if ( array == null || array.length <= 0 ) return result;
    
    int startIndex = 0, endIndex = 0;
    int currentValue = array[0];
    
    for ( int i = 1 ; i < array.length ; i++ ) {
    	if ( currentValue == sum ) {
    		result[0] = startIndex + 1;
    		result[1] = endIndex + 1;
    		return result;
    	}
    	else {
    		if ( currentValue > sum ) {
      		//reset current
      		startIndex = endIndex = i;
      		currentValue = array[i];
      	}
      	else if ( currentValue < sum ) {
      		endIndex = i;
      		currentValue += array[i];
      	}
    		
    		if ( currentValue == sum ) {
      		result[0] = startIndex + 1;
      		result[1] = endIndex + 1;
      		return result;
      	}
    	}
    }
    
    if ( currentValue == sum ) {
    	result[0] = startIndex + 1;
  		result[1] = endIndex + 1;
  	}
    return result;
  }
  
  private int[] array1 = { 1, 2, 3, 4 };
  
  @Test
	public void testNormal() {
		int sum = 1;
		int[] result = subarrayWithGivenSum(array1, sum);
		int[] expected = { 1, 1 };
		assertArrayEquals(expected, result);
		
		sum = 2;
		result = subarrayWithGivenSum(array1, sum);
		int[] expected2 = { 2, 2 };
		assertArrayEquals(expected2, result);
		
		sum = 3;
		result = subarrayWithGivenSum(array1, sum);
		int[] expected3 = { 1, 2 };
		assertArrayEquals(expected3, result);
	}
  
  @Test
  public void testSumLargerThanTotal() {
  	int sum = 1000;
		int[] result = subarrayWithGivenSum(array1, sum);
		int[] expected = { -1, -1 };
		assertArrayEquals(expected, result);
  }
}
