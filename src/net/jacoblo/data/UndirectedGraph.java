package net.jacoblo.data;

//TODO : Try to simplify the double initization of edges in undirected graph
public class UndirectedGraph<T extends Number, K extends Number> extends Graph<T, K>{
  @Override
  public void addEdge(Vertex<T,K> from, Vertex<T,K> to, K edgeWeight) {
    Edge<T,K> edge = new Edge<T,K>(from,to,edgeWeight);
    from.addEdge(edge);
    to.addEdge(edge);
  }
}
