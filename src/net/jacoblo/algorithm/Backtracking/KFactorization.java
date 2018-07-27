
/**
 * 
 * HARD
 * https://www.hackerrank.com/challenges/k-factorization/problem
 * 
 * At the time when Pythagoreanism was prevalent, people were also focused on different ways to factorize a number. In one class, Pythagoras asked his disciples to solve one such problem, Reverse Factorization. They were given a set of integer, , and an integer . They need to find the a way to reach , starting from , and at each step multiplying current value by any element of . But soon they realised that there may exist more than one way to reach . So they decided to find a way in which number of states are least. All of sudden they started on this new problem. People solved it and then started shouting their answer. CRAP!!!. There still exists multiple answers. So finally after much consideration, they settled on the lexicographically smallest series among those solutions which contains the least number of states.
For example, if  and  then following ways exists
(a) 1  ->  2  ->  4  ->  12
       x2     x2     x3

(b) 1  ->  4  ->  12
       x4     x3

(c) 1  ->  3  ->  12
       x3     x4
Here (a) is not the minimal state, as it has  states in total. While (b) and (c) are contenders for answer, both having 3 states, (c) is lexicographically smaller than (b) so it is the answer. In this case you have to print 1 3 12. If there exists no way to reach  print -1.
Input Format
Input contains two lines where first line contains two space separated integer,  and , representing the final value to reach and the size of set , respectively. Next line contains K space integers representing the set .
Constraints


, where 
, where  AND 
Note:
Lexicographical order: If  and  are two ordered lists, then  is lexicographically smaller than  if any one of the following condition satisfies.
 AND .
 AND  AND .
You need to find the lexigraphically smallest series among those solutions which contains the least number of states.
Output Format
Print the steps to reach  if it exists. Otherwise print -1.
Sample Input 0
12 3
2 3 4
Sample Output 0
1 3 12
Explanation 0
This is the same case which is explaned above.
Sample Input 1
15 5
2 10 6 9 11
Sample Output 1
-1
Explanation 1
Here no way exists so that we can reach  starting from .
Sample Input 2
72 9
2 4 6 9 3 7 16 10 5
Sample Output 2
1 2 8 72
Explanation 2
There are multiple ways to reach 72 using these 8 numbers. Out of which following 6 ways consists of minimal states (4).
States          =>  Multiplication operation
 1   9  18  72  =>      (x9, x2, x4)
 1   4  36  72  =>      (x4, x9, x2)
 1   2   8  72  =>      (x2, x4, x9)
 1   2  18  72  =>      (x2, x9, x4)
 1   4   8  72  =>      (x4, x2, x9)
 1   9  36  72  =>      (x9, x4, x2)
As series 1 2 8 72 is lexicographically smallest, it is the answer.
 */
package net.jacoblo.algorithm.Backtracking;

import java.util.ArrayList;
import java.util.Arrays;

public class KFactorization {

  // Complete the kFactorization function below.
  static int[] kFactorization(int n, int[] A) {
    Arrays.sort(A);

    ArrayList<Integer> newA = new ArrayList<>();
    for ( int x : A) {
      newA.add(x);
    }
    ArrayList<Integer> resultLists = kFactorizationHelper(n, newA);
    if (resultLists.size() <= 0 ) {
      int[] result = new int[1];
      result[0] = -1;
      return result;
    }
    
    int[] result = new int[resultLists.size() + 1];
    result[0] = 1;
    for ( int i = 0 ; i < resultLists.size() ; i++ ) {
      result[i+1] = result[i] * resultLists.get(i);
    }
    
    return result;
  }
  
  static ArrayList<Integer> kFactorizationHelper(double n, ArrayList<Integer> A) {
    if (n <= 0 || n != (int)n || A == null || A.size() <= 0 ) return new ArrayList<>();
    
    ArrayList<ArrayList<Integer>> listOfResults = new ArrayList<>();
    for ( int i = 0 ; i < A.size(); i++ ) {
      double div = n / A.get(i);
      // if this is the answer to n, return right a way
      if ( div == 1.0) {
        ArrayList<Integer> tmpResult = new ArrayList<>();
        tmpResult.add(A.get(i));
        return tmpResult;
      }
      else {
        listOfResults.add ( kFactorizationHelper(div, A ) );
      }
    }
    
    int minElementSoFar = Integer.MAX_VALUE;
    
    // find min number of element
    for( ArrayList<Integer> result : listOfResults ) {
      if (result.size() > 0) {
        if (  result.size() < minElementSoFar ) {
          minElementSoFar = result.size();
        }else {
          result.clear();
        }
      }
    }
    
    // if no results in the list, return
    if (minElementSoFar == Integer.MAX_VALUE) {
      return new ArrayList<>();
    }
    
    // find min value of element
    int minValueIndex = 0;
    for ( int i = 0 ; i < listOfResults.size() ; i++ ) {
      if (listOfResults.get(i).size() > 0 && A.get(minValueIndex) < A.get(i)) {
        minValueIndex = i;
      }
    }
    
    ArrayList<Integer> result = new ArrayList<>();
    result.add( A.get( minValueIndex) );
    result.addAll( listOfResults.get( minValueIndex) );
    
    return result;
  }
  
  static ArrayList<Integer> cloneAndRemoveElement(ArrayList<Integer> A, int index) {
    if ( A == null || A.size() <= 0 ) return new ArrayList<>();
    ArrayList<Integer> result = new ArrayList<>();
    for ( int i = 0 ; i < A.size(); i++ ) {
      if (i != index ) {
        result.add( A.get(i) );
      }
    }
    return result;
  }

//  private static final Scanner scanner = new Scanner(System.in);

  public static void main(String[] args){
    int n = 231000000;
    int[] A = { 2, 3, 5, 7, 11, 13, 17, 19};
    
    int[] result = kFactorization(n, A);
    for ( int x : result ) {
      System.out.print(x + " " );
    }
    
    int bitNum = 9;
    String bitNumBS = Integer.toBinaryString(bitNum);
    char[] flipCS = new char[32];
    for ( int i = 31, j = bitNumBS.length() - 1 ; i >= 0 ; i-- ) {
      if ( j >= 0 ) {
        flipCS[i] = ( bitNumBS.charAt(j) == '1' ? '0' : '1' );
        j--;
      }
      else {
        flipCS[i] = '1';
      }
    }
    String flipS = new String ( flipCS );
    long flip = Long.parseLong(flipS, 2);
    System.out.println(bitNum);
    System.out.println(bitNumBS);
    System.out.println(flip);
    System.out.print(flipS);
    
//      BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));
//
//      String[] nk = scanner.nextLine().split(" ");
//
//      int n = Integer.parseInt(nk[0]);
//
//      int k = Integer.parseInt(nk[1]);
//
//      int[] A = new int[k];
//
//      String[] AItems = scanner.nextLine().split(" ");
//      scanner.skip("(\r\n|[\n\r\u2028\u2029\u0085])?");
//
//      for (int i = 0; i < k; i++) {
//          int AItem = Integer.parseInt(AItems[i]);
//          A[i] = AItem;
//      }
//
//      int[] result = kFactorization(n, A);
//
//      for (int i = 0; i < result.length; i++) {
//          bufferedWriter.write(String.valueOf(result[i]));
//
//          if (i != result.length - 1) {
//              bufferedWriter.write(" ");
//          }
//      }
//
//      bufferedWriter.newLine();
//
//      bufferedWriter.close();
//
//      scanner.close();
  }
}