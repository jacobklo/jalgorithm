package net.jacoblo.app.algorithm.DynamicProgramming;

import java.util.ArrayList;

import net.jacoblo.algorithm.DynamicProgramming.MaxSubarrayProblem;

public class MaxSubarrayProblemMain {

	
	public static void testMaxSubArrayProblem() {
	   int [] a = {-2, -3, 4, -1, -2, 1, 5, -3};
	    ArrayList<Integer> result = MaxSubarrayProblem.MaxSubarrayDynamicProgramming(a);
	    System.out.println(result);
	}
}
