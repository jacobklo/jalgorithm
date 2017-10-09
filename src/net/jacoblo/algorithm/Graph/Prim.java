package net.jacoblo.algorithm.Graph;

import java.util.ArrayList;

import net.jacoblo.dataStructure.graph.UndirectedGraph;
import net.jacoblo.dataStructure.graph.Edge.BasicEdge;
import net.jacoblo.dataStructure.graph.Edge.Edgeable;
import net.jacoblo.dataStructure.graph.Edge.VisitEdge;
import net.jacoblo.dataStructure.graph.Vertex.BasicVertex;
import net.jacoblo.dataStructure.graph.Vertex.VisitVertex;
/**
 * Prim–Jarník algorithm
 *
 */
public class Prim {
	// cannot do <V extends VisitVertex<?>, E extends VisitEdge<?>>, because we actually create another vertices, needs to know the sub generic type VisitVertex<P extends Number>
	public static <P extends Number, W extends Number> UndirectedGraph<VisitVertex<P>,VisitEdge<W>> prim(UndirectedGraph<? extends VisitVertex<P>,? extends VisitEdge<W>> graph) {
		if (graph == null || graph.size() <= 0)	return new UndirectedGraph<>();
		
		// arrVertices save current processes, with each loop has 1 more vertex added in and set visit to true
		ArrayList<VisitVertex<P>> arrVertices = new ArrayList<>();
		// get a random start vertex
		VisitVertex<P> start = graph.getRandomVertex();
		start.visited = true;
		arrVertices.add(start);
		
		// resultVertices save new vertices with new shortest edges, for returning result, has to be the same position for each vertex with arrVertices, identicate it is the same processing vertex
		ArrayList<VisitVertex<P>> resultVertices = new ArrayList<>();
		resultVertices.add(new VisitVertex<P>(start.name, start.getX(),start.getY()));
		
		// base case, finish when all vertex is included
		while(arrVertices.size() < graph.size()) {
			// For All edges in the frontier Vertices, which one is the smallest. O( m + n ), as we visit all Vertices and Edges only once
			VisitEdge<W> smallestEdgeSoFar = null;
			int smallestEdgefromPointer = -1;
			for (int i = 0 ; i < arrVertices.size() ; i++) {
				for (Edgeable currentEdge : arrVertices.get(i).getEdges()) {
					VisitEdge<W> e = (VisitEdge<W>)currentEdge;
					// Skip, visit this edge already
					if (e.visitedEdge) {
						continue;
					}
					// Skip, this vertex is already in the X, skip to explore another Vertex
					else if (((VisitVertex<P>)e.getVertex(arrVertices.get(i))).visited) {
						continue;
					}
					else if (smallestEdgeSoFar == null || smallestEdgeSoFar.compareTo(e) > 0) {
						smallestEdgeSoFar = e;
						smallestEdgefromPointer = i;
					}
				}

			}
			// it should not be null
			if (smallestEdgeSoFar != null) {
				// set current smallest vertex in the frontier to the vertex across with smallest edge, clone of it of course. otherwise those vertices will have all the edges.
				VisitVertex<P> newV = new VisitVertex<P>(((VisitVertex<P>)smallestEdgeSoFar.getVertex(arrVertices.get(smallestEdgefromPointer))).name, 
						((VisitVertex<P>)smallestEdgeSoFar.getVertex(arrVertices.get(smallestEdgefromPointer))).getX(), 
						((VisitVertex<P>)smallestEdgeSoFar.getVertex(arrVertices.get(smallestEdgefromPointer))).getY());
				VisitVertex<P> current = resultVertices.get(smallestEdgefromPointer);
				VisitEdge<W> currentToNewV = new VisitEdge<W>(current, newV, smallestEdgeSoFar.getWeight());
				current.addEdge(currentToNewV);
				newV.addEdge(currentToNewV);
				
				// Now set visit to true
				smallestEdgeSoFar.visitedEdge = true;
				((VisitVertex<P>)smallestEdgeSoFar.getVertex(arrVertices.get(smallestEdgefromPointer))).visited = true;
				// arrVertices and resultVertices will have same position for the same cloned Vertex
				arrVertices.add(((VisitVertex<P>)smallestEdgeSoFar.getVertex(arrVertices.get(smallestEdgefromPointer))));
				resultVertices.add(newV);
			}
			
		}
	
		// not really needed, just convert ArrayList of Vertices to the graph
		UndirectedGraph<VisitVertex<P>,VisitEdge<W>> result = new UndirectedGraph<>();
		for (VisitVertex<P> v : resultVertices) {
			result.addVertex(v);
		}
		
		return result;
	}
}
