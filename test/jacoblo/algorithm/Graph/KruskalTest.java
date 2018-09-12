package jacoblo.algorithm.Graph;

import jacoblo.dataStructure.UnionFind.UnionFindVertex;
import jacoblo.dataStructure.graph.Edge.VisitEdge;
import jacoblo.dataStructure.graph.UndirectedGraph;
import org.junit.jupiter.api.Test;

public class KruskalTest {
  @Test
  void testKruskal() {
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
}
