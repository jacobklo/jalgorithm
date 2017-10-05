package net.jacoblo.dataStructure.graph;

import net.jacoblo.dataStructure.graph.Edge.Edgeable;
import net.jacoblo.dataStructure.graph.Edge.VisitEdge;
import net.jacoblo.dataStructure.graph.Vertex.VisitVertex;

public class VisitGraph<V extends VisitVertex<?>, E extends VisitEdge<?>> extends Graph<V, E> {

	public static <V extends VisitVertex<?>, E extends VisitEdge<?>> void resetVisit(Object g) {
		if (g == null) return;
		Graph<V,E> graph = (Graph<V,E>) g;
		if (graph.getVertices() == null || graph.size() <= 0) return;
		for (V v : graph.getVertices()) {
			v.visited = false;
			for (Edgeable e : v.getEdges()) {
				((VisitEdge<?>)e).visitedEdge = false;
			}
		}
	}
}
