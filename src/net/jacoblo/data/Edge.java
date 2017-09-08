package net.jacoblo.data;

import net.jacoblo.data.Vertex;

public class Edge<V extends Vertex<?,?>,K extends Number> implements Comparable<Edge<V,K>>{
  protected K weight;
  protected V from;
  protected V to;
  public boolean visitedEdge;
  
  public Edge(V f, V t, K w) {
    setWeight(w);
    setToVertex(t);
    setFromVertex(f);
    visitedEdge = false;
  }
  
  @Override
  public String toString() {
    String result = (from.name == null ? "" : from.name);
    result += " ( " + ((Vertex<?,?>)from).getX() + ", " + from.getY() + " ) "  + "--" + weight + "-> ";
    result += (to.name == null ? "" : to.name);
    result += " ( " + to.getX() + ", " + to.getY() + " ) ";
    return result;
  }
  
  // If vertex is from "from", then return to, if it is from "to", return "from"
  public V getVertex(V fromWhere) {
    if (fromWhere.equals(getFromVertex())) {
      return getToVertex();
    }
    else if (fromWhere.equals(getToVertex())) {
      return getFromVertex();
    }
    return null;
  }
  private V getToVertex() { return to; }
  private V getFromVertex() { return from; }
  public K getWeight() { return weight; }
  public void setToVertex(V t) { to = t; }
  public void setFromVertex(V f) { from = f; }
  public void setWeight(K w) { weight = w; }

	@Override
	public int compareTo(Edge<V, K> o) {
		return (int) (((Number) weight).doubleValue() - o.getWeight().doubleValue());
	}
	
}
