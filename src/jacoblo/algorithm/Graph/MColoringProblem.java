package jacoblo.algorithm.Graph;

import jacoblo.dataStructure.graph.Edge.BasicEdge;
import jacoblo.dataStructure.graph.UndirectedGraph;
import jacoblo.dataStructure.graph.Vertex.BasicVertex;

public class MColoringProblem {
  public static void main(String[] args) {
    UndirectedGraph<BasicVertex<Integer>,BasicEdge<Integer>> graph = new UndirectedGraph<>();
    BasicVertex<Integer> v1 = new BasicVertex<>("1",1,1);
    BasicVertex<Integer> v2 = new BasicVertex<>("2",2,2);
    BasicVertex<Integer> v3 = new BasicVertex<>("3",3,3);
    BasicVertex<Integer> v4 = new BasicVertex<>("4",4,4);
    
    graph.addVertex(v1);
    graph.addVertex(v2);
    graph.addVertex(v3);
    graph.addVertex(v4);
    
    UndirectedGraph.<BasicVertex<Integer>,Integer>addEdge(v1,v2,1);
    UndirectedGraph.<BasicVertex<Integer>,Integer>addEdge(v2,v3,1);
    UndirectedGraph.<BasicVertex<Integer>,Integer>addEdge(v3,v4,1);
    UndirectedGraph.<BasicVertex<Integer>,Integer>addEdge(v4,v1,1);
    UndirectedGraph.<BasicVertex<Integer>,Integer>addEdge(v1,v3,1);
    
    
    System.out.println(mColoringProblem(graph, 2));
  }
  
  public static int mColoringProblem(UndirectedGraph<BasicVertex<Integer>, BasicEdge<Integer>> graph, int numOfColor) {
    if (graph == null || graph.size() <= 0 ) return 0;
    
    for (BasicVertex<Integer> v : graph.getVertices()) {
      if (v.getEdges().size() > numOfColor) {
        return 0;
      }
    }
    return 1;
  }
}
