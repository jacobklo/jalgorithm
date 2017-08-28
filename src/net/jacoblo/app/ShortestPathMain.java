package net.jacoblo.app;

import java.util.ArrayList;

import net.jacoblo.algorithm.Dijkstra;
import net.jacoblo.data.Point;
import net.jacoblo.data.Vertex;
import net.jacoblo.dataStructure.UndirectedGraph;


public class ShortestPathMain {
	public static void main(String[] args) {
//		ArrayList<ArrayList<Integer>> locations = generatePoints();
//		ArrayList<Point<Integer>> points = convertToPoints(locations);
//		
//		ShortestPath<Point<Integer>,Integer> sp = new ShortestPath<Point<Integer>,Integer>();
//		ArrayList<Point<Integer>> sorted = sp.shortestPathGreedyQuickSort(points);
//		System.out.println(sorted);
		
	  UndirectedGraph<Integer, Integer> gra = generateGraph();
    ArrayList<Vertex<Integer,Integer>> result = Dijkstra.dijkstra(gra, gra.getVertices().get(0), gra.getVertices().get(4));
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
	
	public static UndirectedGraph<Integer, Integer> generateGraph() {
	  UndirectedGraph<Integer, Integer> gra = new UndirectedGraph<>();
    Vertex<Integer, Integer> v1 = new Vertex<>("v1", 0,0);
    Vertex<Integer, Integer> v2 = new Vertex<>("v2", 2,-1);
    Vertex<Integer, Integer> v3 = new Vertex<>("v3", 1,3);
    Vertex<Integer, Integer> v4 = new Vertex<>("v4", 5,4);
    Vertex<Integer, Integer> v5 = new Vertex<>("v5", 3,6);
    Vertex<Integer, Integer> v6 = new Vertex<>("v6", 0,5);
    
    gra.addEdge(v1, v2, 7);
    gra.addEdge(v1, v3, 9);
    gra.addEdge(v1, v6, 14);
    gra.addEdge(v2, v3, 10);
    gra.addEdge(v2, v4, 15);
    gra.addEdge(v3, v4, 11);
    gra.addEdge(v3, v6, 2);
    gra.addEdge(v4, v5, 6);
    gra.addEdge(v5, v6, 9);
    
    gra.addVertex(v1);
    gra.addVertex(v2);
    gra.addVertex(v3);
    gra.addVertex(v4);
    gra.addVertex(v5);
    gra.addVertex(v6);
    
    return gra;
	}
}
