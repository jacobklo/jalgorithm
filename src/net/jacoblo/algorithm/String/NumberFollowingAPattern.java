
/**
 * Number following a pattern
 * http://practice.geeksforgeeks.org/problems/number-following-a-pattern/0
MEDIUM
NOT PASS
Given a pattern containing only I's and D's. I for increasing and D for decreasing.
Devise an algorithm to print the minimum number following that pattern.
Digits from 1-9 and digits can't repeat.

Input:
The first line of input contains an integer T denoting the number of test cases.
The first line of each test case is a string, which contains only I's and D's in capital letter.

Output:
Print the minimum number following that pattern.

Constraints:
1 ≤ T ≤ 100
1 ≤ Length of String ≤ 8

Example:
Input
5
D
I
DD
IIDDD
DDIDDIID

Output
21
12
321
126543
321654798
 */

package net.jacoblo.algorithm.String;

import java.util.ArrayList;
import java.util.LinkedList;

public class NumberFollowingAPattern {
	public static void main(String[] args) {
		String[] pattern = { "D", "I", "DD", "IIDDD", "DDIDDIID" };
		int[] results = { 21, 12, 321, 126543, 321654798 };

		for ( int i = 4 ; i < 5 ; i++ ) {
			ArrayList<Integer> result = numberFollowingAPattern(pattern[i]);
			if (arrayDigitToInteger(result) == results[i]) {
				System.out.println("correct");
			}
			else {
				System.out.println("INCORRECT " + result);
			}
		}
	}
	
	
	//TODO: this is a dump implementataion, make a better one
	public static ArrayList<Integer> numberFollowingAPattern(String pattern) {
		if (pattern == null || pattern.length() <= 0 || pattern.length() > 8) return null;
		LinkedList<Integer> list = new LinkedList<>();
		list.add(1);list.add(2);list.add(3);list.add(4);list.add(5);
		list.add(6);list.add(7);list.add(8);list.add(9);
		
		ArrayList<Integer> result = new ArrayList<>();
		
		for ( int i = 0 ; i < pattern.length() ; ) {
			char current = pattern.charAt(i);
			int currentStart = i, currentEnd = i;
			while ( i < pattern.length() && pattern.charAt(i) == current) {
				currentEnd++;
				i++;
			}
			
			int numToRemove = currentEnd - currentStart;
			if (currentEnd == pattern.length() || current == 'D') {
				numToRemove++;
			}
			LinkedList<Integer> subResult = new LinkedList<>();
			for ( int k = 0 ; k < numToRemove ; k++ ) {
				subResult.add(list.removeFirst());
			}
			
			if ( current == 'D') {
				for ( int j = 0 ; j < numToRemove; j++ ) {
					result.add(subResult.removeLast());
				}
			}
			else if (current == 'I') {
				for ( int j = 0 ; j < numToRemove; j++ ) {
					result.add(subResult.removeFirst());
				}
			}
		}
		
		return result;
	}
	
	public static int arrayDigitToInteger(ArrayList<Integer> array) {
		if (array == null || array.size() <= 0 ) return Integer.MIN_VALUE;
		
		int resultInteger = 0;
		for ( int i = 0 ; i < array.size(); i++ ) {
			resultInteger += array.get(i) * Math.pow(10, array.size()-1-i);
		}
		return resultInteger;
	}
}
