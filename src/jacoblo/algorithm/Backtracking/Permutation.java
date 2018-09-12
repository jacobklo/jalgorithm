
package jacoblo.algorithm.Backtracking;
import static jacoblo.lib.Util.printResult;

import java.util.ArrayList;

public class Permutation {
	public static void main(String[] args) {
	  testPremutation();
	}
	
	public static void testPremutation() {
	  char[] in = "1234".toCharArray();
	  ArrayList<ArrayList<Character>> result = premutation(in, in.length);
	  System.out.println(result);
	}

  private static void testPremutationWithSpaces() {
    String input = "ABCD";
		String[] result = permutationWithSpaces(input);
		System.out.println(printResult(result));
  }
	
	/**
	 * Permutation with Spaces
	 * EASY
	 * http://practice.geeksforgeeks.org/problems/permutation-with-spaces/0
	 * Given a string you need to print all possible strings that can be made by placing spaces (zero or one) in between them. Output should be printed in sorted increasing order of strings.

	Input:  str[] = "ABC"
	Output: (A B C)(A BC)(AB C)(ABC)
	Input:
	First line contains the test cases T.  1<=T<=10
	Each test case have one line string S of characters of length  N.  1<=N<=10

	Output:
	One line per test case, every string enclosed in ().(See example). Output should be printed in sorted order.

	Example:
	Input:
	2
	AB
	ABC

	Output:
	(A B)(AB)
	(A B C)(A BC)(AB C)(ABC)
	 */

	public static String[] permutationWithSpaces(String input) {
		if (input == null || input.length() == 0) return new String[0];
		
		if (input.length() == 1) {
			String[] result = new String[1];
			result[0] = input;
			return result;
		}
		
		String[] subRecursionResult = permutationWithSpaces(input.substring(0, input.length()-1));
		
		String[] result = new String[subRecursionResult.length * 2];
		
		for (int i = 0 ; i < subRecursionResult.length ; i++) {
			result[i*2] = subRecursionResult[i] + " " + input.charAt(input.length()-1);
			result[i*2+1] = subRecursionResult[i] + input.charAt(input.length()-1);
		}
		
		return result;
	}
	
	
	public static ArrayList<ArrayList<Character>> premutation(char[] in, int indexLeft) {
	  if (in == null || in.length <= 0 || indexLeft <= 0) return new ArrayList<>();
	  
	  if (indexLeft == 1) {
	    ArrayList<ArrayList<Character>> result = new ArrayList<>();
	    ArrayList<Character> newPremutationElement = new ArrayList<>();
	    newPremutationElement.add(in[0]);
	    result.add(newPremutationElement);
	    return result;
	  }
	  
	  ArrayList<ArrayList<Character>> subResult = premutation(in, indexLeft - 1 );
	  ArrayList<ArrayList<Character>> result = new ArrayList<>();
	  for (int i = 0 ; i < subResult.size(); i++)  {
	    for ( int j = subResult.get(i).size() ; j >= 1 ; j-- ) {
	      ArrayList<Character> currentPremutation = (ArrayList<Character>) subResult.get(i).clone();
	     
	      currentPremutation.add(j, in[indexLeft-1]);
	      result.add(currentPremutation);
	    }
	  }
	  
	  for (int i = 0 ; i < subResult.size() ; i++ ) {
	    ArrayList<Character> currentPremutation = (ArrayList<Character>) subResult.get(i).clone();
      
      currentPremutation.add(0, in[indexLeft-1]);
      result.add(currentPremutation);
	  }
	  
	  return result;
	}
}
