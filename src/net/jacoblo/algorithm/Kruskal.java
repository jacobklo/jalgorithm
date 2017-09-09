package net.jacoblo.algorithm;

import java.util.PriorityQueue;

import net.jacoblo.data.UnionFindVertex;
import net.jacoblo.data.Edge.BasicEdge;
import net.jacoblo.data.Vertex.BasicVertex;
import net.jacoblo.dataStructure.UndirectedGraph;

public class Kruskal {
  public static <P extends Number, W extends Number> UndirectedGraph<P,W> kruskal(UndirectedGraph<P,W> graph) {
    if (graph == null || graph.size() <= 0 ) return new UndirectedGraph<>();
    graph.resetVisit();
    
    // sort the Edges
    PriorityQueue<BasicEdge<BasicVertex<P,W>,W>> edges = new PriorityQueue<>();
    
    for (BasicVertex<P,W> v : graph.getVertices()) {
      for (BasicEdge<BasicVertex<P,W>,W> e : v.getEdges()) {
        if (!e.visitedEdge) {
          edges.add(e);
          e.visitedEdge = true;
        }
      }
    }
    // for each edge, check if cyclic with current, if not add edge
    while (edges.size() > 0) {
      BasicEdge<P,W> currentEdge = edges.poll();
      
    }
  }
  
  public static <P extends Number, W extends Number> UnionFindVertex<P,W> generateUnionFindVertex(BasicVertex<P,W> v) {
  	if (v == null) return null;
  	UnionFindVertex<P,W> result = new UnionFindVertex<>(v.name, v.getX(), v.getY());
  	return result;
  }
  
  public static <P extends Number, W extends Number> BasicEdge<UnionFindVertex<P,W>,W> generateUnionFindEdge(BasicEdge<BasicVertex<P,W>,W> e)  {
  	if (e == null) return null;
  	UnionFindVertex<P,W> from = generateUnionFindVertex(e.getFromVertex());
  	
  	
  }
}
