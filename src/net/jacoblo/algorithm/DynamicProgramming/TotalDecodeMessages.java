package net.jacoblo.algorithm.DynamicProgramming;

/**
 * 
 * From : http://www.geeksforgeeks.org/count-possible-decodings-given-digit-sequence/
 * Count Possible Decodings of a given Digit Sequence
Let 1 represent �A�, 2 represents �B�, etc. Given a digit sequence, count the number of possible decodings of the given digit sequence.

Examples:

Input:  digits[] = "121"
Output: 3
// The possible decodings are "ABA", "AU", "LA"

Input: digits[] = "1234"
Output: 3
// The possible decodings are "ABCD", "LCD", "AWD"
An empty digit sequence is considered to have one decoding. It may be assumed that the input contains valid digits from 0 to 9 and there are no leading 0�s, no extra trailing 0�s and no two or more consecutive 0�s.
 *
 */
public class TotalDecodeMessages {
  public static void main(String[] args) {
    String test = "1212";
    int result = totalDecodeMessages(test);
    System.out.println(result);
  }
  
  public static int totalDecodeMessages(String input ) {
    if (input == null || input.equals("")) return -1;
    
    int[] totals = new int[input.length()+1];
    
    totals[0] = 1;
    totals[1] = 1;
    
    for (int i = 2; i <= input.length() ; i++) {
    	totals[i] = 0;
    	
    	// if the ten digit is not zero
    	if (input.charAt(i-1) > '0') {
    		totals[i] = totals[i-1];
    	}
    	
    	if ((input.charAt(i-2) == '1' || input.charAt(i-2) == '2') && input.charAt(i-1) < '7') {
    		totals[i] += totals[i-2];
    	}
    }
    
    
    return totals[input.length()];
  }
}
