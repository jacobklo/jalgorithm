/**
 * MEDIUM
 * Find the longest path in a matrix with given constraints
Given a n*n matrix where all numbers are distinct, find the maximum length path (starting from any cell) such that all cells along the path are in increasing order with a difference of 1.

We can move in 4 directions from a given cell (i, j), i.e., we can move to (i+1, j) or (i, j+1) or (i-1, j) or (i, j-1) with the condition that the adjacent cells have a difference of 1.

Example:

Input:  mat[][] = {{1, 2, 9}
                   {5, 3, 8}
                   {4, 6, 7}}
Output: 4
The longest path is 6-7-8-9. 
 */

/**
 * Largest Sum in Path in Matrix
 * Given a N X N  matrix Matrix[N][N] of positive integers.  There are only three possible moves from a cell Matrix[r][c].

1. Matrix[r+1][c]

2. Matrix[r+1][c-1]

3. Matrix[r+1][c+1]

Starting from any column in row 0, return the largest sum of any of the paths up to row N-1.

Input:
The first line of the input contains an integer T denoting the number of test cases. The description of T test cases follows.
The first line of each test case contains a single integer N denoting the order of matrix. Next line contains N*N integers denoting the elements of the matrix in row-major form.

Output:
Output the largest sum of any of the paths starting from any cell of row 0 to any cell of row N-1. Print the output of each test case in a new line.

Constraints:
1<=T<=20
2<=N<=20
1<=Matrix[i][j]<=1000 (for all 1<=i<=N && 1<=j<=N)

Example:

Input:
1
2
348 391 618 193

Output:
1009

Explanation: In the sample test case, the path leading to maximum possible sum is 391->618.  (391 + 618 = 1009)
 */

package net.jacoblo.algorithm.DynamicProgramming;

public class PathInMatrix {
  public static void main(String[] args) {
    int[][] mat = { { 1, 2, 9}, 
                    { 5, 3, 8},
                    { 4, 6, 7}};
    
    int result = longestPathInMatrixDP(mat);
    System.out.println(result);
    
    int [][] sumMat = { { 348, 391},
                        { 618, 193},
                        { 100, 200}};
    
    int sumResult = largestSumPathInMatrixDP(sumMat);
    System.out.println(sumResult);
  }
  
  public static int largestSumPathInMatrixDP(int[][] mat) {
    if (mat == null) return 0;
    
    int[][] result = new int[mat.length+1][mat[0].length];
    
    for (int i = 0 ; i < mat[0].length ; i++) {
      result[1][i] = mat[0][i];
    }
    
    for (int row = 2 ; row <= mat.length ; row++) {
    	for (int column = 0 ; column < mat[0].length ; column++) {
        int left = 0, center = 0, right = 0;
    		
    		if (column-1 >= 0) {
        	left = result[row-1][column-1];
        }
    		center = result[row-1][column];
    		if (column+1 < mat[0].length) {
    			right = result[row-1][column+1];
    		}
    		
    		int maxR = Math.max(right, Math.max(left, center));
    		result[row][column] = maxR + mat[row-1][column];
      }
    }
    
    int maxResult = 0;
    for (int column = 0 ; column < mat[0].length ; column++) {
    	if (maxResult < result[mat.length][column]) {
    		maxResult = result[mat.length][column];
    	}
    }
    
    return maxResult;
  }
  
  public static int longestPathInMatrixDP(int[][] mat) {
    if (mat == null ) return 0;
    
    int[][] moves = { { -1, 0}, // Up
        { 0, -1}, // Left
        { 1, 0},  // Down
        { 0, 1}}; // Right
    
    int[][] result = new int[mat[0].length][mat.length];
    for (int i = 0 ; i < mat.length ; i++) {
      for (int j = 0 ; j < mat[0].length ; j++) {
        result[i][j] = longestPathInMatrixDP(mat, moves, i, j);
      }
    }
    
    int max = 0;
    for (int i = 0 ; i < mat.length ; i++) {
      for (int j = 0 ; j < mat[0].length ; j++) {
        if (max < result[i][j]) {
          max = result[i][j];
        }
      }
    }
    
    return max+1;
  }
  
  private static int longestPathInMatrixDP(int[][] matrix, int[][] moves, int x, int y) {
    if (matrix == null || moves == null) return 0;
    
    // calculate all moves, see what is the sub result
    int result = 0;
    for (int m = 0 ; m < moves.length ; m++) {
      int newX = x + moves[m][0];
      int newY = y + moves[m][1];
      if (newX < 0 || newY < 0 || newX >= matrix.length || newY >= matrix[0].length) {
        continue;
      }
      if (matrix[x][y] - matrix[newX][newY] == 1) {
        int currentResult = longestPathInMatrixDP(matrix, moves, newX, newY);
        if (result <= currentResult ) {
          result = currentResult+1;
        }
      }
    }
    
    return result;
  }
}

