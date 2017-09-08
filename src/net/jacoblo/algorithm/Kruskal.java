package net.jacoblo.algorithm;

import java.util.PriorityQueue;

import net.jacoblo.data.Edge;
import net.jacoblo.data.Vertex;
import net.jacoblo.dataStructure.UndirectedGraph;

public class Kruskal {
  public static <P extends Number, W extends Number> UndirectedGraph<P,W> kruskal(UndirectedGraph<P,W> graph) {
    if (graph == null || graph.size() <= 0 ) return new UndirectedGraph<>();
    graph.resetVisit();
    
    // sort the Edges
    PriorityQueue<Edge<P,W>> edges = new PriorityQueue<>();
    
    for (Vertex<P,W> v : graph.getVertices()) {
      for (Edge<P,W> e : v.getEdges()) {
        if (!e.visitedEdge) {
          edges.add(e);
          e.visitedEdge = true;
        }
      }
    }
    // for each edge, check if cyclic with current, if not add edge
    while (edges.size() > 0) {
      Edge<P,W> currentEdge = edges.poll();
      
    }
  }
}
