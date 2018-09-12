package jacoblo.algorithm.Graph;

import java.util.ArrayList;
import java.util.LinkedList;

import jacoblo.dataStructure.graph.Edge.Edgeable;
import jacoblo.dataStructure.graph.Graph;
import jacoblo.dataStructure.graph.Vertex.Vertexable;

public class BreadthFirstSearch {
//weight is not calculated!
	public static <V extends Vertexable, E extends Edgeable> ArrayList<V> BreadthFirstSearch(Graph<V,E> graph, V root) {
	  ArrayList<V> result = new ArrayList<V>();
	  if (graph == null || root == null) return result;
	  
	  boolean[] visited = new boolean[graph.getVertices().size()];
	  LinkedList<V> queue = new LinkedList<>();
	  queue.add(root);
	  
	  while(queue.size() > 0) {
	    V current = queue.poll();
	    int currentIndex = graph.getVertices().indexOf(current);
	    if (visited[currentIndex]) {
	      continue;
	    }
	    visited[currentIndex] = true;
	    
	    result.add(current);
	    
	    for(Edgeable e : current.getEdges()) {
	      V goingVertex = (V)e.getVertex(current);
	      int goingIndex = graph.getVertices().indexOf(goingVertex);
	      if (!visited[goingIndex]) {
	        queue.add(goingVertex);
	      }
	    }
	  }
	  
	  return result;
	}
}
