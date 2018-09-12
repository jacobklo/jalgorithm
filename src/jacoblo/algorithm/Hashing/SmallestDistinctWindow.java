
/**
 * http://practice.geeksforgeeks.org/problems/smallest-distant-window/0
 * Medium
 * 
 * Given a string detect the smallest window length that contains all the distinct characters of the given string even if it contains repeating element
For eg. A = �aabcbcdbca�, then the result would be 4 as of the smallest window will be �dbca� .

Another example, in �aabcbcdb�, the smallest string that contains all the characters is �abcbcd�.

Input:
The first line of input contains an integer T denoting the no of test cases. Then T test cases follow. Each test case contains a string S.

Output:
For each test case in a new line print the length of the smallest such string.

Constraints:
1<=T<100
1<=|S|<=1000

Example:
Input:
2
aabcbcdbca
aaab

Output:
4
2
 */
package jacoblo.algorithm.Hashing;

import java.util.Hashtable;

public class SmallestDistinctWindow {
  public static void main(String[] args) {
    String in = "qwertqwer";
    String result = smallestDistinctWindow(in);
    System.out.println(result);
  }
  
  public static String smallestDistinctWindow(String input) {
    if (input == null || input.length() <= 0) return "";
    
    int numOfDistinctChars = 0;
    Hashtable<Character,Integer> hash = new Hashtable<>();
    for (int i = 0 ; i < input.length() ; i++) {
      if (!hash.containsKey(input.charAt(i))) {
        hash.put(input.charAt(i), i);
      }
    }
    numOfDistinctChars = hash.size();
    
    int[] result = new int[input.length()+1];
    
    for (int i = 0 ; i < input.length() ; i++ ) {
      hash.clear();
      OUTER:
      for (int j = i ; j < input.length(); j++ ) {
        if (hash.size() < numOfDistinctChars && !hash.containsKey(input.charAt(j))) {
          hash.put(input.charAt(j), j);
        }
        if (hash.size() == numOfDistinctChars) {
          result[i] = j - i;
          break OUTER;
        }
      }
      
    }
    
    int res = result[0];
    int resIndex = 0;
    for (int i = 1 ; i < result.length ; i++ ) {
      if (result[i] > 0 && res > result[i]) {
        res = result[i];
        resIndex = i;
      }
    }
    
    return input.substring(resIndex, resIndex+res+1);
  }
  
  public static String LongestDistinctCharacter(String input) {
    if (input == null || input.length() <= 0) return "";
    
    int maxDigit = 0;
    int maxDigitStartIndex = 0;
    int start = 0;
    int end = 0;
    
    Hashtable<Character,Integer> hash = new Hashtable<>();
    int i = 0;
    while (i < input.length()) {
      if (!hash.containsKey(input.charAt(i))) {
        hash.put(input.charAt(i),i);
        end = i+1;
        i++;
      }
      else {
        int lastCharOccurredIndex = hash.get(input.charAt(i));
        i = lastCharOccurredIndex + 1;
      
        if (end - start > maxDigit ) {
          maxDigit = end - start;
          maxDigitStartIndex = start;
        }
        
        start = i;
        end = i;
        hash.clear();
      }
    }
    
    if (end - start > maxDigit ) {
      maxDigit = end - start;
      maxDigitStartIndex = start;
    }
    
    return input.substring(maxDigitStartIndex, maxDigitStartIndex+maxDigit);
  }
}
