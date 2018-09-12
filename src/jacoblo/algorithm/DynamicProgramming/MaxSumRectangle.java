
/**
 * http://practice.geeksforgeeks.org/problems/maximum-sum-rectangle/0
 * Maximum sum Rectangle
   
MEDIUM
Given a 2D array, find the maximum sum subarray in it. For example, in the following 2D array, the maximum sum subarray is highlighted with blue rectangle and sum of this subarray is 29.

                                                          

Input:
First line of every test case consists of T test case. First line of every test case consists of 2 integers R and C , denoting number of rows and columns. Second line consists of R*C spaced integers denoting number of elements in array.

Output:
Single line output, print the Max sum forming a rectangle in a 2-D matrix

Example:
Input:
1
4 5
1 2 -1 -4 -20 -8 -3 4 2 1 3 8 10 1 3 -4 -1 1 7 -6
Ouptut:
29
 */
package jacoblo.algorithm.DynamicProgramming;

import java.util.Hashtable;

public class MaxSumRectangle {
	public static void main(String[] args) {
		int[][] matrix = { { 1, 2, -1, -4, -20 }
											,{ -8, -3, 4, 2, 1, }
											,{ 3, 8, 10, 1, 3 }
											,{ -4, -1, 1, 7, -6 } };
		
		int result = maxSumRectangle(matrix);
		System.out.println(result);
		
	}
	
	public static int maxSumRectangle( int[][] matrix ) {
		if (matrix == null || matrix.length <= 0 || matrix[0].length <= 0 ) return 0;
		
		int[][] result = new int[matrix.length][matrix[0].length];
		
		Hashtable<SubMatrixData,Integer> hash = new Hashtable<>();
		
		for ( int i = 0 ; i < matrix.length ; i++ ) {
			for ( int j = 0 ; j < matrix[i].length ; j++ ) {
				result[i][j] = maxSumRectangle(matrix,hash,i,j,i,j);
			}
		}
		
		int max = 0;
		for ( int i = 0 ; i < matrix.length ; i++ ) {
			for ( int j = 0 ; j < matrix[i].length ; j++ ) {
				if (result[i][j] > max) {
					max = result[i][j];
				}
			}
		}
		return max;
	}
	
	public static int maxSumRectangle(int[][] matrix, Hashtable<SubMatrixData,Integer> hash, int fromRow, int fromColumn, int toRow, int toColumn ) {
		if (hash == null || fromRow < 0 || fromRow >= matrix.length || toRow < 0 || toRow >= matrix.length
				|| fromColumn < 0 || fromColumn >= matrix[0].length || toColumn < 0 || toColumn >= matrix[0].length ) return 0;
		
		SubMatrixData smd = new SubMatrixData(fromRow,fromColumn, toRow, toColumn );
		
		if (hash.containsKey(smd)) {
			return hash.get(smd);
		}
		
		int sumOfCurrentRectangle = sumOfSubMatrix(matrix, fromRow, fromColumn, toRow, toColumn );
		int sumOfUpOneRectangle = maxSumRectangle(matrix, hash, fromRow-1, fromColumn, toRow, toColumn );
		int sumOfDownOneRectangle = maxSumRectangle(matrix, hash, fromRow, fromColumn, toRow+1, toColumn );
		int sumOfLeftOneRectangle = maxSumRectangle(matrix, hash, fromRow, fromColumn-1, toRow, toColumn );
		int sumOfRightOneRectangle = maxSumRectangle(matrix, hash, fromRow, fromColumn, toRow, toColumn+1 );
		
		int result = Math.max(sumOfCurrentRectangle, 
				Math.max(sumOfUpOneRectangle,
				Math.max(sumOfDownOneRectangle,
				Math.max(sumOfLeftOneRectangle, sumOfRightOneRectangle))));
		
		hash.put(smd, result);
		return result;
	}
	
	public static int sumOfSubMatrix(int[][] matrix, int fromRow, int fromColumn, int toRow, int toColumn ) {
		int sum = 0;
		for ( int i = fromRow ; fromRow >= 0 && toRow < matrix.length && i <= toRow ; i++ ) {
			for ( int j = fromColumn ; fromColumn >= 0 && toColumn < matrix[i].length && j <= toColumn ; j++ ) {
				sum += matrix[i][j];
			}
		}
		return sum;
	}
	
	private static class SubMatrixData {
		public int fromRow, fromColumn, toRow, toColumn;
		
		public SubMatrixData ( int fr, int fc, int tr, int tc ) {
			fromRow = fr;
			toRow = tr;
			fromColumn = fc;
			toColumn = tc;
		}
		
		@Override
		public int hashCode() {
			return toColumn + fromColumn * 100 + toRow * 10000 + fromRow * 1000000;
		}
		
		@Override
		public boolean equals(Object o) {
			if (o == null || !(o instanceof SubMatrixData))	return false;
			SubMatrixData s = (SubMatrixData) o;
			return fromRow == s.fromRow && fromColumn == s.fromColumn && toRow == s.toRow && toColumn == s.toColumn;
		}
	}
}
