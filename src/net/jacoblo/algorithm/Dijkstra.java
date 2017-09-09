package net.jacoblo.algorithm;

import java.util.ArrayList;
import java.util.LinkedList;

import net.jacoblo.data.Edge.BasicEdge;
import net.jacoblo.data.Edge.Edgeable;
import net.jacoblo.data.Edge.VisitEdge;
import net.jacoblo.data.Vertex.BasicVertex;
import net.jacoblo.data.Vertex.VisitVertex;
import net.jacoblo.dataStructure.Graph;
import net.jacoblo.dataStructure.VisitGraph;

public class Dijkstra {
	public static <V extends VisitVertex<?>, E extends VisitEdge<?>> ArrayList<V> dijkstra(Graph<? extends V,? extends E> graph, V root, V destination) {
		if (graph == null || root == null || destination == null)	return new ArrayList<V>();
		
		VisitGraph.resetVisit(graph);
		
		ArrayList<V> x = new ArrayList<>();
		x.add(root);
		
		while (x.size() < graph.getVertices().size() && x.size() > 0) {
			if (x.get(0).visited) {
				continue;
			}
			else if (x.get(x.size()-1).equals(destination)) {
				return x;
			}
			
			// need to re-scan all un-visited edges from visited area X to un-visit Vertices
			E smallestEdge = null;
			V smallestVertexrightNow = null;
			for (V currentX : x) {
				for (Edgeable ce : currentX.getEdges()) {
					E currentEdge = (E) ce;
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
			((V)smallestEdge.getVertex(smallestVertexrightNow)).visited = true;
			x.add(((V)smallestEdge.getVertex(smallestVertexrightNow)));

		}
		return x;
		
	}
	
	
	
	
}
