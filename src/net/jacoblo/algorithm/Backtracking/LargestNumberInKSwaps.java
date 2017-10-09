/**
 * TEST case failed for 4551711527
 * MEDIUM
 * Sited : http://practice.geeksforgeeks.org/problems/largest-number-in-k-swaps/0
 * Given a number K and string S of digits denoting a positive integer, build the largest number possible by performing swap operations on the digits of S atmost K times.

Input
The first line of input contains an integer T denoting the number of test cases. Then T test cases follow. 
The first line of each test case contains a positive integer K.
The second line of each test case contains a string of digits denoting a positive integer.


Output
Print out the largest number possible.


Constraints
1 <= T <= 100
0 <   S <= 30
0 <   K  <= 10

Examples 

Input
3
4
1234567
3
3435335
2
1034

Output
7654321
5543333
4301
 */

package net.jacoblo.algorithm.Backtracking;

import java.util.ArrayList;

public class LargestNumberInKSwaps {
	public static void main(String[] args) {
		String input = "1234567";
		int numOfSwaps = 4;
		System.out.println(largestNumberInKSwaps(input, numOfSwaps));
		
		String input2 = "4551711527";
		int numOfSwaps2 = 3;
		System.out.println(largestNumberInKSwaps(input2, numOfSwaps2));
	}
	
	public static String largestNumberInKSwaps(String input, int numOfSwaps) {
		if (input == null || input.length() <= 0 ) return "";
		
		char[] result = largestNumberInKSwaps(input.toCharArray(), 0, numOfSwaps);
		String resultString = new String(result);
		return resultString;
	}
	
	private static char[] largestNumberInKSwaps(char[] array, int currentIndex, int numOfSwaps) {
		if (array == null || array.length <= 0 ) return new char[0];
		
		if (numOfSwaps <= 0 || currentIndex >= array.length) {
			return array;
		}
		
		int maxDigitSoFar = Integer.parseInt(""+array[currentIndex]);
		int maxDigitSoFarIndex = currentIndex;
		for (int i = currentIndex+1; i < array.length ; i++) {
			int currentDigit = Integer.parseInt(""+array[i]);
			if (maxDigitSoFar < currentDigit) {
				maxDigitSoFar = currentDigit;
				maxDigitSoFarIndex = i;
			}
		}
		
		if (maxDigitSoFarIndex != currentIndex) {
			// TODO fix test case failed
			ArrayList<Integer> allMaxDigit = new ArrayList<>();
			for (int i = currentIndex+1; i < array.length ; i++) {
				if (Integer.parseInt(""+array[i]) == maxDigitSoFar) {
					allMaxDigit.add(i);
				}
			}
			
			char[] whichValueMax = array;
			for (int i = 0 ; i < allMaxDigit.size() ; i++) {
				char[] cloneArr = clone(array);
				swap(cloneArr, currentIndex, maxDigitSoFarIndex);
				char[] curResult = largestNumberInKSwaps(cloneArr, currentIndex+1, numOfSwaps-1);
				if (compare(curResult, whichValueMax) > 0) {
					whichValueMax = curResult;
				}
			}
			return whichValueMax;
		}
		else {
			return largestNumberInKSwaps(array, currentIndex+1, numOfSwaps);
		}
		
		
	}
	
	private static int compare(char[] a1, char[] a2) {
		if (a1 == null || a2 == null) return Integer.MIN_VALUE;
		
		if (a1.length > a2.length) return 1;
		else if (a2.length > a1.length) return -1;
		
		for (int i = 0 ; i < a1.length ; i++) {
			if (Integer.parseInt(""+a1[i]) > Integer.parseInt(""+a2[i])) {
				return 100;
			}
			else if (Integer.parseInt(""+a2[i]) > Integer.parseInt(""+a1[i])) {
				return -100;
			} 
		}
		return 0;
	}
	
	private static char[] clone(char[] array) {
		char[] newArray = new char[array.length];
		for (int i = 0 ; i < array.length ; i++) {
			newArray[i] = array[i];
		}
		return newArray;
	}
	
	private static void swap(char[] array, int i , int j) {
		if (array == null || array.length <= 0 || i < 0 || j < 0 || i >= array.length || j >= array.length || i == j)	return;
		char tmp = array[i];
		array[i] = array[j];
		array[j] = tmp;
	}
}
