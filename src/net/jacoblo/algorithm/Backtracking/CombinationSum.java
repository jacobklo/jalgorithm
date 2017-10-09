/**
 * NOT PASS THE TESTS YET
 * http://practice.geeksforgeeks.org/problems/combination-sum-part-2/0
 * Given an array of integers A and a sum B, find all unique combinations in A where the sum is equal to B.

ach number in A may only be used once in the combination.

Note:
   All numbers will be positive integers.
   Elements in a combination (a1, a2, … , ak) must be in non-descending order. (ie, a1 ≤ a2 ≤ … ≤ ak).
   The combinations themselves must be sorted in ascending order.
   If there is no combination possible the print "Empty" (without qoutes).
Example,
Given A = 10,1,2,7,6,1,5 and B(sum) 8,

A solution set is:

[1, 7]
[1, 2, 5]
[2, 6]
[1, 1, 6]

Input:
First is T , no of test cases. 1<=T<=500
Every test case has three lines.
First line is N, size of array. 1<=N<=12
Second line contains N space seperated integers(x). 1<=x<=9.
Third line is the sum B. 1<=B<=30.
 
Output:
One line per test case, every subset enclosed in () and in every set intergers should be space seperated.(See example)

Example:
Input:
2
7
10 1 2 7 6 1 5
8
5
8 1 8 6 8
12

Output:
(1 1 6)(1 2 5)(1 7)(2 6)
Empty

 *
 */

package net.jacoblo.algorithm.Backtracking;

import java.util.ArrayList;
import java.util.Arrays;

import net.jacoblo.lib.Util;

public class CombinationSum {
	public static void main(String[] args) {
		int[] input = { 10,1,2,7,6,1,5 };
		ArrayList<ArrayList<Integer>> result = combinationSum(input, 8);
		System.out.println(Util.<Integer>printResult(result));
		
		int[] input2 = { 6, 5, 6, 3, 4, 3, 9, 9  };
		ArrayList<ArrayList<Integer>> result2 = combinationSum(input2, 17);
		System.out.println(Util.<Integer>printResult(result2));
		
	}
	
	public static ArrayList<ArrayList<Integer>> combinationSum(int[] array, int sum) {
		if (array == null || array.length == 0 ) return new ArrayList<>();
		
		Arrays.sort(array);
		
		return combinationSum(array,sum,new ArrayList<>(), new ArrayList<>(), 0);
	}
	
	private static ArrayList<ArrayList<Integer>> combinationSum(int[] array, int sum, ArrayList<ArrayList<Integer>> currentResult, ArrayList<Integer> thisRecursionSoFar, int currentIndex) {
		
		if (sum == 0) {
			boolean ifContainsAlready = false;
			for (ArrayList<Integer> a : currentResult) {
				if (ifArraysEqual(a,thisRecursionSoFar)) {
					ifContainsAlready = true;
				}
			}
			if (!ifContainsAlready) {
				currentResult.add(thisRecursionSoFar);
			}
			return currentResult;
		}
		
		else if (sum < 0) {
			thisRecursionSoFar.remove(thisRecursionSoFar.size() - 1);
			return currentResult;
		}
		
		for ( int i = currentIndex ; i < array.length ; i++) {
			int calcNewSum = sum - array[i];
			ArrayList<Integer> subRecursionSoFar = new ArrayList<>();
			subRecursionSoFar.addAll(thisRecursionSoFar);
			subRecursionSoFar.add(array[i]);
			currentResult = combinationSum(array,calcNewSum,currentResult, subRecursionSoFar, i+1);
		}
		
		return currentResult;
	}

	private static boolean ifArraysEqual(ArrayList<Integer> a1, ArrayList<Integer> a2) {
		if (a1 == null || a2 == null) return false;
		
		for (int i : a1) {
			if (!a2.contains(i)) {
				return false;
			}
		}
		for (int i : a2) {
			if (!a1.contains(i)) {
				return false;
			}
		}
		return true;
	}
}
