
/**
 * http://practice.geeksforgeeks.org/problems/rearrange-characters/0
 * Medium
 * Rearrange characters
Show Topic Tags           Amazon
Given a string with repeated characters, task is to rearrange characters in a string such that no two adjacent characters are same.

Note : It may be assumed that the string has only lowercase English alphabets.


Input:
The first line of input contains an integer T denoting the number of test cases. Then T test cases follow. Each test case contains a single line containing a string of lowercase english alphabets.

Output:
For each test case in a new line print 1 if the generated sting doesn't contains any same adjacent characters, else if no such string is possible to be made print 0.
Constraints:
1<=T<=100
1<=length of string<=600

Example:
Input:
3
geeksforgeeks
bbbabaaacd
bbbbb

Output:
1
1
0
 */
package net.jacoblo.algorithm.String;

public class RearrangeCharacters {
	public static void main(String[] args) {
		String input = "bbbbbaaaa";
		boolean result = rearrangeCharctersToNoAdjecent(input);
		System.out.println(result);
	}
	
	public static boolean rearrangeCharctersToNoAdjecent(String input ) {
		if ( input == null || input.length() <= 0 ) return false;
		
		int[] buckets = new int[26];
		
		for ( int i = 0 ; i < input.length() ; i++ ) {
			int characterIndex = input.charAt(i) - 97;
			buckets[characterIndex]++;
		}
		
		for ( int i = 0 ; i < buckets.length ; i++ ) {
			int totalWithoutCurrent = calcTotalWithoutCurrent(buckets,i);
			if ( buckets[i] > totalWithoutCurrent + 1) {
				return false;
			}
		}
		
		return true;
	}
	
	public static int calcTotalWithoutCurrent(int[] buckets, int current ) {
		if ( buckets == null || buckets.length <= 0 ) return 0;
		int result = 0;
		for ( int i = 0 ; i < buckets.length ; i++ ) {
			if (i != current ) {
				result += buckets[i];
			}
		}
		return result;
	}
}
