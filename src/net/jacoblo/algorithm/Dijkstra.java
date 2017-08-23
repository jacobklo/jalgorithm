package net.jacoblo.algorithm;

import java.util.ArrayList;
import java.util.LinkedList;

import net.jacoblo.data.Edge;
import net.jacoblo.data.Graph;
import net.jacoblo.data.Vertex;

public class Dijkstra {
	public static <T extends Number, K extends Number> ArrayList<Vertex<T,K>> dijkstra(Graph<T,K> graph, Vertex<T,K> root, Vertex<T,K> destination) {
		if (graph == null || root == null || destination == null)	return new ArrayList<Vertex<T,K>>();
		
		ArrayList<Vertex<T,K>> x = new ArrayList<Vertex<T,K>>();
		x.add(root);
		
		while (x.size() < graph.getVertices().size() && x.size() > 0) {
			if (x.get(0).visited) {
				continue;
			}
			else if (x.get(x.size()-1).equals(destination)) {
				return x;
			}
			
			// need to re-scan all un-visited edges from visited area X to un-visit Vertices
			Edge<T,K> smallestEdge = null;
			Vertex<T,K> smallestVertexrightNow = null;
			for (Vertex<T,K> currentX : x) {
				for (Edge<T,K> currentEdge : currentX.getEdges()) {
					if (!currentEdge.visitedEdge) {
						if (smallestEdge == null || smallestEdge.compareTo(currentEdge) > 0) {
							smallestVertexrightNow = currentX;
							smallestEdge = currentEdge;
						}
					}
				}
			}
			
			while(smallestVertexrightNow != null && x.size() > 0 && !(x.get(x.size()-1).equals(smallestVertexrightNow))) {
				x.remove(x.size()-1);
			}
			
			smallestEdge.visitedEdge = true;
			smallestEdge.getToVertex().visited = true;
			x.add(smallestEdge.getToVertex());

		}
		return x;
		
	}
	
	
	
	
}
