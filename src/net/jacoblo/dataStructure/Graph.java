package net.jacoblo.dataStructure;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedList;

import net.jacoblo.data.Edge;
import net.jacoblo.data.Vertex;

public class Graph<T extends Number, K extends Number> implements Iterable<Vertex<T,K>>{
	private ArrayList<Vertex<T,K>> vertices;
	
	public Graph() {
	  vertices = new ArrayList<Vertex<T,K>>();
	}
	
	public ArrayList<Vertex<T,K>> getVertices() { return vertices; }
	
	public void addVertex(Vertex<T,K> v) {
	  vertices.add(v);
	}
	
	public void addEdge(Vertex<T,K> from, Vertex<T,K> to, K edgeWeight){
	  Edge<Vertex<T,K>,K> edge = new Edge<Vertex<T,K>,K>(from,to,edgeWeight);
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
	
	public void resetVisit() {
		if (vertices == null || vertices.size() <= 0) 	return;
		for (Vertex<T,K> v : vertices) {
			v.visited = false;
			for (Edge<Vertex<T,K>,K> e : v.getEdges()) {
				e.visitedEdge = false;
			}
		}
	}
	
	public Vertex<T,K> getRandomVertex() {
		if (vertices == null || vertices.size() <= 0) return null;
		return vertices.get((int)(Math.random() * vertices.size()));
	}
	
	public int size() {
		return ( vertices == null ? 0 : vertices.size());
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
	    
	    for(Edge<Vertex<T,K>,K> e : current.getEdges()) {
	      Vertex<T,K> goingVertex = e.getVertex(current);
	      int goingIndex = graph.getVertices().indexOf(goingVertex);
	      if (!visited[goingIndex]) {
	        queue.add(goingVertex);
	      }
	    }
	  }
	  
	  return result;
	}

	@Override
	public Iterator<Vertex<T, K>> iterator() {
		return vertices.iterator();
	}
}
