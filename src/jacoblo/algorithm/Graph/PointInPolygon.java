
/*

https://www.geeksforgeeks.org/how-to-check-if-a-given-point-lies-inside-a-polygon/

 */
package jacoblo.algorithm.Graph;

import java.util.List;

public class PointInPolygon {
  /*
  Assume the vertices is sorted, edge by edge. where v0-v1 is edge 1, v1-v2 is edge 2
   */
  public static boolean calcPointInPolygon(double x, double y, List<Double> verticesX, List<Double> verticesY) {

    if ( verticesX == null || verticesY == null || verticesX.size() != verticesY.size()) {
      return false;
    }

    /// REMEMBER : Ray cast Algorithm
    // Imagine a ray bean shine from the point to the right ( any direction is fine, but only one direction )
    // the number of ray it hits an edge, can determine is the point inside or not. odd is inside, even is outside.
    int result = 0;
    for ( int i = 0 ; i < verticesX.size() ; i++ ) {
      int nextIndex =  i == verticesX.size() - 1 ? 0 : i+1;
      System.out.println("[ " + x + ", " + y + " ] on ( " + verticesX.get(i) + ", " + verticesY.get(i) + " ) -- ( " + verticesX.get(nextIndex) + ", " + verticesY.get(nextIndex) + " )");

      // This is the ray bean to the right
      if ( ( verticesX.get(i) + verticesX.get(nextIndex) ) / 2 > x) {
        // if the ray bean intersect the edge, add to result
        if ( y <= verticesY.get(i) && y >= verticesY.get(nextIndex)
          || y >= verticesY.get(i) && y <= verticesY.get(nextIndex) ) {
          System.out.print("[y" + y + " <= " + verticesY.get(i) + " & >= " + verticesY.get(nextIndex) + "]\n");
          result++;
        }
      }
    }

    System.out.println("->" + result  );
    return (result % 2) != 0;
  }

}
