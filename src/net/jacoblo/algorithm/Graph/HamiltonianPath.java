package net.jacoblo.algorithm.Graph;

public class HamiltonianPath {
	public static void main(String[] args) {
		int numOfVertices = 4;
		int numOfEdges = 4;
		int[][] graph = new int[numOfVertices][numOfVertices];
		int[] edgesArray = { 1, 2, 2, 3, 3, 4, 2, 4 };
		addEdges(edgesArray, numOfEdges, graph);
		boolean result = hasHamiltonianPath(graph);
		System.out.println(graph);
	}
	
	public static boolean hasHamiltonianPath(int[][] graph) {
		if (graph == null || graph.length <= 0 || graph[0].length <= 0 ) return false;
		
		
	}
	
	// In edgesArray, odd elements is from, even elements is to
	public static void addEdges(int[] edgesArray, int numOfEdges, int[][] graph ) {
		if (edgesArray == null || edgesArray.length <= 0 || graph == null || graph.length <= 0 || graph[0].length <= 0 || numOfEdges <= 0) return;
		
		for ( int i = 0 ; i < numOfEdges*2 && i < edgesArray.length ; i=i+2 ) {
			int from = edgesArray[i] - 1;
			int to = edgesArray[i+1] - 1;
			graph[from][to] = 1;
			graph[to][from] = 1;
		}
	}
}
