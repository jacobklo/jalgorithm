package net.jacoblo.algorithm.DynamicProgramming;

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

}
