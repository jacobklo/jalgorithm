package net.jacoblo.algorithm;

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
	
	public static int dynamicProgramming(int[] array) {
		if (array == null || array.length <= 0 ) return 0;
		
		int maxEndHere = 0;
		int[] maxSoFar = new int[array.length];
		maxSoFar[0] = array[0];
		maxEndHere = array[0];
		
		for (int i = 1 ; i < array.length; i++) {
			if (array[i] > maxEndHere + array[i] ) {
				maxEndHere = array[i];
			}
			else {
				maxEndHere += array[i];
			}
			maxSoFar[i] = max(maxSoFar[i-1], maxEndHere);
		}
		
		return maxSoFar[array.length-1];
	}
}
