package net.jacoblo.data;

import java.util.ArrayList;
import java.util.LinkedList;

public class Graph<T extends Number, K extends Number> {
	private ArrayList<Vertex<T,K>> vertices;
	
	public Graph() {
	  vertices = new ArrayList<Vertex<T,K>>();
	}
	
	public ArrayList<Vertex<T,K>> getVertices() { return vertices; }
	
	public void addVertex(Vertex<T,K> v) {
	  vertices.add(v);
	}
	
	public void addEdge(Vertex<T,K> from, Vertex<T,K> to, K edgeWeight){
	  Edge<T,K> edge = new Edge<T,K>(from,to,edgeWeight);
	  from.addEdge(edge);
	}
	
	@Override
	public String toString() {
	  String result = "Graph : ";
	  for (Vertex<T,K> v : vertices) {
	    result += "V : " + v.toString() + "\n";
	  }
	  return result;
	}
	
	//weight is not calculated!
	public static <T extends Number, K extends Number> ArrayList<Vertex<T,K>> BreadthFirstSearch(Graph<T,K> graph, Vertex<T,K> root) {
	  ArrayList<Vertex<T,K>> result = new ArrayList<Vertex<T,K>>();
	  if (graph == null || root == null) return result;
	  
	  boolean[] visited = new boolean[graph.getVertices().size()];
	  LinkedList<Vertex<T,K>> queue = new LinkedList<>();
	  queue.add(root);
	  
	  while(queue.size() > 0) {
	    Vertex<T,K> current = queue.poll();
	    int currentIndex = graph.getVertices().indexOf(current);
	    if (visited[currentIndex]) {
	      continue;
	    }
	    visited[currentIndex] = true;
	    
	    result.add(current);
	    
	    for(Edge<T,K> e : current.getEdges()) {
	      Vertex<T,K> goingVertex = e.getVertex(current);
	      int goingIndex = graph.getVertices().indexOf(goingVertex);
	      if (!visited[goingIndex]) {
	        queue.add(goingVertex);
	      }
	    }
	  }
	  
	  return result;
	}
}
