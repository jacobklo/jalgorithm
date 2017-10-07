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
    
    String[] inputMatrix = { "1", 
    		"2", "3",
    		"1", "2", "3", "4", "5", "6" };
    
    Parameter[] para = { Parameter.ARRAY };
    String[] types = { "Integer" };
    Case[] testCases = GeeksForGeeks.calc(input2, para, types);
    
    Parameter[] para2 = { Parameter.MATRIXRECTANGLE };
    String[] types2 = { "Integer" };
    Case[] testCases2 = GeeksForGeeks.calc(inputMatrix, para2, types2);
    
    String outputs = "";
    for ( Case c : testCases) {
      int[] inputArray1 = (int[])c.get(0);
      int result = LongestIncreasingSubsequence.LongestIncreasingSubsequenceDP(inputArray1, inputArray1.length);
      outputs += Integer.toString(result) + "\n";
    }

    System.out.println(outputs);
  }
  
  public enum Parameter {
    NUMBER,
    ARRAY,
    MATRIXRECTANGLE,
    MATRIXSQUARE
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
  
  public static Case[] calc(String[] inputs, Parameter[] para, String[] types) {
    if (inputs == null || para == null || inputs.length == 0 || para.length == 0) return new Case[0];
    
    // First input, it is test cases number
    int numOfTestCase = Integer.parseInt(inputs[0]);
    
    // For each test case, calculate input. For each question we actually don't need the parameters, so we need input para
    ArrayList<Case> cases = new ArrayList<>();
    
    int i = 1;
    for (int c = 0 ; c < numOfTestCase ; c++ ) {
      Case newInputPara = new Case();
      for (int p = 0 ; p < para.length ; p++) {
      	Parameter currentPara = para[p];
      	String currentType = types[p];
        if (currentPara == Parameter.NUMBER) {
        	if (currentType.equals("Integer")) {
        		Integer currentInteger = Integer.parseInt(inputs[i]);
            newInputPara.InputPara.add(currentInteger);
        	}
        	else {
        		Double currentDouble = Double.parseDouble(inputs[i]);
            newInputPara.InputPara.add(currentDouble);
        	}
          i++;
        }
        else if (currentPara == Parameter.ARRAY) {
          int sizeOfCurrentArray = Integer.parseInt(inputs[i]);

          if (currentType.equals("Integer")) {
          	int[] currentArray = new int[sizeOfCurrentArray];
            for ( int j = 1 ; j <= sizeOfCurrentArray ; j++) {
              currentArray[j-1] = Integer.parseInt(inputs[i+j]);
            }
            newInputPara.InputPara.add(currentArray);
          }
          else {
          	double[] currentArray = new double[sizeOfCurrentArray];
            for ( int j = 1 ; j <= sizeOfCurrentArray ; j++) {
              currentArray[j-1] = Double.parseDouble(inputs[i+j]);
            }
            newInputPara.InputPara.add(currentArray);
          }
          
          i += sizeOfCurrentArray+1; // remember i++?
        }
        else if (currentPara == Parameter.MATRIXRECTANGLE) {
          int numOfRow = Integer.parseInt(inputs[i]);
          i++;
          int numOfColumn = Integer.parseInt(inputs[i]);
          i++;
          
          i = createMatrix(inputs, i, newInputPara, currentType, numOfRow, numOfColumn);
        }
        else if(currentPara == Parameter.MATRIXSQUARE) {
        	int numOfRowColumn = Integer.parseInt(inputs[i]);
          i++;
          
          i = createMatrix(inputs, i, newInputPara, currentType, numOfRowColumn, numOfRowColumn);
        }
      }
      cases.add(newInputPara);
    }
    
    
    Case[] result = new Case[cases.size()];
    result = cases.toArray(result);
    return result;
  }

	private static int createMatrix(String[] inputs, int i, Case newInputPara, String currentType, int numOfRow,
	    int numOfColumn) {
		if (currentType.equals("Integer")) {
			int[][] currentMatrix = new int[numOfRow][numOfColumn];
			for (int a = 0 ; a < currentMatrix.length ; a++) {
				currentMatrix[a] = new int[currentMatrix[a].length];
				for (int b = 0 ; b < currentMatrix[a].length ; b++) {
					currentMatrix[a][b] = Integer.parseInt(inputs[i]);
					i++;
		  	}
			}
			newInputPara.InputPara.add(currentMatrix);
		}
		else {
			double[][] currentMatrix = new double[numOfRow][numOfColumn];
			for (int a = 0 ; a < currentMatrix.length ; a++) {
				currentMatrix[a] = new double[currentMatrix[a].length];
				for (int b = 0 ; b < currentMatrix[a].length ; b++) {
					currentMatrix[a][b] = Double.parseDouble(inputs[i]);
					i++;
		  	}
			}
			newInputPara.InputPara.add(currentMatrix);
		}
		return i;
	}
  
}
