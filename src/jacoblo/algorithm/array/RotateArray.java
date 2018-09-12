//https://www.hackerrank.com/challenges/ctci-array-left-rotation/problem
/*
 * Check out the resources on the page's right side to learn more about arrays. The video tutorial is by Gayle Laakmann McDowell, author of the best-selling interview book Cracking the Coding Interview.

A left rotation operation on an array of size  shifts each of the array's elements  unit to the left. For example, if  left rotations are performed on array , then the array would become .

Given an array of  integers and a number, , perform  left rotations on the array. Then print the updated array as a single line of space-separated integers.

Input Format

The first line contains two space-separated integers denoting the respective values of  (the number of integers) and  (the number of left rotations you must perform). 
The second line contains  space-separated integers describing the respective elements of the array's initial state.

Constraints

Output Format

Print a single line of  space-separated integers denoting the final state of the array after performing  left rotations.

Sample Input

5 4
1 2 3 4 5
Sample Output

5 1 2 3 4
Explanation

When we perform  left rotations, the array undergoes the following sequence of changes:

Thus, we print the array's final state as a single line of space-separated values, which is 5 1 2 3 4.
 */
package jacoblo.algorithm.array;

import java.util.Scanner;

public class RotateArray {
  public static void main(String[] args) {
    Scanner in = new Scanner(System.in);
    int n = in.nextInt();
    int k = in.nextInt();
    int a[] = new int[n];
    for(int a_i=0; a_i < n; a_i++){
        a[a_i] = in.nextInt();
    }
    
    int[] result = calcRotationsv2(a,k);
    
    for ( int i = 0 ; i < result.length ; i++ ) {
        System.out.print(result[i] + " ");
    }
  }
  
  // Space Complexity : O(1) 
  private static int[] calcRotationsv2(int[] orig, int numOfRotations) {
    if (orig == null || orig.length <= 0 || numOfRotations < 0) return new int[0];
    
    int temp = orig[0];
    
    for (int i = 0 ; i < orig.length ; i++) {
      int nextPos = calcLeftPos(i,numOfRotations,orig.length);
      int storage = orig[nextPos];
      orig[nextPos] = temp;
      temp = storage;
    }
    
    return orig;
  }

  //Space Complexity : O(n) 
  private static int[] calcRotations(int[] orig, int numOfRotations) {
    if (orig == null || orig.length <= 0 || numOfRotations < 0) return new int[0];
    
    int[] result = new int[orig.length];
    
    for (int i = 0 ; i < orig.length ; i++) {
      int nextPos = calcLeftPos(i,numOfRotations,orig.length);
        result[nextPos] = orig[i];
    }
    
    return result;
  }

  private static int nextPos(int currentPos, int numOfElements) {
    if (numOfElements <= 0 || currentPos < 0 || currentPos >= numOfElements ) return -1;
    
    return calcRightPos( currentPos, 1, numOfElements);
  }

  private static int calcRightPos(int currentPos, int numOfRotations, int numOfElements) {
    if (numOfRotations < 0 || numOfElements <= 0 || currentPos < 0 || currentPos >= numOfElements) return 0;
    
    int result = ( currentPos + numOfRotations ) % numOfElements;
    return result;
  }

  private static int calcLeftPos(int currentPos, int numOfRotations, int numOfElements ) {
    if (numOfRotations < 0 || numOfElements <= 0 || currentPos < 0 || currentPos >= numOfElements) return 0;
    
    int normalizedPos = numOfRotations % numOfElements;
    int newOrigPos = currentPos - normalizedPos;
    int result = newOrigPos < 0 ? newOrigPos + numOfElements : newOrigPos;
    return result;
  }
}
