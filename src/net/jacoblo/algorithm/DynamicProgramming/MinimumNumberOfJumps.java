package net.jacoblo.algorithm.DynamicProgramming;

import java.util.ArrayList;

import net.jacoblo.data.Tuple;

public class MinimumNumberOfJumps {
	public static void main(String[] args) {
	  int[] arr = {1, 3, 5, 8, 9, 2, 6, 7, 6, 8, 9};
	  int[] a2 = {9, 1, 2};
	  int result = MinimumNumberOfJumpsNaiveDP(arr, arr.length);
	  System.out.println(result);
	}
	
	public static int MinimumNumberOfJumpsNaiveDP(int[] array, int index) {
		// From : http://www.geeksforgeeks.org/minimum-number-of-jumps-to-reach-end-of-a-given-array/
		if (array == null) return 0;
		
		if (index == 0 || array[0] == 0) {
			return Integer.MAX_VALUE;
		}
		
		int[] jumps = new int[index];
		jumps[0] = 0;
		for (int i = 1; i < index; i++) {
			jumps[i] = Integer.MAX_VALUE;
			for ( int j = 0 ; j < i ; j++) {
				if (i <= j + array[j] && jumps[j] != Integer.MAX_VALUE) {
					jumps[i] = Math.min(jumps[i], jumps[j] + 1);
					break;
				}
				else {
					System.out.println("test");
				}
			}
		}
		
		return jumps[index-1];
	}
}
