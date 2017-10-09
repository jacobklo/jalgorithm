package net.jacoblo.app.lib;

import java.util.ArrayList;

import net.jacoblo.algorithm.Backtracking.CombinationSum;
import net.jacoblo.algorithm.Backtracking.LargestNumberInKSwaps;
import net.jacoblo.algorithm.Backtracking.PermutationWithSpaces;
import net.jacoblo.algorithm.DynamicProgramming.LongestIncreasingSubsequence;
import net.jacoblo.algorithm.Graph.MColoringProblem;
import net.jacoblo.dataStructure.graph.UndirectedGraph;
import net.jacoblo.dataStructure.graph.Edge.BasicEdge;
import net.jacoblo.dataStructure.graph.Vertex.BasicVertex;
import net.jacoblo.lib.GeeksForGeeks;
import net.jacoblo.lib.GeeksForGeeks.Case;
import net.jacoblo.lib.GeeksForGeeks.Parameter;

public class GeeksForGeeksMain {
	public static void main(String[] args) {
//    System.out.println(testArray());
//    testMatrix();
//    System.out.println(test2Cases());
    System.out.println(testGraph());
  }
	
	private static String testGraph() {
	  Parameter[] para = { Parameter.GRAPH };
	  String[] types = { "Integer" };
	  String[] inputs = GeeksForGeeks.getInputs(para);
	  Case[] testCases = GeeksForGeeks.calc(inputs, para, types);
	  
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
		String[] inputs = GeeksForGeeks.getInputs(para);
		Case[] testCases = GeeksForGeeks.calc(inputs, para, types);
		
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
		String[] input = GeeksForGeeks.getInputs(paraString);
		Case[] testCasesString = GeeksForGeeks.calc(input, paraString, types);
		
		String output = "";
		for (Case c : testCasesString) {
			String inputForCase = (String) c.get(0);
			String[] result = PermutationWithSpaces.permutationWithSpaces(inputForCase);
			output += PermutationWithSpaces.printResult(result) + "\n";
		}
		return output;
	}

	private static String test2Cases() {
		// http://practice.geeksforgeeks.org/problems/combination-sum-part-2/0
    
		Parameter[] para3 =  { Parameter.ARRAY, Parameter.NUMBER };
    String[] input3 = GeeksForGeeks.getInputs(para3);/*= {2
    		,7
    		,10, 1, 2, 7, 6, 1, 5
    		,8
    		,5
    		,8, 1, 8, 6, 8
    		,12 };*/
    Case[] testCases3 = GeeksForGeeks.calc(input3, para3);
    
    String output3 = "";
    for (Case c : testCases3) {
    	int[] array = (int[])c.get(0);
    	int sum = (int)c.get(1);
    	ArrayList<ArrayList<Integer>> result = CombinationSum.combinationSum(array, sum);
    	output3 += CombinationSum.printResult(result) + "\n";
    }
		return output3;
	}

	private static void testMatrix() {
		String[] inputMatrix = { "1", 
    		"2", "3",
    		"1", "2", "3", "4", "5", "6" };
    
    Parameter[] para2 = { Parameter.MATRIXRECTANGLE };
    String[] types2 = { "Integer" };
    Case[] testCases2 = GeeksForGeeks.calc(inputMatrix, para2, types2);
	}

	private static String testArray() {
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
    
    Parameter[] para = { Parameter.ARRAY };
    String[] types = { "Integer" };
    Case[] testCases = GeeksForGeeks.calc(input2, para, types);
    
    
    String outputs = "";
    for ( Case c : testCases) {
      int[] inputArray1 = (int[])c.get(0);
      int result = LongestIncreasingSubsequence.LongestIncreasingSubsequenceDP(inputArray1, inputArray1.length);
      outputs += Integer.toString(result) + "\n";
    }
		return outputs;
	}
}
