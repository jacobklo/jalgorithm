package net.jacoblo.data;

//TODO : Try to simplify the double initization of edges in undirected graph
public class UndirectedGraph<T extends Number, K extends Number> extends Graph<T, K>{
  @Override
  public void addEdge(Vertex<T,K> from, Vertex<T,K> to, K edgeWeight) {
    super.addEdge(from, to, edgeWeight);
    Edge<T,K> edge = new Edge<T,K>(from, edgeWeight);
    to.addEdge(edge);
  }
}
