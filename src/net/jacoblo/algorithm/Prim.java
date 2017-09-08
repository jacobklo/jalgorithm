package net.jacoblo.algorithm;

import java.util.ArrayList;

import net.jacoblo.data.Edge;
import net.jacoblo.data.Vertex;
import net.jacoblo.dataStructure.UndirectedGraph;
/**
 * Prim–Jarník algorithm
 *
 */
public class Prim {
	public static <P extends Number, W extends Number> UndirectedGraph<P,W> prim(UndirectedGraph<P,W> graph) {
		if (graph == null || graph.size() <= 0)	return new UndirectedGraph<P,W>();
		
		// arrVertices save current processes, with each loop has 1 more vertex added in and set visit to true
		ArrayList<Vertex<P,W>> arrVertices = new ArrayList<>();
		// get a random start vertex
		Vertex<P,W> start = graph.getRandomVertex();
		start.visited = true;
		arrVertices.add(start);
		
		// resultVertices save new vertices with new shortest edges, for returning result, has to be the same position for each vertex with arrVertices, identicate it is the same processing vertex
		ArrayList<Vertex<P,W>> resultVertices = new ArrayList<>();
		resultVertices.add(new Vertex<P,W>(start.name, start.getX(),start.getY()));
		
		// base case, finish when all vertex is included
		while(arrVertices.size() < graph.size()) {
			// For All edges in the frontier Vertices, which one is the smallest. O( m + n ), as we visit all Vertices and Edges only once
			Edge<Vertex<P,W>,W> smallestEdgeSoFar = null;
			int smallestEdgefromPointer = -1;
			for (int i = 0 ; i < arrVertices.size() ; i++) {
				for (Edge<Vertex<P,W>,W> e : arrVertices.get(i).getEdges()) {
					// Skip, visit this edge already
					if (e.visitedEdge) {
						continue;
					}
					// Skip, this vertex is already in the X, skip to explore another Vertex
					else if (e.getVertex(arrVertices.get(i)).visited) {
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
				Vertex<P,W> newV = new Vertex<P,W>(smallestEdgeSoFar.getVertex(arrVertices.get(smallestEdgefromPointer)).name, 
						smallestEdgeSoFar.getVertex(arrVertices.get(smallestEdgefromPointer)).getX(), 
						smallestEdgeSoFar.getVertex(arrVertices.get(smallestEdgefromPointer)).getY());
				Vertex<P,W> current = resultVertices.get(smallestEdgefromPointer);
				Edge<Vertex<P,W>,W> currentToNewV = new Edge<Vertex<P,W>,W>(current, newV, smallestEdgeSoFar.getWeight());
				current.addEdge(currentToNewV);
				newV.addEdge(currentToNewV);
				
				// Now set visit to true
				smallestEdgeSoFar.visitedEdge = true;
				smallestEdgeSoFar.getVertex(arrVertices.get(smallestEdgefromPointer)).visited = true;
				// arrVertices and resultVertices will have same position for the same cloned Vertex
				arrVertices.add(smallestEdgeSoFar.getVertex(arrVertices.get(smallestEdgefromPointer)));
				resultVertices.add(newV);
			}
			
		}
	
		// not really needed, just convert ArrayList of Vertices to the graph
		UndirectedGraph<P,W> result = new UndirectedGraph<P,W>();
		for (Vertex<P,W> v : resultVertices) {
			result.addVertex(v);
		}
		
		return result;
	}
}
