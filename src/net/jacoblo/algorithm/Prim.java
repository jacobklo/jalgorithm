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
		
		ArrayList<Vertex<P,W>> arrVertices = new ArrayList<>();
		Vertex<P,W> start = graph.getRandomVertex();
		arrVertices.add(start);
		
		ArrayList<Vertex<P,W>> resultVertices = new ArrayList<>();
		resultVertices.add(new Vertex<P,W>(start.name, start.getX(),start.getY()));
		
		while(arrVertices.size() < graph.size()) {
			Edge<P,W> smallestEdgeSoFar = null;
			int smallestEdgefromPointer = -1;
			for (int i = 0 ; i < arrVertices.size() ; i++) {
				for (Edge<P,W> e : arrVertices.get(i).getEdges()) {
					if (e.visitedEdge) {
						continue;
					}
					else if (e.getVertex(arrVertices.get(i)).visited) {
						continue;
					}
					else if (smallestEdgeSoFar == null || smallestEdgeSoFar.compareTo(e) > 0) {
						smallestEdgeSoFar = e;
						smallestEdgefromPointer = i;
					}
				}

			}
			if (smallestEdgeSoFar != null) {
				Vertex<P,W> newV = new Vertex<P,W>(smallestEdgeSoFar.getVertex(arrVertices.get(smallestEdgefromPointer)).name, 
						smallestEdgeSoFar.getVertex(arrVertices.get(smallestEdgefromPointer)).getX(), 
						smallestEdgeSoFar.getVertex(arrVertices.get(smallestEdgefromPointer)).getY());
				Vertex<P,W> current = resultVertices.get(smallestEdgefromPointer);
				Edge<P,W> currentToNewV = new Edge<P,W>(current, newV, smallestEdgeSoFar.getWeight());
				current.addEdge(currentToNewV);
				newV.addEdge(currentToNewV);
				resultVertices.add(newV);
				
				smallestEdgeSoFar.visitedEdge = true;
				smallestEdgeSoFar.getVertex(arrVertices.get(smallestEdgefromPointer)).visited = true;
				arrVertices.add(smallestEdgeSoFar.getVertex(arrVertices.get(smallestEdgefromPointer)));
				
			}
			
		}
	
		UndirectedGraph<P,W> result = new UndirectedGraph<P,W>();
		for (Vertex<P,W> v : resultVertices) {
			result.addVertex(v);
		}
		
		return result;
	}
}
