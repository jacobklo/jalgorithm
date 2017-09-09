package net.jacoblo.algorithm;

import java.util.ArrayList;
import java.util.LinkedList;

import net.jacoblo.data.Edge.BasicEdge;
import net.jacoblo.data.Vertex.BasicVertex;
import net.jacoblo.dataStructure.Graph;

public class Dijkstra {
	public static <T extends Number, K extends Number> ArrayList<BasicVertex<T,K>> dijkstra(Graph<T,K> graph, BasicVertex<T,K> root, BasicVertex<T,K> destination) {
		if (graph == null || root == null || destination == null)	return new ArrayList<BasicVertex<T,K>>();
		
		graph.resetVisit();
		
		ArrayList<BasicVertex<T,K>> x = new ArrayList<BasicVertex<T,K>>();
		x.add(root);
		
		while (x.size() < graph.getVertices().size() && x.size() > 0) {
			if (x.get(0).visited) {
				continue;
			}
			else if (x.get(x.size()-1).equals(destination)) {
				return x;
			}
			
			// need to re-scan all un-visited edges from visited area X to un-visit Vertices
			BasicEdge<BasicVertex<T,K>,K> smallestEdge = null;
			BasicVertex<T,K> smallestVertexrightNow = null;
			for (BasicVertex<T,K> currentX : x) {
				for (BasicEdge<BasicVertex<T,K>,K> currentEdge : currentX.getEdges()) {
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
			smallestEdge.getVertex(smallestVertexrightNow).visited = true;
			x.add(smallestEdge.getVertex(smallestVertexrightNow));

		}
		return x;
		
	}
	
	
	
	
}
