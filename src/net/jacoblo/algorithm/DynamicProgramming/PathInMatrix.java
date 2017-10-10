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

package net.jacoblo.algorithm.DynamicProgramming;

public class PathInMatrix {
  public static void main(String[] args) {
    int[][] mat = { { 1, 2, 9}, 
                    { 5, 3, 8},
                    { 4, 6, 7}};
    
    
    int result = longestPathInMatrixDP(mat);
    System.out.println(result);
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

