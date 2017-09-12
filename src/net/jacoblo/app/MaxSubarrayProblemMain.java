package net.jacoblo.app;

import java.util.ArrayList;

import net.jacoblo.algorithm.MaxSubarrayProblem;

public class MaxSubarrayProblemMain {
	public static void main(String[] args) {
	  // testMaxSubArrayProblem();
	  
	  int[] a = { 10, 22, 9, 33, 21, 50, 41, 60, 80 };
	  ArrayList<Integer> result = MaxSubarrayProblem.LongestIncreasingSubSequence(a);
		System.out.println(result);
		
	}
	
	public static void testMaxSubArrayProblem() {
	   int [] a = {-2, -3, 4, -1, -2, 1, 5, -3};
	    ArrayList<Integer> result = MaxSubarrayProblem.MaxSubarrayDynamicProgramming(a);
	    System.out.println(result);
	}
}
