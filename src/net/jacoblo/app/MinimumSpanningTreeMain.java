package net.jacoblo.app;

import net.jacoblo.algorithm.Prim;
import net.jacoblo.data.UnionFindVertex;
import net.jacoblo.data.Vertex.BasicVertex;
import net.jacoblo.dataStructure.UndirectedGraph;

public class MinimumSpanningTreeMain {
	public static void main(String[] args) {
	  // Prim's Algorithm
	  
//		UndirectedGraph<Integer,Integer> graph = new UndirectedGraph<>();
//  Vertex<Integer, Integer> a = new Vertex<>("a",0,0);
//  Vertex<Integer, Integer> b = new Vertex<>("b",0,1);
//  Vertex<Integer, Integer> c = new Vertex<>("c",1,1);
//  Vertex<Integer, Integer> d = new Vertex<>("d",1,0);
//		
//		graph.addEdge(a, b, 4);
//		graph.addEdge(b, c, 1);
//		graph.addEdge(c, d, 2);
//		graph.addEdge(a, d, 5);
//		graph.addEdge(b, d, 3);
//		
//		graph.addVertex(a);
//		graph.addVertex(b);
//		graph.addVertex(c);
//		graph.addVertex(d);
//		
//		UndirectedGraph<Integer,Integer> result = Prim.prim(graph);
//		System.out.println(result);
		
		UnionFindVertex<Integer,Integer> au = new UnionFindVertex("a",0,0);
		UnionFindVertex<Integer,Integer> bu = new UnionFindVertex("b",0,1);
		UnionFindVertex<Integer,Integer> cu = new UnionFindVertex("c",1,1);
		UnionFindVertex<Integer,Integer> du = new UnionFindVertex("d",1,0);
		UnionFindVertex<Integer,Integer> eu = new UnionFindVertex("e",2,2);

		au.union(au, bu);
		bu.union(cu, du);
		au.union(au, eu);
		cu.union(au, cu);
		
	  System.out.println(au);
	  System.out.println(bu);
	  System.out.println(cu);
	  System.out.println(du);
	  System.out.println(eu);
	}
}
