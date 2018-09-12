
/**
 * Count number of hops
 * Easy
 * http://practice.geeksforgeeks.org/problems/count-number-of-hops/0
 * 
 * Frog steps either 1, 2 or 3 steps to go to top. In how many ways it reaches the top?

Input:

The first line of input contains an integer T denoting the number of test cases.
The first line of each test case is N. Where is the number of steps it has to hop.

Output:

Print the number of ways.

Constraints:

1 ≤ T ≤ 50
1 ≤ N ≤ 50

Example:

Input:
2
1
5

Output:
1
13

 */
package jacoblo.algorithm.DynamicProgramming;

public class CountWaysToReachStairs {
	public static void main(String[] args) {
		int numOfHops = 5;
		int result = countWaysToReachStairsDP( numOfHops);
		System.out.println(result);
	}
	
	public static int countWaysToReachStairsDP(int numOfStairs) {
		if (numOfStairs <= 0) return 0;
		
		int[] resultDP = new int[numOfStairs+1];
		
		resultDP[1] = 1;
		if (numOfStairs >= 2) {
			resultDP[2] = 2;
		}
		if (numOfStairs >= 3) {
			resultDP[3] = 4;
		}
		
		for (int i = 4 ; i <= numOfStairs ; i++ ) {
			resultDP[i] = resultDP[i-3] + resultDP[i-2] + resultDP[i-1];
		}
		
		return resultDP[numOfStairs];
	}
}
