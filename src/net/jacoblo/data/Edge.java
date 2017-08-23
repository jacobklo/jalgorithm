package net.jacoblo.data;

import net.jacoblo.data.Vertex;

public class Edge<T extends Number, K extends Number> implements Comparable<Edge<T,K>>{
  protected K weight;
  protected Vertex<T,K> from;
  protected Vertex<T,K> to;
  public boolean visitedEdge;
  
  public Edge(Vertex<T,K> f, Vertex<T,K> t, K w) {
    setWeight(w);
    setToVertex(t);
    setFromVertex(f);
    visitedEdge = false;
  }
  
  @Override
  public String toString() {
    return " ( " + from.getX() + ", " + from.getY() + " ) "  + "--" + weight + "-> ( " + to.getX() + ", " + to.getY() + " ) ";
  }
  
  // If vertex is from "from", then return to, if it is from "to", return "from"
  public Vertex<T,K> getVertex(Vertex<T,K> fromWhere) {
    if (fromWhere.equals(getFromVertex())) {
      return getToVertex();
    }
    else if (fromWhere.equals(getToVertex())) {
      return getFromVertex();
    }
    return null;
  }
  private Vertex<T,K> getToVertex() { return to; }
  private Vertex<T,K> getFromVertex() { return from; }
  public K getWeight() { return weight; }
  public void setToVertex(Vertex<T,K> t) { to = t; }
  public void setFromVertex(Vertex<T,K> f) { from = f; }
  public void setWeight(K w) { weight = w; }

	@Override
	public int compareTo(Edge<T, K> o) {
		return (int) (weight.doubleValue() - o.getWeight().doubleValue());
	}
	
}
