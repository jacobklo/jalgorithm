
/**
 * http://practice.geeksforgeeks.org/problems/betting-game/0
 * Betting game
    Medium
You are involved in a betting game whose rules are as follows :
a) If you win a round, the bet amount will be added to your current sum and next bet amount will become $1;
b) If you lose a round, the bet amount will be reduced from your current sum and next bet will become twice the previous.
c) game ends either when all the rounds are complete or when you don't have sufficient sum.
Initially, you are given with a string consisiting of characters from the set {'W', 'L'}, where 'W' indicates a win and 'L' indicates a loss, and initial sum is 4. Initial bet amount for the 1st round will be $1.

You need to find and print the amount at the end of the game (final sum) and in case you do not have enough money in between the game to play the next round, then print -1.

Input:

The first line of input contains an integer T denoting the number of test cases.
The first line of each test case is a string S made of {W,L}.

Output:

Print the amount at the end of the game (final sum) and in case you have not enough money in between the game then print -1.

Constraints:

1 ≤ T ≤ 100
1 ≤ Size of string S ≤ 50

Example:

Input:
2
WL
WLWLLLWWLW

Output:
4
-1
 */
package net.jacoblo.algorithm.String;

public class BettingGame {
	public static void main(String[] args) {
		String input = "WWWWWWWW";
		int result = bettingGame( input);
		System.out.println(result);
	}
	
	public static int bettingGame(String bets) {
		if (bets == null || bets.length() <= 0) return -1;
		
		int sum = 4;
		int currentBet = 1;
		
		for ( int i = 0 ; i < bets.length() && sum > 0; i++) {
			if (bets.charAt(i) == 'W') {
				sum += currentBet;
				currentBet = 1;
			}
			else if (bets.charAt(i) == 'L') {
				sum -= currentBet;
				currentBet *= 2;
			}
		}
		
		return sum > 0 ? sum : -1;
	}
}
