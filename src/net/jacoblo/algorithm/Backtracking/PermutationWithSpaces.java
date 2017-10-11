/**
 * Permutation with Spaces
 * EASY
 * http://practice.geeksforgeeks.org/problems/permutation-with-spaces/0
 * Given a string you need to print all possible strings that can be made by placing spaces (zero or one) in between them. Output should be printed in sorted increasing order of strings.

Input:  str[] = "ABC"
Output: (A B C)(A BC)(AB C)(ABC)
Input:
First line contains the test cases T.  1<=T<=10
Each test case have one line string S of characters of length  N.  1<=N<=10

Output:
One line per test case, every string enclosed in ().(See example). Output should be printed in sorted order.

Example:
Input:
2
AB
ABC

Output:
(A B)(AB)
(A B C)(A BC)(AB C)(ABC)
 */

package net.jacoblo.algorithm.Backtracking;
import static net.jacoblo.lib.Util.printResult;

public class PermutationWithSpaces {
	public static void main(String[] args) {
		String input = "ABCD";
		String[] result = permutationWithSpaces(input);
		System.out.println(printResult(result));
	}
	
	public static String[] permutationWithSpaces(String input) {
		if (input == null || input.length() == 0) return new String[0];
		
		if (input.length() == 1) {
			String[] result = new String[1];
			result[0] = input;
			return result;
		}
		
		String[] subRecursionResult = permutationWithSpaces(input.substring(0, input.length()-1));
		
		String[] result = new String[subRecursionResult.length * 2];
		
		for (int i = 0 ; i < subRecursionResult.length ; i++) {
			result[i*2] = subRecursionResult[i] + " " + input.charAt(input.length()-1);
			result[i*2+1] = subRecursionResult[i] + input.charAt(input.length()-1);
		}
		
		return result;
	}
	
	
}
