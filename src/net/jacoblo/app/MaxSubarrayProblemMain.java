package net.jacoblo.app;

import net.jacoblo.algorithm.MaxSubarrayProblem;

public class MaxSubarrayProblemMain {
	public static void main(String[] args) {
		int [] a = {-2, -3, 4, -1, -2, 1, 5, -3};
		int result = MaxSubarrayProblem.dynamicProgramming(a);
		System.out.println(result);
	}
}
