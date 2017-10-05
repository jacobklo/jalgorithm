package net.jacoblo.dataStructure.graph;

import net.jacoblo.dataStructure.graph.Edge.BasicEdge;
import net.jacoblo.dataStructure.graph.Edge.Edgeable;
import net.jacoblo.dataStructure.graph.Edge.VisitEdge;
import net.jacoblo.dataStructure.graph.Vertex.Vertexable;

//TODO : Try to simplify the double initization of edges in undirected graph
public class UndirectedGraph<V extends Vertexable, E extends Edgeable> extends Graph<V,E>{
  
	public static <V extends Vertexable, K extends Number> void addEdge(V from, V to, K edgeWeight){
		if (from == null || to == null || edgeWeight == null) return;
		if (!(from.getVertexType().equals(to.getVertexType()))) return;
		
		if (from.getVertexType().equals("BasicVertex")) {
			BasicEdge<K> edge = new BasicEdge<K>(from,to,edgeWeight);
			from.addEdge(edge);
			to.addEdge(edge);
		}
		else if (from.getVertexType().equals("VisitVertex") || from.getVertexType().equals("UnionFindVertex")) {
			VisitEdge<K> edge = new VisitEdge<K>(from,to,edgeWeight);
			from.addEdge(edge);
			to.addEdge(edge);
		}
	}
}