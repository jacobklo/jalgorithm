
/**
 * EASY
 * https://www.hackerrank.com/challenges/closest-numbers/problem
 * 
 * Sorting is useful as the first step in many different tasks. The most common task is to make finding things easier, but there are other uses as well. In this case, it will make it easier to determine which pair or pairs of elements have the smallest absolute difference between them.
For example, if you've got the list , sort it as  to see that several pairs have the minimum difference of : . The return array would be .
Given a list of unsorted integers, , find the pair of elements that have the smallest absolute difference between them. If there are multiple pairs, find them all.
Function Description
Complete the closestNumbers function in the editor below. It must return an array of integers as described.
closestNumbers has the following parameter(s):
arr: an array of integers
Input Format
The first line contains a single integer , the length of . 
The second line contains  space-separated integers, .
Constraints


All  are unique in .
Output Format
Output the pairs of elements with the smallest difference. If there are multiple pairs, output all of them in ascending order, all on the same line with just a single space between each pair of numbers. A number may be part of two pairs when paired with its predecessor and its successor.
Sample Input 0
10
-20 -3916237 -357920 -3620601 7374819 -7330761 30 6246457 -6461594 266854 
Sample Output 0
-20 30
Explanation 0 
(30) - (-20) = 50, which is the smallest difference.
Sample Input 1
12
-20 -3916237 -357920 -3620601 7374819 -7330761 30 6246457 -6461594 266854 -520 -470 
Sample Output 1
-520 -470 -20 30
Explanation 1 
(-470) - (-520) = 30 - (-20) = 50, which is the smallest difference.
Sample Input 2
4
5 4 3 2
Sample Output 2
2 3 3 4 4 5
Explanation 2 
Here, the minimum difference will be 1. Valid pairs are (2, 3), (3, 4), and (4, 5). We print the elements of each pair, space-separated on a single line.
 */
package jacoblo.algorithm.Sorting;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Comparator;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collectors;

public class ClosestNumbers{

    static int current_smallest_pair = Integer.MAX_VALUE;
    
    // Complete the closestNumbers function below.
    static int[] closestNumbers(int[] arr) {
      
      List<Integer> arrList = Arrays.stream(arr).boxed().collect(Collectors.toList());
      ArrayList<Integer> result = closestNumbers(arrList);
      return result.stream().mapToInt(i ->(int)i).toArray();
    }
    
    static ArrayList<Integer> closestNumbers(List<Integer> arrList) {
      if ( arrList == null || arrList.size() <= 0 ) return new ArrayList<>();
      
      // sort the array first
      Collections.sort(arrList, new Comparator<Integer>() {

        @Override
        public int compare(Integer o1, Integer o2) {
          int currentSmallest = Math.abs(o1 - o2);
          if ( currentSmallest < current_smallest_pair) {
            current_smallest_pair = currentSmallest;
          }
          return o1 - o2;
        }
        
      });
      
      // Compare each pair again to see which one is smallest
      ArrayList<Integer> result = new ArrayList<>();
      for ( int i = 1 ; i < arrList.size() ; i++ ) {
        int firstElement = arrList.get(i-1);
        int secondElement = arrList.get(i);
        
        if (Math.abs(firstElement - secondElement) == current_smallest_pair) {
          result.add(firstElement);
          result.add(secondElement);
        }
      }
      
      return result;
    }

    private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args) throws IOException {
        /*
        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

        int n = scanner.nextInt();
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

        int[] arr = new int[n];

        String[] arrItems = scanner.nextLine().split(" ");
        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");

        for (int i = 0; i < n; i++) {
            int arrItem = Integer.parseInt(arrItems[i]);
            arr[i] = arrItem;
        }

        int[] result = closestNumbers(arr);

        for (int i = 0; i < result.length; i++) {
            bufferedWriter.write(String.valueOf(result[i]));

            if (i != result.length - 1) {
                bufferedWriter.write(" ");
            }
        }

        bufferedWriter.newLine();

        bufferedWriter.close();

        scanner.close();
        */
      
      int[] numbers = {-20, -3916237, -357920, -3620601, 7374819, -7330761, 30, 6246457, -6461594, 266854, -520, -470 };
      int[] numbers2 = {-5, 15, 25, 71, 63};
      int[] result = closestNumbers(numbers2);
      for ( int i = 0 ; i < result.length; i++ ) {
        System.out.println(result[i]);
      }
    }
}

