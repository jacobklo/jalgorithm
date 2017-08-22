package net.jacoblo.data;

import java.util.ArrayList;

public class Vertex<T extends Number, K extends Number> extends Point<T> {
  private ArrayList<Edge<T,K>> edges;
  private String name;
  
  public Vertex(String n, T x, T y) {
    this(x,y);
    name = n;
  }
  public Vertex(T x, T y) {
    super(x, y);
    edges = new ArrayList<Edge<T,K>>();
  }

  void addEdge(Edge<T,K> edge) {
    // TODO L expensive check
    for ( Edge<T,K> e : edges) {
      if (e.getToVertex().equals(edge.getToVertex())) {
        System.out.println("Edge is set already");
        return;
      }
    }
    edges.add(edge);
  }
  
  public ArrayList<Edge<T,K>> getEdges() { return edges; }
  
  @Override
  public String toString() {
    String result;
    if (name == null || name == "") {
      result = super.toString();
    }
    else {
      result = name;
    }
//    for ( Edge<T,K> e : edges ) {
//      result += e.toString() + ",, ";
//    }
    return result;
  }
  
}