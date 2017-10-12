package net.jacoblo.app.lib;

import java.util.ArrayList;

import net.jacoblo.algorithm.Backtracking.CombinationSum;
import net.jacoblo.algorithm.Backtracking.CrazyEquations;
import net.jacoblo.algorithm.Backtracking.LargestNumberInKSwaps;
import net.jacoblo.algorithm.Backtracking.PermutationWithSpaces;
import static net.jacoblo.algorithm.DynamicProgramming.LongestIncreasingSubsequence.LongestIncreasingSubsequenceDP;
import static net.jacoblo.algorithm.DynamicProgramming.PathInMatrix.largestSumPathInMatrixDP;
import static net.jacoblo.algorithm.Backtracking.Sudoku.solveSudoku;
import static net.jacoblo.algorithm.Backtracking.Sudoku.printSudokuArray;
import net.jacoblo.algorithm.Graph.MColoringProblem;
import net.jacoblo.dataStructure.graph.UndirectedGraph;
import net.jacoblo.dataStructure.graph.Edge.BasicEdge;
import net.jacoblo.dataStructure.graph.Vertex.BasicVertex;
import net.jacoblo.lib.GeeksForGeeks.Case;
import net.jacoblo.lib.GeeksForGeeks.Parameter;
import static net.jacoblo.lib.GeeksForGeeks.getInputs;
import static net.jacoblo.lib.GeeksForGeeks.calc;

import net.jacoblo.lib.Util;

public class GeeksForGeeksMain {
	public static void main(String[] args) {
//    System.out.println(testArray());
//    testMatrix();
//    System.out.println(test2Cases());
    System.out.println(testSudoku());
  }
	
	private static String testSudoku() {
	  Parameter[] para = { Parameter.MATRIXSQUARE };
    String[] types = { "Integer" };
    String[] inputs = getInputs(para);
    Case[] testCases = calc(inputs, para, types);
    
    String outputs = "";
    for ( Case c : testCases) {
      int[][] currentMatrix = (int[][]) c.get(0);
      solveSudoku(currentMatrix);
      outputs += printSudokuArray(currentMatrix) + "\n";
    }
    return outputs;
	}
	
	private static String testPathInMatrix() {
		Parameter[] para = { Parameter.MATRIXSQUARE };
		String[] types = { "Integer" };
	  String[] inputs = getInputs(para);
	  Case[] testCases = calc(inputs, para, types);
	  
	   String output = "";
	    for (Case ca : testCases) {
	    	int[][] matrix = (int[][]) ca.get(0);
	      String result = Integer.toString(largestSumPathInMatrixDP(matrix));
	      output += result + "\n";
	    }
	    return output;
	}
	
	private static String testCrazyEquations() {
		Parameter[] para = { Parameter.NUMBER, Parameter.NUMBER,Parameter.NUMBER,Parameter.NUMBER,Parameter.NUMBER };
	  String[] types = { "Integer" ,"Integer","Integer","Integer","Integer"};
	  String[] inputs = getInputs(para);
	  Case[] testCases = calc(inputs, para, types);
	  
	   String output = "";
	    for (Case ca : testCases) {
	      int n = (int) ca.get(0);
	      int a = (int) ca.get(1);
	      int b = (int) ca.get(2);
	      int c = (int) ca.get(3);
	      int d = (int) ca.get(4);
	      String result = Integer.toString(CrazyEquations.crazyEquations(n, a, b, c, d));
	      output += result + "\n";
	    }
	    return output;
	}
	
	private static String testGraph() {
	  Parameter[] para = { Parameter.GRAPH };
	  String[] types = { "Integer" };
	  String[] inputs = getInputs(para);
	  Case[] testCases = calc(inputs, para, types);
	  
	   String output = "";
	    for (Case c : testCases) {
	      UndirectedGraph<BasicVertex<Integer>,BasicEdge<Integer>> graph = (UndirectedGraph<BasicVertex<Integer>,BasicEdge<Integer>>) c.get(0);
	      int numOfColor = (int) c.get(1);
	      String result = Integer.toString(MColoringProblem.mColoringProblem(graph, numOfColor));
	      output += result + "\n";
	    }
	    return output;
	}
	
	private static String testNumberAndString() {
		Parameter[] para = { Parameter.NUMBER, Parameter.STRING };
		String[] types = { "Integer", "String" };
		String[] inputs = getInputs(para);
		Case[] testCases = calc(inputs, para, types);
		
		String output = "";
		for (Case c : testCases) {
			int numOfSwaps = (int) c.get(0);
			String inputArray = (String) c.get(1);
			String result = LargestNumberInKSwaps.largestNumberInKSwaps(inputArray, numOfSwaps);
			output += result + "\n";
		}
		return output;
	}
	
	private static String testString() {
		Parameter[] paraString = { Parameter.STRING };
		String[] types = { "String" };
		String[] input = getInputs(paraString);
		Case[] testCasesString = calc(input, paraString, types);
		
		String output = "";
		for (Case c : testCasesString) {
			String inputForCase = (String) c.get(0);
			String[] result = PermutationWithSpaces.permutationWithSpaces(inputForCase);
			output += Util.printResult(result) + "\n";
		}
		return output;
	}

	private static String test2Cases() {
		// http://practice.geeksforgeeks.org/problems/combination-sum-part-2/0
    
		Parameter[] para3 =  { Parameter.ARRAY, Parameter.NUMBER };
    String[] input3 = getInputs(para3);/*= {2
    		,7
    		,10, 1, 2, 7, 6, 1, 5
    		,8
    		,5
    		,8, 1, 8, 6, 8
    		,12 };*/
    Case[] testCases3 = calc(input3, para3);
    
    String output3 = "";
    for (Case c : testCases3) {
    	int[] array = (int[])c.get(0);
    	int sum = (int)c.get(1);
    	ArrayList<ArrayList<Integer>> result = CombinationSum.combinationSum(array, sum);
    	output3 += Util.<Integer>printResult(result) + "\n";
    }
		return output3;
	}

	private static String testMatrix() {
		
    Parameter[] para = { Parameter.MATRIXRECTANGLE };
    String[] types = { "Integer" };
    String[] inputs = getInputs(para);
    Case[] testCases = calc(inputs, para, types);
    
    String outputs = "";
    for ( Case c : testCases) {
      int[][] currentMatrix = (int[][]) c.get(0);
      int result = largestSumPathInMatrixDP(currentMatrix);
      outputs += Integer.toString(result) + "\n";
    }
    return outputs;
	}

	private static String testArray() {
		
    Parameter[] para = { Parameter.ARRAY };
    String[] types = { "Integer" };
	  String[] inputs = getInputs(para);
	  Case[] testCases = calc(inputs, para, types);
    
    String outputs = "";
    for ( Case c : testCases) {
      int[] inputArray1 = (int[])c.get(0);
      int result = LongestIncreasingSubsequenceDP(inputArray1, inputArray1.length);
      outputs += Integer.toString(result) + "\n";
    }
		return outputs;
	}
}
