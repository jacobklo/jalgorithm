/**
 * http://practice.geeksforgeeks.org/problems/element-that-appears-once-where-every-element-occurs-twice/0
 * Easy
 * Given an array of integers, every element appears twice except for one. Find that single one in linear time complexity and without using extra memory.

 

Input:

The first line of input consists number of the test cases. The description of T test cases is as follows:

The first line of each test case contains the size of the array, and the second line has the elements of the array.

 


Output:

In each separate line print the number that appears only once in the array.


Constraints:

1 ≤ T ≤ 70
1 ≤ N ≤ 100
0 ≤ A[i] ≤ 100000


Example:

Input:

1
11
1 2 4 3 3 2 5 6 1 6 5

Output:

4


 */

package jacoblo.algorithm.BitAlgorithm;

public class FindOneElementWhenOthersAppearTwice {
	public static void main(String[] args) {
		int[] arr = {1, 2, 4, 3, 3, 2, 5, 6, 1, 6, 5 };
		int result = findOneElementWhenOthersAppearTwice(arr);
		System.out.println(result);
	}
	
	public static int findOneElementWhenOthersAppearTwice(int[] arr) {
		if (arr == null || arr.length <= 0) return 0;
		
		for (int i = 1 ; i < arr.length ; i++) {
			arr[0] ^= arr[i];
		}
		
		return arr[0];
	}
}
