package net.jacoblo.app.algorithm.DynamicProgramming;

import net.jacoblo.algorithm.Graph.Kruskal;
import net.jacoblo.algorithm.Graph.Prim;
import net.jacoblo.dataStructure.UnionFind.UnionFind;
import net.jacoblo.dataStructure.UnionFind.UnionFindVertex;
import net.jacoblo.dataStructure.graph.UndirectedGraph;
import net.jacoblo.dataStructure.graph.Edge.VisitEdge;
import net.jacoblo.dataStructure.graph.Vertex.BasicVertex;
import net.jacoblo.dataStructure.graph.Vertex.VisitVertex;

public class MinimumSpanningTreeMain {
	public static void main(String[] args) {
		// testPrimsAlgorithm();
		
		// testUnionFind();
		
		testKruskal();
	}
	
	public static void testKruskal() {
		UndirectedGraph<UnionFindVertex<Integer>, VisitEdge<Integer>> graph = new UndirectedGraph<>();
		UnionFindVertex<Integer> a = new UnionFindVertex<>("a",0,0);
		UnionFindVertex<Integer> b = new UnionFindVertex<>("b",0,1);
		UnionFindVertex<Integer> c = new UnionFindVertex<>("c",1,1);
		UnionFindVertex<Integer> d = new UnionFindVertex<>("d",1,0);
		
		UndirectedGraph.addEdge(a, b, 4);
		UndirectedGraph.addEdge(b, c, 1);
		UndirectedGraph.addEdge(c, d, 2);
		UndirectedGraph.addEdge(a, d, 5);
		UndirectedGraph.addEdge(b, d, 3);
		
		graph.addVertex(a);
		graph.addVertex(b);
		graph.addVertex(c);
		graph.addVertex(d);
		
		UndirectedGraph<UnionFindVertex<Integer>, VisitEdge<Integer>> result = Kruskal.kruskal(graph);
		System.out.println(result);
	}
	
	public static void testUnionFind() {
		UnionFindVertex<Integer> au = new UnionFindVertex("a",0,0);
		UnionFindVertex<Integer> bu = new UnionFindVertex("b",0,1);
		UnionFindVertex<Integer> cu = new UnionFindVertex("c",1,1);
		UnionFindVertex<Integer> du = new UnionFindVertex("d",1,0);
		UnionFindVertex<Integer> eu = new UnionFindVertex("e",2,2);

		UnionFind.union(au, bu);
		UnionFind.union(cu, du);
		UnionFind.union(au, eu);
		UnionFind.union(au, cu);
		
		System.out.println(au.equals(bu));
		
		
	  System.out.println(au);
	  System.out.println(bu);
	  System.out.println(cu);
	  System.out.println(du);
	  System.out.println(eu);
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
