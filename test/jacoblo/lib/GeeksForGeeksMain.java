package jacoblo.lib;

import java.util.ArrayList;

import jacoblo.algorithm.Backtracking.CombinationSum;
import jacoblo.algorithm.Backtracking.LargestNumberInKSwaps;
import jacoblo.algorithm.Backtracking.Permutation;
import jacoblo.algorithm.Backtracking.Sudoku;
import jacoblo.algorithm.DynamicProgramming.MaxSubarrayProblem;
import jacoblo.algorithm.DynamicProgramming.PathInMatrix;
import jacoblo.algorithm.DynamicProgramming.RegionsInMatrix;
import jacoblo.algorithm.Graph.HamiltonianPath;
import jacoblo.algorithm.Graph.MColoringProblem;
import jacoblo.algorithm.Graph.MinKnightStep;
import jacoblo.algorithm.TicTacToe;
import jacoblo.dataStructure.graph.Edge.BasicEdge;
import jacoblo.dataStructure.graph.UndirectedGraph;
import jacoblo.dataStructure.graph.Vertex.BasicVertex;
import jacoblo.lib.GeeksForGeeks;
import jacoblo.lib.Util;

import static jacoblo.algorithm.Backtracking.Sudoku.solveSudoku;

import static jacoblo.lib.GeeksForGeeks.calc;
import static jacoblo.algorithm.DynamicProgramming.RegionsInMatrix.largestRegionInMatrix;

public class GeeksForGeeksMain {
	public static void main(String[] args) {
//    System.out.println(testArray());
//    testMatrix();
//    System.out.println(test2Cases());
    System.out.println(testGraphMatrix());
  }
	
	private static String testTicTacToe() {
		
    GeeksForGeeks.Parameter[] para = { GeeksForGeeks.Parameter.STRING , GeeksForGeeks.Parameter.STRING, GeeksForGeeks.Parameter.STRING, GeeksForGeeks.Parameter.STRING, GeeksForGeeks.Parameter.STRING , GeeksForGeeks.Parameter.STRING , GeeksForGeeks.Parameter.STRING, GeeksForGeeks.Parameter.STRING, GeeksForGeeks.Parameter.STRING};
    String[] types = { "String" ,"String","String","String","String","String","String","String","String"};
	  String[] inputs = GeeksForGeeks.getInputs(para);
	  GeeksForGeeks.Case[] testCases = GeeksForGeeks.calc(inputs, para, types);
    
    String outputs = "";
    for ( GeeksForGeeks.Case c : testCases) {
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
	  GeeksForGeeks.Parameter[] para = { GeeksForGeeks.Parameter.MATRIXSQUARE };
    String[] types = { "Integer" };
    String[] inputs = GeeksForGeeks.getInputs(para);
    GeeksForGeeks.Case[] testCases = GeeksForGeeks.calc(inputs, para, types);
    
    String outputs = "";
    for ( GeeksForGeeks.Case c : testCases) {
      int[][] currentMatrix = (int[][]) c.get(0);
      Sudoku.solveSudoku(currentMatrix);
      outputs += Sudoku.printSudokuArray(currentMatrix) + "\n";
    }
    return outputs;
	}
	
	private static String testPathInMatrix() {
		GeeksForGeeks.Parameter[] para = { GeeksForGeeks.Parameter.MATRIXSQUARE };
		String[] types = { "Integer" };
	  String[] inputs = GeeksForGeeks.getInputs(para);
	  GeeksForGeeks.Case[] testCases = GeeksForGeeks.calc(inputs, para, types);
	  
	   String output = "";
	    for (GeeksForGeeks.Case ca : testCases) {
	    	int[][] matrix = (int[][]) ca.get(0);
	      String result = Integer.toString(PathInMatrix.largestSumPathInMatrixDP(matrix));
	      output += result + "\n";
	    }
	    return output;
	}
	
	private static String testMinKnightStep() {
		GeeksForGeeks.Parameter[] para = { GeeksForGeeks.Parameter.NUMBER, GeeksForGeeks.Parameter.NUMBER, GeeksForGeeks.Parameter.NUMBER, GeeksForGeeks.Parameter.NUMBER, GeeksForGeeks.Parameter.NUMBER, GeeksForGeeks.Parameter.NUMBER };
	  String[] types = { "Integer" ,"Integer", "Integer", "Integer" ,"Integer", "Integer"};
	  String[] inputs = GeeksForGeeks.getInputs(para);
	  GeeksForGeeks.Case[] testCases = GeeksForGeeks.calc(inputs, para, types);
	  
	   String output = "";
	    for (GeeksForGeeks.Case ca : testCases) {
	      int n = (int) ca.get(0);
	      int m = (int) ca.get(1);
	      int s1 = (int) ca.get(2);
	      int s2 = (int) ca.get(3);
	      int d1 = (int) ca.get(4);
	      int d2 = (int) ca.get(5);
	      int[] from = { s1, s2 };
	      int[] to = { d1, d2 };
	      int result = MinKnightStep.minKnightStep(m, n, from, to);
	      output += Integer.toString(result) + "\n";
	    }
	    return output;
	}
	
	private static String testGraphMatrix() {
	  GeeksForGeeks.Parameter[] para = { GeeksForGeeks.Parameter.GRAPH };
    String[] types = { "Integer" };
    String[] inputs = GeeksForGeeks.getInputs(para);
    GeeksForGeeks.Case[] testCases = GeeksForGeeks.calc(inputs, para, types);
    
    String output = "";
    for (GeeksForGeeks.Case c : testCases) {
      int[][] graph = (int[][]) c.get(0);
      boolean result = HamiltonianPath.hasHamiltonianPath(graph);
      output += (result ? 1 : 0 )+ "\n";
    }
    return output;
	}
	
	private static String testGraph() {
	  GeeksForGeeks.Parameter[] para = { GeeksForGeeks.Parameter.GRAPH };
	  String[] types = { "Integer" };
	  String[] inputs = GeeksForGeeks.getInputs(para);
	  GeeksForGeeks.Case[] testCases = GeeksForGeeks.calc(inputs, para, types);
	  
	   String output = "";
	    for (GeeksForGeeks.Case c : testCases) {
	      UndirectedGraph<BasicVertex<Integer>,BasicEdge<Integer>> graph = (UndirectedGraph<BasicVertex<Integer>, BasicEdge<Integer>>) c.get(0);
	      int numOfColor = (int) c.get(1);
	      String result = Integer.toString(MColoringProblem.mColoringProblem(graph, numOfColor));
	      output += result + "\n";
	    }
	    return output;
	}
	
	private static String testNumberAndString() {
		GeeksForGeeks.Parameter[] para = { GeeksForGeeks.Parameter.NUMBER, GeeksForGeeks.Parameter.NUMBER, GeeksForGeeks.Parameter.STRING, GeeksForGeeks.Parameter.STRING };
		String[] types = { "Integer","Integer", "String" ,"String"};
		String[] inputs = GeeksForGeeks.getInputs(para);
		GeeksForGeeks.Case[] testCases = GeeksForGeeks.calc(inputs, para, types);
		
		String output = "";
		for (GeeksForGeeks.Case c : testCases) {
			int numOfSwaps = (int) c.get(0);
			String inputArray = (String) c.get(1);
			String result = LargestNumberInKSwaps.largestNumberInKSwaps(inputArray, numOfSwaps);
			output += result + "\n";
		}
		return output;
	}
	
	private static String testString() {
		GeeksForGeeks.Parameter[] paraString = { GeeksForGeeks.Parameter.STRING };
		String[] types = { "String" };
		String[] input = GeeksForGeeks.getInputs(paraString);
		GeeksForGeeks.Case[] testCasesString = GeeksForGeeks.calc(input, paraString, types);
		
		String output = "";
		for (GeeksForGeeks.Case c : testCasesString) {
			String inputForCase = (String) c.get(0);
			String[] result = Permutation.permutationWithSpaces(inputForCase);
			output += Util.printResult(result) + "\n";
		}
		return output;
	}

	private static String test2Cases() {
		// http://practice.geeksforgeeks.org/problems/combination-sum-part-2/0
    
		GeeksForGeeks.Parameter[] para3 =  { GeeksForGeeks.Parameter.ARRAY, GeeksForGeeks.Parameter.NUMBER };
    String[] input3 = GeeksForGeeks.getInputs(para3);/*= {2
    		,7
    		,10, 1, 2, 7, 6, 1, 5
    		,8
    		,5
    		,8, 1, 8, 6, 8
    		,12 };*/
    GeeksForGeeks.Case[] testCases3 = GeeksForGeeks.calc(input3, para3);
    
    String output3 = "";
    for (GeeksForGeeks.Case c : testCases3) {
    	int[] array = (int[])c.get(0);
    	int sum = (int)c.get(1);
    	ArrayList<ArrayList<Integer>> result = CombinationSum.combinationSum(array, sum);
    	output3 += Util.<Integer>printResult(result) + "\n";
    }
		return output3;
	}

	private static String testMatrix() {
		
    GeeksForGeeks.Parameter[] para = { GeeksForGeeks.Parameter.MATRIXRECTANGLE };
    String[] types = { "Integer" };
    String[] inputs = GeeksForGeeks.getInputs(para);
    GeeksForGeeks.Case[] testCases = GeeksForGeeks.calc(inputs, para, types);
    
    String outputs = "";
    for ( GeeksForGeeks.Case c : testCases) {
      int[][] currentMatrix = (int[][]) c.get(0);
      int result = RegionsInMatrix.largestRegionInMatrix(currentMatrix);
      outputs += Integer.toString(result) + "\n";
    }
    return outputs;
	}

  private static String testArray() {

    GeeksForGeeks.Parameter[] para = { GeeksForGeeks.Parameter.ARRAY };
    String[] types = { "Integer" };
    String[] inputs = GeeksForGeeks.getInputs(para);
    GeeksForGeeks.Case[] testCases = GeeksForGeeks.calc(inputs, para, types);

    String outputs = "";
    for (GeeksForGeeks.Case c : testCases) {
      int[] array = (int[]) c.get(0);
      int result = MaxSubarrayProblem.kadane(array);
      outputs += Integer.toString(result) + "\n";
    }
    return outputs;
  }

}
