package net.jacoblo.app;

import net.jacoblo.algorithm.Prim;
import net.jacoblo.data.UnionFindVertex;
import net.jacoblo.data.Edge.VisitEdge;
import net.jacoblo.data.Vertex.BasicVertex;
import net.jacoblo.data.Vertex.VisitVertex;
import net.jacoblo.dataStructure.UndirectedGraph;

public class MinimumSpanningTreeMain {
	public static void main(String[] args) {
		testPrimsAlgorithm();
		
//		UnionFindVertex<Integer,Integer> au = new UnionFindVertex("a",0,0);
//		UnionFindVertex<Integer,Integer> bu = new UnionFindVertex("b",0,1);
//		UnionFindVertex<Integer,Integer> cu = new UnionFindVertex("c",1,1);
//		UnionFindVertex<Integer,Integer> du = new UnionFindVertex("d",1,0);
//		UnionFindVertex<Integer,Integer> eu = new UnionFindVertex("e",2,2);
//
//		au.union(au, bu);
//		bu.union(cu, du);
//		au.union(au, eu);
//		cu.union(au, cu);
//		
//	  System.out.println(au);
//	  System.out.println(bu);
//	  System.out.println(cu);
//	  System.out.println(du);
//	  System.out.println(eu);
	}
	
	public static void testPrimsAlgorithm() {
	  // Prim's Algorithm
	  
		UndirectedGraph<VisitVertex<Integer>,VisitEdge<Integer>> graph = new UndirectedGraph<>();
		VisitVertex<Integer> a = new VisitVertex<>("a",0,0);
		VisitVertex<Integer> b = new VisitVertex<>("b",0,1);
		VisitVertex<Integer> c = new VisitVertex<>("c",1,1);
		VisitVertex<Integer> d = new VisitVertex<>("d",1,0);
		
		UndirectedGraph.addEdge(a, b, 4);
		UndirectedGraph.addEdge(b, c, 1);
		UndirectedGraph.addEdge(c, d, 2);
		UndirectedGraph.addEdge(a, d, 5);
		UndirectedGraph.addEdge(b, d, 3);
		
		graph.addVertex(a);
		graph.addVertex(b);
		graph.addVertex(c);
		graph.addVertex(d);
		
		UndirectedGraph<VisitVertex<Integer>,VisitEdge<Integer>> result = Prim.prim(graph);
		System.out.println(result);
	}
}
