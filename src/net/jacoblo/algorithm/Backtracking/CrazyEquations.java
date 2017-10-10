/**
 * MEDIUM
 * http://practice.geeksforgeeks.org/problems/crazy-equations/0/?ref=self
 * Crazy Equations
 Maths  
Jon wants to go in birthday party of Arya. But he is busy in finding solution of crazy equations, so he wants your help to solve this problem. Jon has four integers a, b, c, d now he wants to calculate how many distinct set of x, y, z, w are present such that

                                       a + b - x  == a + c - y == c + d - z == b + d - w

NOTE - 
1<= x, y, z, w<=n     where n is a given integer
Two set of x, y, z, w will be different if atleast one value will be different.

Input
First line of input contain an integer T denoting the number of test cases. Then T test cases follow. Each test case consists of a single line containing five space separated integers denoting  n, a, b, c, d in order.

Output
Print answer for each test case in separate line.

Constraints
1
1<=n<=1000000
1<=a, b, c, d <=n 

Example:
Input
1
5 1 2 2 2

Output:
4

Explanation

Sets of x, y, z, w can be
(1, 1, 2, 2)
(2, 2, 3, 3)
(3, 3, 4, 4)
(4, 4, 5, 5)
 */
package net.jacoblo.algorithm.Backtracking;

import java.util.Arrays;

public class CrazyEquations {
	public static void main(String[] args) {
		int a = 1, b = 2, c = 2, d = 1;
		int n = 10;
		int result = crazyEquations(n,a,b,c,d);
		System.out.println(result);
	}
	
	public static int crazyEquations(int n, int a, int b, int c, int d) {
		// a + b - x  == a + c - y == c + d - z == b + d - w
		int[] arr = new int[4];
		arr[0] = a+b;
		arr[1] = a+c;
		arr[2] = c+d;
		arr[3] = b+d;
		
		Arrays.sort(arr);
		
		return (arr[3] - arr[0] <= n ? n - (arr[3] - arr[0]) : 0);
	}
}
