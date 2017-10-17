package net.jacoblo.algorithm.DynamicProgramming;

public class RegionsInMatrix {
  public static void main(String[] args) {
    int[][] mat = { { 0, 0, 1, 1, 0 },
                    { 1, 0, 1, 1, 0 },
                    { 0, 1, 0, 0, 0 },
                    { 0, 0, 0, 0, 1 } };
    
    
    int result = largestRegionInMatrix(mat);
    System.out.println(result);
  }
  
  public static int largestRegionInMatrix(int[][] matrix) {
    if (matrix == null || matrix.length <= 0 || matrix[0].length <= 0 ) return 0;
    
    int[][] moves =  {  { -1, -1 }, { 0, -1 }, { 1, -1 },
                        { -1, 0 }, { 0, 0 }, { 1, 0 },
                        { -1, 1 }, { 0, 1 }, { 1, 1 } };
    
    int[][] result = new int[matrix.length][matrix[0].length];
    
    for ( int i = 0 ; i < matrix.length ; i++ ) {
      for ( int j = 0 ; j < matrix[0].length ; j++ ) {
        int[][] largestRegionForEach = new int[matrix.length][matrix[0].length];
        result[i][j] = largestRegionInMatrix(matrix, moves,largestRegionForEach, i, j);
      }
    }
    
    int resultMaxRegion = 0;
    for ( int i = 0 ; i < matrix.length ; i++ ) {
      for ( int j = 0 ; j < matrix[0].length ; j++ ) {
        if ( resultMaxRegion < result[i][j] ) {
          resultMaxRegion = result[i][j];
        }
      }
    }
    
    return resultMaxRegion;
  }
  
  public static int largestRegionInMatrix(int[][] matrix, int[][] moves, int[][] recursiveConstraint, int currentRow, int currentColumn ) {
    if (matrix == null || matrix.length <= 0 || matrix[0].length <= 0 || moves == null || moves.length <= 0 || moves[0].length <= 0 
        || recursiveConstraint == null || recursiveConstraint.length <= 0 || recursiveConstraint[0].length <= 0 
        || currentRow < 0 || currentRow >= matrix.length || currentColumn < 0 || currentColumn >= matrix[0].length ) return 0;
    
    if (matrix[currentRow][currentColumn] < 1 ) {
      return 0;
    }
    // temporary set to -2 first, so it will not end up being infinite loop
    recursiveConstraint[currentRow][currentColumn] = -2;
    
    int resultRegion = 0;
    for ( int i = 0 ; i < moves.length ; i++ ) {
      int newRow = currentRow + moves[i][0];
      int newColumn = currentColumn + moves[i][1];
      
      if ( newRow < 0 || newRow >= matrix.length || newColumn < 0 || newColumn >= matrix[0].length 
          || recursiveConstraint[newRow][newColumn] != 0) {
        continue;
      }
      resultRegion += largestRegionInMatrix(matrix,moves,recursiveConstraint, newRow, newColumn);
    }
    
    resultRegion++;
    return resultRegion;
  }
}
