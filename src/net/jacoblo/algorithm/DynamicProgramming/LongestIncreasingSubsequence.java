package net.jacoblo.algorithm.DynamicProgramming;

import java.util.ArrayList;

//http://practice.geeksforgeeks.org/problems/longest-increasing-subsequence/0
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
* 
Input  : arr[] = {3, 10, 2, 1, 20}
Output : Length of LIS = 3
The longest increasing subsequence is 3, 10, 20

Input  : arr[] = {3, 2}
Output : Length of LIS = 1
The longest increasing subsequences are {3} and {2}

Input : arr[] = {50, 3, 10, 7, 40, 80}
Output : Length of LIS = 4
The longest increasing subsequence is {3, 7, 40, 80}
*/

public class LongestIncreasingSubsequence {
	public static void main(String[] args) {
	  // testMaxSubArrayProblem();
	  
	  int[] a = { 10, 22, 9, 33, 21, 50, 41, 60, 80 };
	  int[] b = {50, 3, 10, 7, 40, 80};
	  int result = LongestIncreasingSubsequenceDP(b, b.length);
	  System.out.println(result);
		
	}
	
	public static int max_result = 0;
	
	public static int LongestIncreasingSubsequenceNaiveDP(int[] arr, int n) {
	//From : http://www.geeksforgeeks.org/longest-increasing-subsequence/
	// base case
    if (n == 1)
        return 1;

    // 'max_ending_here' is length of LIS ending with arr[n-1]
    int res, max_ending_here = 1;

     /* Recursively get all LIS ending with arr[0], arr[1] ...
        arr[n-2]. If   arr[i-1] is smaller than arr[n-1], and
        max ending with arr[n-1] needs to be updated, then
        update it */
     for (int i = 1; i < n; i++)
     {
         res = LongestIncreasingSubsequenceNaiveDP(arr, i);
         if (arr[i-1] < arr[n-1] && res + 1 > max_ending_here)
             max_ending_here = res + 1;
     }

     // Compare max_ending_here with the overall max. And
     // update the overall max if needed
     if (max_result < max_ending_here)
    	 max_result = max_ending_here;

     // Return length of LIS ending with arr[n-1]
     return max_ending_here;
	}
	
	public static int LongestIncreasingSubsequenceDP(int[] array, int n) {
		if ( array == null) return 0;
		
		int[] LISs = new int[n];
		
		for (int i = 0 ; i < LISs.length ; i++) {
			LISs[i] = 1;
		}
		
		for (int i = 1 ; i < n ; i++) {
			for (int j = 0 ; j < i ; j++) {
				int result = LISs[j];
				if (array[i] > array[j] && LISs[i] < LISs[j] + 1) {
					LISs[i] = result + 1;
				}
			}
		}
		
		int max = -1;
		for ( int i = 0 ; i < LISs.length ; i++) {
			if (max < LISs[i]) {
				max = LISs[i];
			}
		}
		return max;
	}
	/**
	 * ERROR, wrong corner cases!!!
	 * Check with {50, 3, 10, 7, 40, 80}
	 */
	/*
	 * This is not LIS!! Because it will return 50, 10, 40, 80!!
	public static ArrayList<Integer> LongestIncreasingSubsequence(int[] array) {
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
	
	// BackTracking , naive approach, Big O(n)
	public static ArrayList<Integer> LongestIncreasingSubsequenceBackTracking(int[] array, int currentIndex ) {
		// careful check
	  if (array == null) return new ArrayList<>();
	  
	  // Base case for recursive call, if first element call, of course it is the longest increasing subsequence so far.
	  if (currentIndex == 0) {
	  	ArrayList<Integer> result = new ArrayList<>();
	  	result.add(array[0]);
	  	return result;
	  }
	  
	  // BackTracking, assume this program is perfected to find LIS, then we should be able to get the result of the subsequence so far, from index 0 to currentIndex-1
	  ArrayList<Integer> result = LongestIncreasingSubsequenceBackTracking(array, currentIndex-1);
	  
	  // Calculate if this currentIndex can be the new LIS, two case: 
	  // 1) this element array[currentIndex] can form a even better LIS
	  if (array[currentIndex] > array[currentIndex-1]) {
	  	result.add(array[currentIndex]);
	  }
	  // 2) No, this element cannot form a even better LIS
	  else {}
	  
	  return result;
	}
	*/
	

}
