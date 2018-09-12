
/**
 * http://practice.geeksforgeeks.org/problems/remove-minimum-elements/0
 * Medium
 * Remove minimum elements
   Hide Topic Tags  Array      Amazon
Given an unsorted array, trim the array such that twice of minimum is greater than maximum in the trimmed array. Elements should be removed either end of the array. Number of removals should be minimum.

Input:

The first line of input contains an integer T denoting the number of test cases.
The first line of each test case is N,N is the size of array.
The second line of each test case contains N input A[i],numbers in array.

Output:

Print the minimum number of removals.

Constraints:

1 <= T <= 50
1 <= N <= 1000
1 <= A[i] <= 1000

Example:

Input
1
9
4 5 100 9 10 11 12 15 200

Output
4
 */
package jacoblo.algorithm.array;

import java.util.ArrayList;
import java.util.Collections;

public class RemoveMinimumElements {
  public static void main(String[] args) {
    int[] array = {4, 5, 100, 9, 10, 11, 12, 15, 200};
    // { 20, 4,1,3 };
    int result = removeMinElements(array);
    System.out.println(result);
  }
  
  public static int removeMinElements(int[] array) {
    if (array == null || array.length <= 1 ) return Integer.MIN_VALUE;
       
    ArrayList<Integer> arrayList = new ArrayList<>();
    for (int i = 0 ; i < array.length ; i++ ) {
      arrayList.add(array[i]);
    }
    Collections.sort(arrayList);
    
    int currentMinIndex = array.length / 2-1;
    int currentMaxIndex = currentMinIndex + 1;
    
    boolean conditionSoFar = arrayList.get(0) * 2 > arrayList.get(arrayList.size()-1);
    while (conditionSoFar) {
      conditionSoFar = false;
      if (currentMinIndex-1 >= 0) {
        arrayList.remove(array[currentMinIndex-1]);
        if (arrayList.get(0) * 2 > arrayList.get(arrayList.size()-1)) {
          currentMinIndex--;
          conditionSoFar = true;
        }
        else {
          arrayList.add(array[currentMinIndex-1]);
        }
        Collections.sort(arrayList);
      }
      if (currentMaxIndex+1 < array.length) {
        arrayList.remove(array[currentMaxIndex+1]);
        if (arrayList.get(0) * 2 > arrayList.get(arrayList.size()-1)) {
          currentMaxIndex++;
          conditionSoFar = true;
        }
        else {
          arrayList.add(array[currentMaxIndex+1]);
        }
        Collections.sort(arrayList);
      }
    }
    
    if (array[currentMinIndex] * 2 > array[currentMaxIndex]) {
      return array.length - ( currentMaxIndex - currentMinIndex + 1 );
    }
    return Integer.MIN_VALUE;
  }
}
