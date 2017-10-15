/**
 * http://www.geeksforgeeks.org/?p=26569
 * Pascal’s triangle is a triangular array of the binomial coefficients. Write a function that takes an integer value n as input and prints first n lines of the Pascal’s triangle. Following are the first 6 rows of Pascal’s Triangle.

1  
1 1 
1 2 1 
1 3 3 1 
1 4 6 4 1 
1 5 10 10 5 1 
 *
 */
package net.jacoblo.algorithm;
public class PascalTriangle {
	public static void main(String[] args) {
		int level = 5;
		int[][] triangle = pascalTriangle(level);
		String result = pascalTriangleToString(triangle);
		System.out.println(result);
	}
	
	/**
	 * Method 2( O(n^2) time and O(n^2) extra space )
If we take a closer at the triangle, we observe that every entry is sum of the two values above it. So we can create a 2D array that stores previously generated values. To generate a value in a line, we can use the previously stored values from array.



// A O(n^2) time and O(n^2) extra space method for Pascal's Triangle

This method can be optimized to use O(n) extra space as we need values only from previous row. So we can create an auxiliary array of size n and overwrite values. Following is another method uses only O(1) extra space.



	 * @param level
	 * @return
	 */
	public static int[][] pascalTriangle(int level) {
		if (level <= 0) return new int[0][0];
		
		int[][] triangle = new int[level][level];
		
		triangle[0][0] = 1;
		
		for (int i = 0 ; i < level -1; i++ ) {
			for (int j = 0 ; j <= i ; j++) {
				triangle[i+1][j] += triangle[i][j];
				triangle[i+1][j+1] += triangle[i][j];
			}
		}
		
		return triangle;
	}
	
	public static String pascalTriangleToString(int[][] triangle) {
		if (triangle == null || triangle.length <= 0) return "";
		
		String result = "";
		for (int i = 0 ; i < triangle.length; i++ ) {
			for (int j = 0 ; j <= i ; j++ ) {
				result += triangle[i][j] + " ";
			}
			result += "\n";
		}
		
		return result;
	}
}
