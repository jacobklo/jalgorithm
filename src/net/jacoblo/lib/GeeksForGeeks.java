package net.jacoblo.lib;

import java.util.ArrayList;
import net.jacoblo.algorithm.DynamicProgramming.LongestIncreasingSubsequence;

public class GeeksForGeeks {
  public static void main(String[] args) {
    // Example from Longest Increasing Subsequence
    //http://practice.geeksforgeeks.org/problems/longest-increasing-subsequence/0
    
    String[] input1 = { "1",
        "16",
        "0", "8", "4", "12", "2", "10", "6", "14", "1", "9", "5", "13", "3", "11", "7", "15" };
    
    // Double testcase, actually the same
    String[] input2 = { "2",
        "16",
        "0", "8", "4", "12", "2", "10", "6", "14", "1", "9", "5", "13", "3", "11", "7", "15",
        "16",
        "0", "8", "4", "12", "2", "10", "6", "14", "1", "9", "5", "13", "3", "11", "7", "15"};
    
    Parameter[] para = { Parameter.ARRAYINTEGER };
    Case[] testCases = GeeksForGeeks.calc(input2, para);
    
    String outputs = "";
    for ( Case c : testCases) {
      int[] inputArray1 = (int[])c.get(0);
      int result = LongestIncreasingSubsequence.LongestIncreasingSubsequenceDP(inputArray1, inputArray1.length);
      outputs += Integer.toString(result) + "\n";
    }

    System.out.println(outputs);
  }
  
  public enum Parameter {
    INTEGER,
    ARRAYINTEGER,
    MATRIXINTEGER
  }
  
  public static class Case {
    ArrayList<Object> InputPara;
    
    public Case() {
      InputPara = new ArrayList<>();
    }
    
    public Object get(int index) {
      return InputPara.get(index);
    }
  }
  
  public static Case[] calc(String[] inputs, Parameter[] para) {
    if (inputs == null || para == null || inputs.length == 0 || para.length == 0) return new Case[0];
    
    // FIrst input, it is test cases number
    int numOfTestCase = Integer.parseInt(inputs[0]);
    
    // For each test case, calculate input. For each question we actually don't need the parameters, so we need input para
    ArrayList<Case> cases = new ArrayList<>();
    
    int i = 1;
    for (int c = 0 ; c < numOfTestCase ; c++ ) {
      Case newInputPara = new Case();
      for (Parameter currentPara : para) {
        if (currentPara == Parameter.INTEGER) {
          Integer currentInteger = Integer.parseInt(inputs[i]);
          newInputPara.InputPara.add(currentInteger);
          i++;
        }
        else if (currentPara == Parameter.ARRAYINTEGER) {
          int sizeOfCurrentArray = Integer.parseInt(inputs[i]);

          int[] currentArray = new int[sizeOfCurrentArray];
          for ( int j = 1 ; j <= sizeOfCurrentArray ; j++) {
            currentArray[j-1] = Integer.parseInt(inputs[i+j]);
          }
          i += sizeOfCurrentArray+1; // remember i++?
          newInputPara.InputPara.add(currentArray);
        }
      }
      cases.add(newInputPara);
    }
    
    
    Case[] result = new Case[cases.size()];
    result = cases.toArray(result);
    return result;
  }
  
}
