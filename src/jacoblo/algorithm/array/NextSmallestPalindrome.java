
/**
 * http://practice.geeksforgeeks.org/problems/next-smallest-palindrome/0
 * MEDIUM
 * Next Smallest Palindrome

Given a number, find the next smallest palindrome.

Input :
 The first line is number of test cases, second is size of array, third line contains digits of number with spaces in between.The input is assumed to be an array. Every entry in array represents a digit in input number. Let the array be ‘num[ ]’ and size of array be ’n’. Size of the number can be upto 1000 digits.

Output:
 In each separate line print the digits of palindrome with spaces in between.

Constraints: 
1<=T<=100
1<=n<=1000
1<=a[i]<=9

Example: 
Input: 
1
11
9 4 1 8 7 9 7 8 3 2 2

Output: 
9 4 1 8 8 0 8 8 1 4 9
 */
package jacoblo.algorithm.array;

public class NextSmallestPalindrome {
	public static void main(String[] args) {
		int[][] array = { { 7, 4, 3, 3, 5, 4, 3, 2, 5, 7, 7, 3, 6, 5, 7, 3, 7, 2, 2, 4, 6, 2, 6, 5, 3, 4, 8, 3, 4, 8, 2, 5, 8, 6, 3 }
										 ,{ 9, 4, 1, 8, 7, 9, 7, 8, 3, 2, 2 } , { 1, 2, 3, 4 } , { 1, 2, 3, 4, 5 } };
		int[][] checks= { { 7, 4, 3, 3, 5, 4, 3, 2, 5, 7, 7, 3, 6, 5, 7, 3, 7, 2, 7, 3, 7, 5, 6, 3, 7, 7, 5, 2, 3, 4, 5, 3, 3, 4, 7 }
											,{ 9, 4, 1, 8, 8, 0, 8, 8, 1, 4, 9 } , { 1, 3, 3, 1 } , { 1, 2, 4, 2, 1 }};
		
		for (int i = 1 ; i < array.length ; i++ ) {
			int[] result = nextSmallestPalindrome(array[i]);
			if (compare(result, checks[i]) == 0) {
				System.out.println("correct");
			}
			else {
				System.out.println("INCORRECT " + printIntArray(result));
			}
		}
		
	}
	
	public static int[] nextSmallestPalindrome(int[] array) {
		if (array == null || array.length <= 0 ) return new int[0];
		
		int[] result = new int[array.length];
		for ( int i = 0 ; i < array.length ; i++ ) {
			result[i] = array[i];
		}
		
		if (!isPalindrome(result) ) {
			for ( int j = 0 ; j < array.length / 2 ; j++ ) {
				result[array.length-1-j] = result[j];
			}
		}
		
		for ( int i = array.length / 2 ; i >= 0 ; i-- ) {
			if (isPalindrome(result) && compare(array, result) < 0) {
				return result;
			}
			
			int currentMiddleIndex = i;
			if (array.length % 2 == 0) {
				currentMiddleIndex--;
			}
			result[currentMiddleIndex] = (result[currentMiddleIndex] + 1) % 10;
			
			
			for ( int startZero = currentMiddleIndex+1 ; startZero < array.length / 2 ; startZero++ ) {
				result[startZero] = 0;
			}
			
			for ( int j = 0 ; j < array.length / 2 ; j++ ) {
				result[array.length-1-j] = result[j];
			}
			
		}
		return result;
		
	}
	
	private static int compare(int[] a1, int[] a2) {
		if (a1 == null || a1.length <= 0 ) return Integer.MIN_VALUE;
		if (a2 == null || a2.length <= 0 ) return Integer.MAX_VALUE;
		if (a1.length < a2.length ) return Integer.MIN_VALUE;
		if (a1.length > a2.length ) return Integer.MAX_VALUE;
		
		for ( int i = 0 ; i < a1.length ; i++ ) {
			if (a1[i] != a2[i]) {
				return (int) ((a1[i] - a2[i]) * Math.pow( 10,(a1.length - i )-1));
			}
		}
		
		return 0;
	}
	
	private static boolean isPalindrome(int[] array) {
		if (array == null || array.length <= 0 ) return false;
		for ( int i = 0, j = array.length - 1; i < j ; i++,j-- ) {
			if (array[i] != array[j] ) {
				return false;
			}
		}
		return true;
	}
	
	public static String printIntArray(int[] array) {
		if (array == null || array.length <= 0 ) return "";
		String s = "";
		for (int i = 0 ; i < array.length ; i++ ) {
			s += array[i] + " ";
		}
		return s;
	}
}
