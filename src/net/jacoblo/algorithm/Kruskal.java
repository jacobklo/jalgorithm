package net.jacoblo.algorithm;

import java.util.PriorityQueue;

import net.jacoblo.data.UnionFindVertex;
import net.jacoblo.data.Edge.BasicEdge;
import net.jacoblo.data.Edge.Edgeable;
import net.jacoblo.data.Edge.VisitEdge;
import net.jacoblo.data.Vertex.BasicVertex;
import net.jacoblo.data.Vertex.Vertexable;
import net.jacoblo.data.Vertex.VisitVertex;
import net.jacoblo.dataStructure.Graph;
import net.jacoblo.dataStructure.UndirectedGraph;
import net.jacoblo.dataStructure.UnionFind;
import net.jacoblo.dataStructure.VisitGraph;

public class Kruskal {
  public static <P extends Number, W extends Number> UndirectedGraph<UnionFindVertex<P>,VisitEdge<W>> kruskal(UndirectedGraph<? extends UnionFindVertex<P>,? extends VisitEdge<W>> graph) {
    if (graph == null || graph.size() <= 0 ) return new UndirectedGraph<>();
    VisitGraph.<UnionFindVertex<P>,VisitEdge<W>>resetVisit(graph);
    
    // 1. add all edges and sort the Edges. Big O ( m log n)
    PriorityQueue<VisitEdge<W>> edges = new PriorityQueue<>();
    UndirectedGraph<UnionFindVertex<P>,VisitEdge<W>> result = new UndirectedGraph<>();
    
    for (UnionFindVertex<?> v : graph.getVertices()) {
      for (Edgeable edge : v.getEdges()) {
      	VisitEdge<W> e = (VisitEdge<W>)edge;
        if (!e.visitedEdge) {
          edges.add(e);
          e.visitedEdge = true;
        }
      }
    }
    
    // reset all visit edge
    VisitGraph.<UnionFindVertex<P>,VisitEdge<W>>resetVisit(graph);
    
    // for each edge, check if cyclic with current, if not add edge
    while (edges.size() > 0) {
    	VisitEdge<W> currentEdge = edges.poll();
      if (currentEdge.visitedEdge) { // should not happen
      	continue;
      }
      currentEdge.visitedEdge = true;
      UnionFindVertex<P> fromVertex = (UnionFindVertex<P>) currentEdge.getFromVertex();
      UnionFindVertex<P> toVertex = (UnionFindVertex<P>) currentEdge.getToVertex();
      
      UnionFindVertex<P> fromLeader = (UnionFindVertex<P>) fromVertex.getLeader();
      UnionFindVertex<P> toLeader = (UnionFindVertex<P>) toVertex.getLeader();
      
      // if it is cyclic
      if (fromLeader.equals(toLeader)) {
      	continue;
      }
      if (fromVertex.visited && toVertex.visited) {
      	continue;  // should not happen, check cyclic already
      }
      
      // Now just need to add Vertices to record
      UnionFind.union(fromVertex, toVertex);
      
      UnionFindVertex<P> cloneFromVertex = null;
      UnionFindVertex<P> cloneToVertex = null;
      if (!fromVertex.visited ) {
      	fromVertex.visited = true;
      	cloneFromVertex = new UnionFindVertex<>(fromVertex.name, fromVertex.getX(), fromVertex.getY());
      	result.addVertex(cloneFromVertex);
      }
      else if (fromVertex.visited ) {
      	// TODO find a better operation to find exsisting element
      	for (UnionFindVertex<P> v : result.getVertices()) {
      		if (v.getX().equals(fromVertex.getX()) && v.getY().equals(fromVertex.getY())) {
      			cloneFromVertex = v;
      		}
      	}
      }
      if (!toVertex.visited) {
      	toVertex.visited = true;
      	cloneToVertex = new UnionFindVertex<>(toVertex.name, toVertex.getX(), toVertex.getY());
      	result.addVertex(cloneToVertex);
      }
      else if (toVertex.visited) {
      	// TODO find a better operation to find exsisting element
      	for (UnionFindVertex<P> v : result.getVertices()) {
      		if (v.getX().equals(toVertex.getX()) && v.getY().equals(toVertex.getY())) {
      			cloneToVertex = v;
      		}
      	}
      }
      
      if ( cloneFromVertex == null || cloneToVertex == null) {
      	System.out.println("Should not happen cloneFromVertex == null");
      	continue;
      }
      UndirectedGraph.<UnionFindVertex<P>,W>addEdge(cloneFromVertex,cloneToVertex,currentEdge.getWeight());
			
    }
    return result;
  }
  
}
