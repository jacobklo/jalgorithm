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
