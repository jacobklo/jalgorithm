
/**
 * http://practice.geeksforgeeks.org/problems/kadanes-algorithm/0
 * MEDIUM
 * Kadane's Algorithm
Given an array containing both negative and positive integers. Find the contiguous sub-array with maximum sum.
 
Input:
The first line of input contains an integer T denoting the number of test cases. The description of T test cases follows. The first line of each test case contains a single integer N denoting the size of array. The second line contains N space-separated integers A1, A2, ..., AN denoting the elements of the array.
 
Output:
Print the maximum sum of the contiguous sub-array in a separate line for each test case.
 
Constraints:
1 <= T <= 200
1 <= N <= 1000
-100 <= A[i] <= 100
 
Example:
Input
2
3
1 2 3
4
-1 -2 -3 -4
Output
6
-1
 */
package net.jacoblo.algorithm.DynamicProgramming;

import java.util.ArrayList;

public class MaxSubarrayProblem {
  public static void main(String[] args) {
    testKadane();
  }
  
  public static void testKadane() {
    int[][] a = { {-2, -3, 4, -1, -2, 1, 5, -3}, { 1, 2, 3} , { -1, -2, -3, -4 } };
    int[] checks = { 7, 6, -1 };
    for ( int i = 0 ; i < a.length ; i++ ) {
      if (kadane(a[i]) == checks[i]) {
        System.out.println("correct");
      }
      else {
        System.out.println("INCORRECT " + kadane(a[i]) + " instead of " + checks[i]);
      }
    };
 }
  
  public static void testMaxSubArrayProblem() {
    int [] a = {-2, -3, 4, -1, -2, 1, 5, -3};
     ArrayList<Integer> result = maxSubarrayDynamicProgramming(a);
     System.out.println(result);
 }
  
	public static int kadane(int[] array) {
		if (array == null || array.length <= 0 ) return Integer.MIN_VALUE;
		
		int maxSoFar = Integer.MIN_VALUE;
		int maxEndHere = 0;
		
		for (int i = 0 ; i < array.length; i++) {
			maxEndHere = maxEndHere+array[i];
			maxSoFar = Math.max(maxSoFar,maxEndHere);
			if (maxEndHere < 0) {
				maxEndHere = 0;
			}
		}
		
		return maxSoFar;
	}
	
	
	public static ArrayList<Integer> maxSubarrayDynamicProgramming(int[] array) {
	  if (array == null || array.length <= 0 ) return new ArrayList<>();
	  
		int maxEndHere = 0;
		int maxStartHereIndex = 0; // for each sub array, we need to record the index
		int maxEndHereIndex = 0;
		int[] maxSoFar = new int[array.length];
		maxSoFar[0] = array[0];
		maxEndHere = array[0];
		
		for (int i = 1 ; i < array.length; i++) {
			if (array[i] > maxEndHere + array[i] ) {
				maxEndHere = array[i];
				maxStartHereIndex = i;
			}
			else {
				maxEndHere += array[i];
			}
			
			// calculate Max
			if (maxSoFar[i-1] > maxEndHere) {
			  maxSoFar[i] = maxSoFar[i-1];
			}
			else {
			  maxSoFar[i] = maxEndHere;
			  maxEndHereIndex = i;
			}
			
		}
		
		
		ArrayList<Integer> result = new ArrayList<>();
		for (int i = maxStartHereIndex ; i <= maxEndHereIndex; i++) { 
		  result.add(array[i]);
		}
		return result;
	}

}
