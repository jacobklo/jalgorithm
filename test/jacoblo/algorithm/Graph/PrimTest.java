package jacoblo.algorithm.Graph;

import jacoblo.dataStructure.graph.Edge.VisitEdge;
import jacoblo.dataStructure.graph.UndirectedGraph;
import jacoblo.dataStructure.graph.Vertex.VisitVertex;
import org.junit.jupiter.api.Test;

public class PrimTest {

  @Test
  void testPrimsAlgorithm() {
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
