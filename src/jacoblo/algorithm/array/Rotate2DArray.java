
/**
 * http://practice.geeksforgeeks.org/problems/rotate-a-2d-array-without-using-extra-space/0
 * Medium
 * Rotate a 2D array without using extra space
Show Topic Tags         Amazon    Facebook    Google
You are given an n x n 2D matrix representing an image.

Rotate the image by 90 degrees (clockwise).

You need to do this in place.

Note that if you end up using an additional array, you will only receive partial score.

Example:

If the array is 

1 2 3 4 5 6 7 8 9

Then the rotated array becomes: 

7 4 1 8 5 2 9 6 3

Input:

The first line contains an integer 'T' denoting the total number of test cases.
In each test cases, the first line contains an integer 'N' denoting the size of the 2D square matrix.

And in the second line, the elements of the matrix A[][], each separated by a space in row major form.


Output:

For each test case, print the elements of the rotated array row wise, each element separated by a space. Print the output of each test case in a new line.


Constraints:

1 <= T <= 70
1 <= N <= 10
1 <= A [ i ][ j ] <= 100


Example:

Input:

2
3
1 2 3 4 5 6 7 8 9
2
56 96 91 54

Output:

7 4 1 8 5 2 9 6 3
91 56 54 96
 */
package jacoblo.algorithm.array;

public class Rotate2DArray {
  public static void main(String[] args) {
    int[][] array = { { 1, 2, 3 },
                      { 4, 5, 6 },
                      { 7, 8, 9 } };
    
    int[][] finish = {  { 7, 4, 1 },
                        { 8, 5, 2 },
                        { 9, 6, 3 } };
    
    int[][] result = rotate2DArray90DegreeInPlace(array);
    
  }
  
  public static String printMatrix(int[][] array) {
    if (array == null || array.length <= 0 ) return "";
    
    String s = "";
    for ( int i = 0 ; i < array.length ; i++ ) {
      for (int j = 0 ; j < array[0].length ; j++ ) {
        s += array[i][j] + " ";
      }
    }
    
    return s;
  }
  
  public static int[][] rotate2DArray90DegreeInPlace(int[][] array) {
    if (array == null || array.length <= 0 ) return new int[0][0];
    
    for ( int i = 0 ; i < array.length /2; i++ ) {
      for (int j = 0 ; j < array[0].length ; j++ ) {
        swap(array,i,j,(array.length-1)-i, j);
      }
    }
    
    for ( int i = 0 ; i < array.length ; i++ ) {
      for ( int j = i ; j < array.length ; j++ ) {
        swap(array,i,j,j,i);
      }
    }
    return array;
  }
  
  public static void swap(int[][] array, int x1, int y1, int x2, int y2 ) {
    if (array == null || array.length <= 0 || x1 < 0 || x2 < 0 || y1 < 0 || y2 < 0 || x1 >= array.length || x2 >= array.length || y1 >= array[0].length || y2 >= array.length ) return;
    
    int tmp = array[x1][y1];
    array[x1][y1] = array[x2][y2];
    array[x2][y2] = tmp;
  }
}
