
/**
 * http://practice.geeksforgeeks.org/problems/number-of-ways/0
 * Medium
 * Given a tile of size 1 x 4, how many ways you can construct a grid of size N x 4.

Input:

The first line of input contains an integer T denoting the number of test cases.
The first line of each test case is N.

Output:

Print number of possible ways.

Constraints:

1 ≤ T ≤ 50
1 ≤ N ≤ 80

Example:

Input:
3
1
4
5

Output:
1
2
3

0 1 2 3 4 5 6 7 8 9
0 1 1 1 2 3 4 5 7 9
 */
package jacoblo.algorithm.DynamicProgramming;

public class NumberOfWaysForTies {
	public static void main(String[] args0 ) {
		int n = 79;
		long result = numOfWaysForTies( n) ;
		System.out.println(result);
	}
	
	public static long numOfWaysForTies(int n) {
		if (n <= 0 ) return 0;
		
		long[] result = new long[n+1];
		result[1] = 1;
		if (n >= 2) { result[2] = 1; }
		if (n >= 3) { result[3] = 1; }
		if (n >= 4) { result[4] = 2; }
		
		for (int i = 5 ; i <= n ; i++ ) {
			result[i] = result[i-1] + result[i-4];
		}
		return result[n];
	}
}
