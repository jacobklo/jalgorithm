
/**
 * Hamiltonian Path
 * http://practice.geeksforgeeks.org/problems/hamiltonian-path/0
MEDIUM
NOT PASS
A Hamiltonian path, is a path in an undirected or directed graph that visits each vertex exactly once. Given an undirected graph  the task is to check if a Hamiltonian path is present in it or not.

Input:
The first line of input contains an integer T denoting the no of test cases. Then T test cases follow. Each test case contains two lines. The first line consists of two space separated integers N and M denoting the number of vertices and number of edges.Then in the next line are M space separated pairs u,v denoting an edge from u to v.

Output:
For each test case in a new line print 1 if a Hamiltonean path exists else print 0.

Constraints:
1<=T<=100
1<=N<=10
1<=M<=15

Example:
Input:
2
4 4
1 2 2 3 3 4 2 4
4 3
1 2 2 3 2 4
Output:
1
0
 */
package net.jacoblo.algorithm.Graph;

import net.jacoblo.lib.GeeksForGeeks;

public class HamiltonianPath {
	public static void main(String[] args) {
		System.out.println(test3());
	}
	
	private static String test1() {
	  int numOfVertices = 4;
    int numOfEdges = 4;
    int[][] graph = new int[numOfVertices][numOfVertices];
    int[] edgesArray = { 1, 2, 2, 3, 3, 4, 2, 4 };
    GeeksForGeeks.addEdges(edgesArray, numOfEdges, graph);
    boolean result = hasHamiltonianPath(graph);
    return ""+result;
	}
	
	private static String test2() {
    int numOfVertices = 4;
    int numOfEdges = 3;
    int[][] graph = new int[numOfVertices][numOfVertices];
    int[] edgesArray = { 1, 2, 2, 3, 2, 4 };
    GeeksForGeeks.addEdges(edgesArray, numOfEdges, graph);
    boolean result = hasHamiltonianPath(graph);
    return ""+result;
  }
	
	 private static String test3() {
	    int numOfVertices = 10;
	    int numOfEdges = 14;
	    int[][] graph = new int[numOfVertices][numOfVertices];
	    int[] edgesArray = { 2, 1, 10, 2, 6, 3, 5, 4, 10, 5, 10, 6, 6, 7, 6, 8, 10, 9, 4, 9, 3, 8, 3, 7, 5, 9, 6, 5  };
	    GeeksForGeeks.addEdges(edgesArray, numOfEdges, graph);
	    boolean result = hasHamiltonianPath(graph);
	    return ""+result;
	  }
	
	public static boolean hasHamiltonianPath(int[][] graph) {
	  return hasHamiltonianPath(graph, new boolean[graph.length], 0);
	}
	
	private static boolean hasHamiltonianPath(int[][] graph, boolean[] visited, int currentVertex) {
		if (graph == null || graph.length <= 0 || graph[0].length <= 0 ) return false;
		visited[currentVertex] = true;
		for ( int i = currentVertex ; i < graph.length ; i++ ) {
		  for ( int j = i ; j < graph.length ; j++ ) {
		    if (graph[i][j] == 1 && !visited[j]) {
		      hasHamiltonianPath(graph, visited, j);
		    }
		    if (allVisited(visited)) {
		      return true;
		    }
		  }
		}
		visited[currentVertex] = false;
		return false;
	}
	
	public static boolean allVisited(boolean[] visited) {
	  for ( int i = 0 ; i < visited.length ; i++ ) {
	    if (!visited[i]) {
	      return false;
	    }
	  }
	  return true;
	}
}
