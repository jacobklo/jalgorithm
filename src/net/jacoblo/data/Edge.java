package net.jacoblo.data;

import net.jacoblo.data.Vertex;

public class Edge<T extends Number, K extends Number> {
  private K weight;
  private Vertex<T,K> to;
  
  public Edge(Vertex<T,K> t, K w) {
    setWeight(w);
    setToVertex(t);
  }
  
  @Override
  public String toString() {
    return "--" + weight + "-> ( " + to.getX() + ", " + to.getY() + " ) ";
  }
  public Vertex<T,K> getToVertex() { return to; }
  public K getWeight() { return weight; }
  public void setToVertex(Vertex<T,K> t) { to = t; }
  public void setWeight(K w) { weight = w; }
  
}