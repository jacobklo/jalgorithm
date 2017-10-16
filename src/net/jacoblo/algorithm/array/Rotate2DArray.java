package net.jacoblo.algorithm.array;

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
