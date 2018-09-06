
/**
 * http://practice.geeksforgeeks.org/problems/string-formation-from-substring/0
 * TODO implement O(n) version
 * MEDIUM
 * String formation from substring
Show Topic Tags         Amazon    MakeMyTrip
Given a string ‘str’, check if it can be constructed by taking a substring of it and appending multiple copies of the substring together.  For example "abab" can be created by appending "ab" to "ab", but "abac" cannot be created by appending a substring to itself.

Input:
The first line contains T denoting the number of test cases. Then follows description of testcases. Each case contains a string.


Output:
For each test case, output "True" if it is possible and "False" if not.
 

Constraints:
1<=T<=100
1<=Length of String<=1000 
 

Example:
Input:
1
abcabcabc

Output:
True

Explanation :
The given string is 3 times repetition of "abc"
 */
package net.jacoblo.algorithm.String;

public class StringFormationFromSubstring {
	public static void main(String[] args) {
		String[] in = { "aa", "nnnnsdfdnfdfdfn", "abcdabcd", "aaaaabaaaa", "abcabcabc" };
		boolean[] checks = { true, false, true, false, true };
		for (int i = 0 ; i < in.length ; i++ ) {
			System.out.println(canFormBySubstringBruceForce(in[i]) == checks[i] ? "correct" : "INCORRECT");
		}
		
	}
	
	// TODO
	public static boolean canFormBySubstringKMP(String input) {
		return false;
	}
	
	public static boolean canFormBySubstringBruceForce(String input) {
		if ( input == null || input.length() <= 0 ) return false;
		
		for (int i = 2 ; input.length() / i >= 1 && i <= input.length() ; i++ ) {
			String current = input.substring(0, input.length() / i);
			
			boolean trueSoFar = true;
			if (input.length() % current.length() != 0) {
				trueSoFar = false;
				continue;
			}
			for (int j = 1 ; current.length()*(j+1) <= input.length() ; j++ ) {
				String subString = input.substring(current.length()*j, current.length()*(j+1));
				if (!current.equals(subString)) {
					trueSoFar = false;
					continue;
				}
			}
			if (trueSoFar) {
				return true;
			}
			
			
		}
		
		return false;
	}

}
