package jacoblo.dataStructure.graph;

import java.util.ArrayList;

import jacoblo.algorithm.Graph.BreadthFirstSearch;
import jacoblo.dataStructure.graph.UndirectedGraph;
import jacoblo.dataStructure.graph.Vertex.BasicVertex;
import jacoblo.dataStructure.graph.Edge.BasicEdge;

public class TraversalMain {
	public static void main(String[] args) {
		testBFS();
	}
	
	public static void testBFS() {
		UndirectedGraph<BasicVertex<Integer>, BasicEdge<Integer>> graph = new UndirectedGraph<>();
		
		BasicVertex<Integer> v1 = new BasicVertex<>("v1", 0,0);
    
    for (int i = 0 ; i < 5 ; i++) {
    	BasicVertex<Integer> tmp = new BasicVertex<>(""+i, 0,0);
    	UndirectedGraph.addEdge(v1, tmp, i);
    	for (int j = 10 ; j < 40 ; j=j+10) {
    		BasicVertex<Integer> tmp2 = new BasicVertex<>(""+(j+i), 0,0);
    		UndirectedGraph.addEdge(tmp, tmp2, j*10);
    		graph.addVertex(tmp2);
    	}
    	graph.addVertex(tmp);
    }
    graph.addVertex(v1);
    
    
    
		ArrayList<BasicVertex<Integer>> result = BreadthFirstSearch.BreadthFirstSearch(graph, v1);
		System.out.println(result);
	}
}
