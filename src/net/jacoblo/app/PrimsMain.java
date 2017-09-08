package net.jacoblo.app;

import net.jacoblo.algorithm.Prim;
import net.jacoblo.data.Vertex;
import net.jacoblo.dataStructure.UndirectedGraph;

public class PrimsMain {
	public static void main(String[] args) {
		UndirectedGraph<Integer,Integer> graph = new UndirectedGraph<>();
		Vertex<Integer, Integer> a = new Vertex<>("a",0,0);
		Vertex<Integer, Integer> b = new Vertex<>("b",0,1);
		Vertex<Integer, Integer> c = new Vertex<>("c",1,1);
		Vertex<Integer, Integer> d = new Vertex<>("d",1,0);
		
		graph.addEdge(a, b, 4);
		graph.addEdge(b, c, 1);
		graph.addEdge(c, d, 2);
		graph.addEdge(a, d, 5);
		graph.addEdge(b, d, 3);
		
		graph.addVertex(a);
		graph.addVertex(b);
		graph.addVertex(c);
		graph.addVertex(d);
		
		UndirectedGraph<Integer,Integer> result = Prim.prim(graph);
		System.out.println(result);
	}
}
