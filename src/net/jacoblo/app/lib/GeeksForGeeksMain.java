package net.jacoblo.app.lib;

import java.util.ArrayList;

import net.jacoblo.algorithm.TicTacToe;
import net.jacoblo.algorithm.Backtracking.CombinationSum;
import net.jacoblo.algorithm.Backtracking.CrazyEquations;
import net.jacoblo.algorithm.Backtracking.LargestNumberInKSwaps;
import net.jacoblo.algorithm.Backtracking.Permutation;
import static net.jacoblo.algorithm.DynamicProgramming.LongestIncreasingSubsequence.LongestIncreasingSubsequenceDP;
import static net.jacoblo.algorithm.DynamicProgramming.PathInMatrix.largestSumPathInMatrixDP;
import static net.jacoblo.algorithm.Backtracking.Sudoku.solveSudoku;
import static net.jacoblo.algorithm.Backtracking.Sudoku.printSudokuArray;

import net.jacoblo.algorithm.Graph.HamiltonianPath;
import net.jacoblo.algorithm.Graph.MColoringProblem;
import net.jacoblo.algorithm.array.LocksAndKeys;

import static net.jacoblo.algorithm.Graph.MinKnightStep.minKnightStep;
import net.jacoblo.dataStructure.graph.UndirectedGraph;
import net.jacoblo.dataStructure.graph.Edge.BasicEdge;
import net.jacoblo.dataStructure.graph.Vertex.BasicVertex;
import net.jacoblo.lib.GeeksForGeeks.Case;
import net.jacoblo.lib.GeeksForGeeks.Parameter;
import static net.jacoblo.lib.GeeksForGeeks.getInputs;
import static net.jacoblo.lib.GeeksForGeeks.calc;
import static net.jacoblo.algorithm.array.Rotate2DArray.rotate2DArray90DegreeInPlace;
import static net.jacoblo.algorithm.array.Rotate2DArray.printMatrix;
import static net.jacoblo.algorithm.DynamicProgramming.RegionsInMatrix.largestRegionInMatrix;
import net.jacoblo.lib.Util;

public class GeeksForGeeksMain {
	public static void main(String[] args) {
//    System.out.println(testArray());
//    testMatrix();
//    System.out.println(test2Cases());
    System.out.println(testGraphMatrix());
  }
	
	private static String testTicTacToe() {
		
    Parameter[] para = { Parameter.STRING , Parameter.STRING, Parameter.STRING, Parameter.STRING,Parameter.STRING ,Parameter.STRING , Parameter.STRING, Parameter.STRING, Parameter.STRING};
    String[] types = { "String" ,"String","String","String","String","String","String","String","String"};
	  String[] inputs = getInputs(para);
	  Case[] testCases = calc(inputs, para, types);
    
    String outputs = "";
    for ( Case c : testCases) {
      String inputArray1 = (String)c.get(0);
      for (int i = 1 ; i < 9 ; i++ ) {
      	inputArray1 += " " + (String)c.get(i);
      }
      char[][] board = TicTacToe.convertToBoard(inputArray1);
      boolean result = TicTacToe.isValid(board);
      outputs += result + "\n";
    }
		return outputs;
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
	
	private static String testMinKnightStep() {
		Parameter[] para = { Parameter.NUMBER, Parameter.NUMBER, Parameter.NUMBER, Parameter.NUMBER, Parameter.NUMBER, Parameter.NUMBER };
	  String[] types = { "Integer" ,"Integer", "Integer", "Integer" ,"Integer", "Integer"};
	  String[] inputs = getInputs(para);
	  Case[] testCases = calc(inputs, para, types);
	  
	   String output = "";
	    for (Case ca : testCases) {
	      int n = (int) ca.get(0);
	      int m = (int) ca.get(1);
	      int s1 = (int) ca.get(2);
	      int s2 = (int) ca.get(3);
	      int d1 = (int) ca.get(4);
	      int d2 = (int) ca.get(5);
	      int[] from = { s1, s2 };
	      int[] to = { d1, d2 };
	      int result = minKnightStep(m, n, from, to);
	      output += Integer.toString(result) + "\n";
	    }
	    return output;
	}
	
	private static String testGraphMatrix() {
	  Parameter[] para = { Parameter.GRAPH };
    String[] types = { "Integer" };
    String[] inputs = getInputs(para);
    Case[] testCases = calc(inputs, para, types);
    
    String output = "";
    for (Case c : testCases) {
      int[][] graph = (int[][]) c.get(0);
      boolean result = HamiltonianPath.hasHamiltonianPath(graph);
      output += (result ? 1 : 0 )+ "\n";
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
		Parameter[] para = { Parameter.NUMBER, Parameter.NUMBER,Parameter.STRING,Parameter.STRING };
		String[] types = { "Integer","Integer", "String" ,"String"};
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
			String[] result = Permutation.permutationWithSpaces(inputForCase);
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
      int result = largestRegionInMatrix(currentMatrix);
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
    for (Case c : testCases) {
      int[] array = (int[]) c.get(0);
      int result = kadane(array);
      outputs += Integer.toString(result) + "\n";
    }
    return outputs;
  }

}
