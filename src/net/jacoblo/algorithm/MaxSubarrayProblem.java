package net.jacoblo.algorithm;

import java.util.ArrayList;

public class MaxSubarrayProblem {
	public static int kadane(int[] array) {
		if (array == null || array.length <= 0 ) return 0;
		
		int maxSoFar = 0;
		int maxEndHere = 0;
		// TODO
//		for (int i = 1 ; i < array.length; i++) {
//			maxEndHere = max(maxEndHere, maxEndHere+array[i]);
//			if (maxEndHere < 0) {
//				maxEndHere = 0;
//			}
//			maxSoFar = max(maxSoFar,maxEndHere);
//		}
		
		return maxSoFar;
	}
	
	public static int max(int i, int j) {
		return (i > j ? i : j);
	}
	
	public static ArrayList<Integer> MaxSubarrayDynamicProgramming(int[] array) {
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

  // http://practice.geeksforgeeks.org/problems/longest-increasing-subsequence/0
  /**
   * Given a sequence, find the length of the longest increasing subsequence
   * from a given sequence . The longest increasing subsequence means to find a
   * subsequence of a given sequence in which the subsequence's elements are in
   * sorted order, lowest to highest, and in which the subsequence is as long as
   * possible. This subsequence is not necessarily contiguous, or unique.
   * 
   * Note: Duplicate numbers are not counted as increasing subsequence.
   * 
   * For example: length of LIS for { 10, 22, 9, 33, 21, 50, 41, 60, 80 } is 6
   * and LIS is {10, 22, 33, 50, 60, 80}.
   * 
   * @param array
   * @return
   */
	public static ArrayList<Integer> LongestIncreasingSubSequence(int[] array) {
	  if (array == null) return new ArrayList<>();
	  
	  ArrayList<Integer> result = new ArrayList<>();
	  result.add(array[0]);
	  for (int i = 1 ; i < array.length ; i++) {
	    if (result.get(result.size()-1) < array[i]) {
	      result.add(array[i]);
	    }
	  }
	  
	  return result;
	}
	
	// Dynamic Programming , naive approach, Big O 2^n time
	public static int LongestIncreasingSubSequence2(int[] array) {
	  if (array == null) return 0;
	  
	  // Criteria:  if it is finding the increasing subsequence, the the last element should has the max value
	  // result : length of LongestIncreasing SubSequence LIS
	  // Optimal Solution 1: the current Items is not included, LIS is the same
	  // Optimal Solution 2 : the current Items is included, and LIS is +1
	  
	  
	  
	  for (int i = 1 ; i < count ; i++) {
	    
	  }
	  
	}
}
