
/*
 * EASY
 * https://www.hackerrank.com/challenges/two-characters/problem
 * 
 * In this challenge, you will be given a string. You must remove characters until the string is made up of any two alternating characters. When you choose a character to remove, all instances of that character must be removed. Your goal is to create the longest string possible that contains just two alternating letters.
As an example, consider the string abaacdabd. If you delete the character a, you will be left with the string bcdbd. Now, removing the character c leaves you with a valid string bdbd having a length of 4. Removing either b or d at any point would not result in a valid string.
Given a string , convert it to the longest possible string  made up only of alternating characters. Print the length of string  on a new line. If no string  can be formed, print  instead.
Input Format
The first line contains a single integer denoting the length of . 
The second line contains string .
Constraints


Output Format
Print a single integer denoting the maximum length of  for the given ; if it is not possible to form string , print  instead.
Sample Input
10
beabeefeab
Sample Output
5
Explanation
The characters present in  are a, b, e, and f. This means that  must consist of two of those characters and we must delete two others. Our choices for characters to leave are [a,b], [a,e], [a, f], [b, e], [b, f] and [e, f].
If we delete e and f, the resulting string is babab. This is a valid  as there are only two distinct characters (a and b), and they are alternating within the string.
If we delete a and f, the resulting string is bebeeeb. This is not a valid string  because there are consecutive e's present. Removing them would leave consecutive b's, so this fails to produce a valid string .
Other cases are solved similarly.
babab is the longest string we can create.

 */
package jacoblo.algorithm.String;

import java.io.IOException;
import java.util.ArrayList;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class TwoCharacters {
  //Complete the solve function below.
  static int solve(String s) {
    char[] dc = distinctChar(s);
    int result = 0;
    
    for ( int i = 0 ; i < dc.length - 1; i++ ) {
      for ( int j = i+1 ; j < dc.length ; j++ ) {
        char[] curChars = { dc[i], dc[j] };
        String subString = getSubString(s, curChars );
        System.out.println(subString);
        
        String strPat = "^([" + dc[i] + dc[j] + "])(?!\\1)([" + dc[i] + dc[j] + "])(?:\\1\\2)*\\1?$";
        System.out.println(strPat);
        Pattern pat = Pattern.compile(strPat);
        Matcher match = pat.matcher(subString);
        
        if (match.find() && match.group().length() > result) {
          result = match.group().length();
        }
      }
    }
    
    return result;
  }
  
  static String getSubString(String s, char[] cs) {
    String result = "";
    for ( char c : s.toCharArray() ) {
      for ( char cur : cs ) {
        if ( c == cur) {
          result += cur;
        }
      }
    }
    return result;
  }
  static char[] distinctChar(String s) {
    int[] bucket = new int[26];
    for (char c : s.toCharArray()) {
      if ( c >= 'a' && c <= 'z') 
        bucket[c-'a']++;
    }
    
    ArrayList<Character> resultList = new ArrayList<>();
    for (int i = 0 ; i < bucket.length ; i++ ) {
      if (bucket[i] > 0) {
        resultList.add((char) ('a'+i));
      }
    }
    
    char[] result = new char[resultList.size()];
    for ( int i = 0 ; i < resultList.size(); i++ ) {
      result[i] = resultList.get(i);
    }
    return result;
  }

  public static void main(String[] args) throws IOException {
      /*
      BufferedReader bufferedReader = new BufferedReader(new InputStreamReader(System.in));
      BufferedWriter bufferedWriter = new BufferedWriter(new FileWriter(System.getenv("OUTPUT_PATH")));

      int l = Integer.parseInt(bufferedReader.readLine().trim());

      String s = bufferedReader.readLine();

      int result = solve(s);

      bufferedWriter.write(String.valueOf(result));
      bufferedWriter.newLine();

      bufferedReader.close();
      bufferedWriter.close();
      */
    int result = solve("beabeefeab");
    System.out.println(result);
  }
}
