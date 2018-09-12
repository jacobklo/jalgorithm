
/**
 * http://practice.geeksforgeeks.org/problems/count-of-n-digit-numbers-whose-sum-of-digits-equals-to-given-sum/0
 * Count of n digit numbers whose sum of digits equals to given sum
 * MEDIUM
 * Not Pass
 * Given two integers ‘n’ and ‘sum’, find count of all n digit numbers with sum of digits as ‘sum’. Leading 0’s are not counted as digits. Print your output % 10^9+7.

Input:
The first line contains an integer T, depicting total number of test cases. 
Then following T lines contains 2 integers n and sum.

Output:
Print the number of digits. Print -1 if answer is not possible.

Constraints:
1<=T<=30
1<=n<=100
1<=sum<=1000

Example:
Input:
1
2 2

Output:
2

Explaination:  2 numbers 11 and 20.
 */
package jacoblo.algorithm.DynamicProgramming;

public class CountNWaysToSumDigits {
	public static void main(String[] args) {
		int numOfDigits = 2;
		int sum = 5;
		
		long result = countNWaysToSumDigitsDP( numOfDigits, sum);
		System.out.println(result);
	}
	
	
	
	public static int countNWaysToSumDigitsDP(int numOfDigits, int sum ) {
		if (numOfDigits <= 0 || sum <= 0) return 0;
		
		long[][] lookups = new long[numOfDigits][sum];
		for (int i = 0 ; i < numOfDigits ; i++) {
			for ( int j = 0 ; j < sum ; j++ ) {
				lookups[i][j] = -1;
			}
		}
		
		int count = 0;
		// count each digit
		for ( int i = 1 ; i <= sum && i <= 9; i++ ) {
			count += countNWaysToSumDigitsDP(lookups, numOfDigits-1,sum-i );
		}
		
		return count;
	}
	
	private static long countNWaysToSumDigitsDP(long[][] lookups,int numOfDigits, int sum) {
		if (numOfDigits == 0)
       return sum == 0 ? 1 : 0;
  
    if (lookups[numOfDigits][sum] != -1)
       return lookups[numOfDigits][sum];
  
    int count = 0;
  
    for (int i=0; i <= sum && i <= 9; i++)
    	count += countNWaysToSumDigitsDP(lookups,numOfDigits-1, sum-i);
  
    return lookups[numOfDigits][sum] = count;
	}
	
	public static long countNWaysToSumDigitsRecursiveDP( int numOfDigits, int sum) {
		if (numOfDigits <= 0 || sum <= 0) return 0;
		
		if (numOfDigits == 1) return (sum > 9 ? 0 : 1);
		
		int count = 0;
		// count each digit
		for ( int i = 0 ; i <= sum && i <= 9; i++ ) {
			count += countNWaysToSumDigitsRecursiveDP(numOfDigits-1,sum-i );
		}
		
		return count;
	}
}
