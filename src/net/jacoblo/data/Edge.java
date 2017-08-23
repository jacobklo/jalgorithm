package net.jacoblo.data;

import net.jacoblo.data.Vertex;

public class Edge<T extends Number, K extends Number> implements Comparable<Edge<T,K>>{
  protected K weight;
  protected Vertex<T,K> to;
  public boolean visitedEdge;
  
  public Edge(Vertex<T,K> t, K w) {
    setWeight(w);
    setToVertex(t);
    visitedEdge = false;
  }
  
  @Override
  public String toString() {
    return "--" + weight + "-> ( " + to.getX() + ", " + to.getY() + " ) ";
  }
  public Vertex<T,K> getToVertex() { return to; }
  public K getWeight() { return weight; }
  public void setToVertex(Vertex<T,K> t) { to = t; }
  public void setWeight(K w) { weight = w; }

	@Override
	public int compareTo(Edge<T, K> o) {
		return (int) (weight.doubleValue() - o.getWeight().doubleValue());
	}
	
}
