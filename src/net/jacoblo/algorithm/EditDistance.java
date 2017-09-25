package net.jacoblo.algorithm;

import net.jacoblo.lib.Util;

/**
 * Dynamic Programming | Set 5 (Edit Distance)
 * From: http://www.geeksforgeeks.org/dynamic-programming-set-5-edit-distance/
 * 
Given two strings str1 and str2 and below operations that can performed on str1. Find minimum number of edits (operations) required to convert ‘str1’ into ‘str2’.

Insert
Remove
Replace
All of the above operations are of equal cost.

Examples:

Input:   str1 = "geek", str2 = "gesek"
Output:  1
We can convert str1 into str2 by inserting a 's'.

Input:   str1 = "cat", str2 = "cut"
Output:  1
We can convert str1 into str2 by replacing 'a' with 'u'.

Input:   str1 = "sunday", str2 = "saturday"
Output:  3
Last three and first characters are same.  We basically
need to convert "un" to "atur".  This can be done using
below three operations. 
Replace 'n' with 'r', insert t, insert a

 *
 */
public class EditDistance {
  public static void main(String[] args) {
    
//    int result = MinEdit("geek", "gessek");
//    int result = MinEdit("cat", "cta");
    int result = MinEdit("un", "atur");
    
    System.out.println(result);
  }
  
  public static int MinEdit(String s1, String s2) {
    if (s1 == null || s2 == null || s1.equals("") || s2.equals("")) return -1;
    
    int[][] edits = new int[s1.length()+1][s2.length()+1];
    // Init to zero, for zero edit
    for (int i = 0 ; i < edits.length ; i++) {
      for ( int j = 0 ; j < edits[i].length ; j++) {
        edits[i][j] = 0;
      }
    }

    for (int i = 0 ; i < edits.length ; i++) {
      for ( int j = 0 ; j < edits[i].length ; j++) {
        // need to consider empty string cases:
        if ( i == 0 ) {
          edits[i][j] = j;
          continue;
        }
        else if ( j == 0) {
          edits[i][j] = i;
          continue;
        }
        
        
        int lastOptimal = edits[i-1][j-1];
        // Case 1: check if cuurent char is equal, if not add 1 for replace operation
        if (s1.charAt(i-1) != s2.charAt(j-1)) {
          lastOptimal += 1;
        }
        // Case 2 : s1 is missing 1 char, add 1 for Insert Operation
        int s1AddOne = edits[i-1][j] + 1;
        
        // Case 3 : s1 has 1 extra char, add 1 for remove operation
        int s1RemoveOne = edits[i][j-1] + 1;
        
        edits[i][j] = Util.<Integer>min(lastOptimal, s1AddOne, s1RemoveOne);
      }
    }
    
    return edits[s1.length()][s2.length()];
  }
}
