
/**
 * http://practice.geeksforgeeks.org/problems/max-possible-amount/0
 * Max possible amount
   MEDIUM
   TODO: implement run time O(n^2) version
Given a row of n coins of values v1 , v2 ... vn, where n is even. We play a game against an opponent by alternating turns. In each turn, a player selects either the first or last coin from the row, removes it from the row permanently, and receives the value of the coin. Determine the maximum possible amount of money we can definitely win if we move first.

Note : The opponent is as clever as the user.

Input:
The first line of input contains an integer T denoting the number of test cases. Then T test cases follow. Each test case consists of two lines.
The first line of each test case contains an integer N, where N is the number of coins.
The second line of each test case contains N  space separated integers denoting input for v[ ].

Output:

Corresponding to each test case, print in a new line, the maximum possible amount of money.

Constraints:
1 ≤ T ≤ 100
2 ≤ N ≤ 100
1 ≤ v[i] ≤ 500

Example:
Input
2
4
5 3 7 10
4
8 15 3 7

Output
15
22
 */
package net.jacoblo.algorithm.DynamicProgramming;

public class MaxPossibleAmount {
	public static void main(String[] args) {
		int[][] coins = { {8, 15, 3, 7 }, { 5, 3, 7, 10} };
		int[] checks = { 22, 15 };
		for (int i = 0 ; i < coins.length ; i++ ) {
			int result = maxPossibleAmountDP(coins[i]);
			if (result == checks[i]) {
				System.out.println("correct");
			}
			else {
				System.out.println("INCORRECT " + result);
			}
		}
	}
	
	public static int maxPossibleAmountDP(int[] coins) {
		if ( coins == null || coins.length <= 0 ) return 0;
		// TODO
		
		return 0;
	}
	
	public static int maxPossibleAmountRecursiveDP(int[] coins) {
		if ( coins == null || coins.length <= 0 ) return 0;
		
		int myTurn = maxPossibleAmountRecursiveDP(coins, 0, coins.length-1, true);
		int opponentTurn = maxPossibleAmountRecursiveDP(coins, 0, coins.length-1, false);
		return Math.max(myTurn, opponentTurn);
	}
	
	public static int maxPossibleAmountRecursiveDP(int[] coins, int startIndex, int endIndex, boolean isMyTurn) {
		if (startIndex < 0 || endIndex < 0 || startIndex >= endIndex) return 0;
		
		int removeHead = maxPossibleAmountRecursiveDP ( coins, startIndex+1, endIndex, !isMyTurn);
		int removeTail = maxPossibleAmountRecursiveDP ( coins, startIndex, endIndex-1, !isMyTurn);
		
		int result = Math.max(removeHead, removeTail);
		if (isMyTurn) {
			result += ( removeHead > removeTail ? coins[startIndex] : coins[endIndex]);
		}
		return result;
	}
}
