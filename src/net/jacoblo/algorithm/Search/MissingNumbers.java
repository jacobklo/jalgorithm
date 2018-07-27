
/**
 * EASY
 * https://www.hackerrank.com/challenges/missing-numbers/problem
 * 
 * Numeros the Artist had two lists that were permutations of one another. He was very proud. Unfortunately, while transporting them from one exhibition to another, some numbers were lost out of the first list. Can you find the missing numbers?
Notes
If a number occurs multiple times in the lists, you must ensure that the frequency of that number in both lists is the same. If that is not the case, then it is also a missing number.
You have to print all the missing numbers in ascending order.
Print each missing number once, even if it is missing multiple times.
The difference between maximum and minimum number in the second list is less than or equal to .
Input Format
There will be four lines of input:
 - the size of the first list,  
The next line contains  space-separated integers  
 - the size of the second list,  
The next line contains  space-separated integers 
Constraints




Output Format
Output the missing numbers in ascending order.
Sample Input
10
203 204 205 206 207 208 203 204 205 206
13
203 204 204 205 206 207 205 208 203 206 205 206 204
Sample Output
204 205 206
Explanation
 is present in both arrays. Its frequency in  is , while its frequency in  is . Similarly,  and  occur twice in , but three times in . The rest of the numbers have the same frequencies in both lists.
 */
package net.jacoblo.algorithm.Search;

import java.util.ArrayList;

public class MissingNumbers{

    // Complete the missingNumbers function below.
    static int[] missingNumbers(int[] arr, int[] brr) {
      int min = Integer.MAX_VALUE, max = Integer.MIN_VALUE;
      for ( int i = 0 ; i < arr.length; i++ ) {
        if (min > arr[i]) {
          min = arr[i];
        }
        if ( max < arr[i] ) {
          max = arr[i];
        }
      }
      for ( int i = 0 ; i < brr.length; i++ ) {
        if (min > brr[i]) {
          min = brr[i];
        }
        if ( max < brr[i] ) {
          max = brr[i];
        }
      }
      
      int[] abuck = new int[max-min + 1];
      int[] bbuck = new int[max-min + 1];
      
      for ( int i = 0 ; i < arr.length; i++ ) {
        abuck[ arr[i] - min ]++;
      }
      for ( int i = 0 ; i < brr.length; i++ ) {
        bbuck[ brr[i] - min ]++;
      }
      
      ArrayList<Integer> result = new ArrayList<>();
      for ( int i = 0 ; i < abuck.length ; i++ ) {
        if (abuck[i] != bbuck[i] ) {
          result.add(i+min);
        }
      }
      
      int[] resultInt = new int[ result.size() ];
      for ( int i = 0 ; i < resultInt.length ; i++ ) {
        resultInt[i] = result.get(i);
      }
      
      return resultInt;
    }

    // private static final Scanner scanner = new Scanner(System.in);

    public static void main(String[] args)  {
      int[] arr = { 203, 204, 205, 206, 207, 208, 203, 204, 205, 206 };
      int[] brr = { 203, 204, 204, 205, 206, 207, 205, 208, 203, 206, 205, 206, 204 } ;
      
      int[] result = missingNumbers(arr,brr);
      for ( int r : result ) {
        System.out.print(r + " ");
      }
      
//        BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));
//
//        int n = scanner.nextInt();
//        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");
//
//        int[] arr = new int[n];
//
//        String[] arrItems = scanner.nextLine().split(" ");
//        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");
//
//        for (int i = 0; i < n; i++) {
//            int arrItem = Integer.parseInt(arrItems[i]);
//            arr[i] = arrItem;
//        }
//
//        int m = scanner.nextInt();
//        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");
//
//        int[] brr = new int[m];
//
//        String[] brrItems = scanner.nextLine().split(" ");
//        scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");
//
//        for (int i = 0; i < m; i++) {
//            int brrItem = Integer.parseInt(brrItems[i]);
//            brr[i] = brrItem;
//        }
//
//        int[] result = missingNumbers(arr, brr);
//
//        for (int i = 0; i < result.length; i++) {
//            bufferedWriter.write(String.valueOf(result[i]));
//
//            if (i != result.length - 1) {
//                bufferedWriter.write(" ");
//            }
//        }
//
//        bufferedWriter.newLine();
//
//        bufferedWriter.close();
//
//        scanner.close();
    }
}