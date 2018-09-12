
/**
 * http://practice.geeksforgeeks.org/problems/facing-the-sun/0
 * EASY
 * Facing the sun
   Hide Topic Tags  Array  Searching      Amazon
An array of buildings is facing the sun. The heights of the building is given in an array. You have to tell which all buildings will see the sunset.

Input:

The first line of input contains an integer T denoting the number of test cases.
The first line of each test case is N,N is the number of buildings.
The second line of each test case contains N input H[i],height of building.

Output:

Print the total number of buildings which will see the sunset.

Constraints:

1 <= T <= 100
1 <= N <= 500
1 <= H[i] <= 1000

Example:

Input:
2
5
7 4 8 2 9
4
2 3 4 5

Output:
3
4
 */
package jacoblo.algorithm;

public class FacingTheSun {
  public static void main(String[] args) {
    int[] buildings = { 2,3,4,5 };
    int result = facingTheSun(buildings);
    System.out.println(result);
  }
  
  public static int facingTheSun(int[] buildings) {
    if (buildings == null || buildings.length <= 0 ) return 0;
    
    int numOfbuildingsFacingSun = 0;
    int tallest = 0;
    
    for (int b : buildings) {
      if (tallest < b) {
        numOfbuildingsFacingSun++;
        tallest = b;
      }
    }
    
    return numOfbuildingsFacingSun;
  }
}
