
/**
 * http://practice.geeksforgeeks.org/problems/binary-string/0
 * Medium
 * Binary Sub String 
 * Given a binary string, count number of substrings that start and end with 1. For example, if the input string is “00100101”, then there are three substrings “1001”, “100101” and “101”.
 

Input:

The first line of input contains an integer T denoting the number of test cases.
Each test case consist of an integer 'n' denoting the string length and next line is followed by a binary string .


Output:

Print the number of substring starting and ending with 1 in a separate line.

Constraints:

1 ≤ T ≤ 40
1 ≤ |s| ≤ 1000


Example:

Input:
1
4
1111
Output:
6
 */
package net.jacoblo.algorithm.String;

public class BinarySubString {
	public static void main(String[] args) {
		String in = "1001010101";
		int result = binarySubString( in);
		System.out.println(result);
	}
	
	public static int binarySubString(String input) {
		if (input == null || input.length() <= 0) return 0;
		
		int numOfOnes = 0;
		for (int i = 0 ; i < input.length(); i++) {
			if (input.charAt(i) == '1') {
				numOfOnes++;
			}
		}
		
		return numOfOnes * (numOfOnes - 1) / 2;
	}
}
