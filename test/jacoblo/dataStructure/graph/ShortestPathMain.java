package jacoblo.dataStructure.graph;

import java.util.ArrayList;

import jacoblo.algorithm.Graph.Dijkstra;
import jacoblo.dataStructure.graph.Edge.VisitEdge;
import jacoblo.dataStructure.graph.UndirectedGraph;
import jacoblo.dataStructure.graph.Vertex.VisitVertex;
import jacoblo.data.Point;


public class ShortestPathMain {
	public static void main(String[] args) {
//		ArrayList<ArrayList<Integer>> locations = generatePoints();
//		ArrayList<Point<Integer>> points = convertToPoints(locations);
//		
//		ShortestPath<Point<Integer>,Integer> sp = new ShortestPath<Point<Integer>,Integer>();
//		ArrayList<Point<Integer>> sorted = sp.shortestPathGreedyQuickSort(points);
//		System.out.println(sorted);
		
		UndirectedGraph<VisitVertex<Integer>, VisitEdge<Integer>> gra = generateGraph();
    ArrayList<VisitVertex<Integer>> result = Dijkstra.dijkstra(gra, gra.getVertices().get(0), gra.getVertices().get(4));
	  System.out.println(result);
		
	  
	 
	  
	}
	
	public static ArrayList<Point<Integer>> convertToPoints(ArrayList<ArrayList<Integer>> locations) {
		ArrayList<Point<Integer>> result = new ArrayList<Point<Integer>>();
		for (int i = 0 ; i < locations.size() ; i++) {
			result.add(new Point<Integer>(locations.get(i).get(0), locations.get(i).get(1)));
		}
		return result;
	}
	
	public static ArrayList<ArrayList<Integer>> generatePoints() {
		ArrayList<ArrayList<Integer>> locations = new ArrayList<ArrayList<Integer>>();
		ArrayList<Integer> p1 = new ArrayList<Integer>();
		p1.add(5);
		p1.add(10);
		locations.add(p1);
		ArrayList<Integer> p2 = new ArrayList<Integer>();
		p2.add(1);
		p2.add(2);
		locations.add(p2);
		ArrayList<Integer> p3 = new ArrayList<Integer>();
		p3.add(1);
		p3.add(-1);
		locations.add(p3);
		ArrayList<Integer> p4 = new ArrayList<Integer>();
		p4.add(3);
		p4.add(4);
		locations.add(p4);
		return locations;
	}
	
	public static UndirectedGraph<VisitVertex<Integer>, VisitEdge<Integer>> generateGraph() {
		UndirectedGraph<VisitVertex<Integer>, VisitEdge<Integer>> gra = new UndirectedGraph<>();
		VisitVertex<Integer> v1 = new VisitVertex<>("v1", 0,0);
		VisitVertex<Integer> v2 = new VisitVertex<>("v2", 2,-1);
		VisitVertex<Integer> v3 = new VisitVertex<>("v3", 1,3);
		VisitVertex<Integer> v4 = new VisitVertex<>("v4", 5,4);
		VisitVertex<Integer> v5 = new VisitVertex<>("v5", 3,6);
		VisitVertex<Integer> v6 = new VisitVertex<>("v6", 0,5);
    
    UndirectedGraph.addEdge(v1, v2, 7);
    UndirectedGraph.addEdge(v1, v3, 9);
    UndirectedGraph.addEdge(v1, v6, 14);
    UndirectedGraph.addEdge(v2, v3, 10);
    UndirectedGraph.addEdge(v2, v4, 15);
    UndirectedGraph.addEdge(v3, v4, 11);
    UndirectedGraph.addEdge(v3, v6, 2);
    UndirectedGraph.addEdge(v4, v5, 6);
    UndirectedGraph.addEdge(v5, v6, 9);
    
    gra.addVertex(v1);
    gra.addVertex(v2);
    gra.addVertex(v3);
    gra.addVertex(v4);
    gra.addVertex(v5);
    gra.addVertex(v6);
    
    return gra;
	}
}
