package net.jacoblo.data;

import java.util.ArrayList;

public class Vertex<T extends Number, K extends Number> extends Point<T> {
  private ArrayList<Edge<Vertex<T,K>,K>> edges;
  public String name;
  public boolean visited;
  public K currentDistance;

  public Vertex(String n, T x, T y) {
    this(x,y);
    name = n;
  }
  public Vertex(T x, T y) {
    super(x, y);
    visited = false;
    edges = new ArrayList<Edge<Vertex<T,K>,K>>();
  }
  
  public void addEdge(Edge<Vertex<T,K>,K> edge) {
    // TODO L expensive check
    for ( Edge<Vertex<T,K>,K> e : edges) {
      if (e.getVertex(this).equals(edge.getVertex(this))) {
        System.out.println("Edge is set already");
        return;
      }
    }
    edges.add(edge);
  }
  
  public ArrayList<Edge<Vertex<T,K>,K>> getEdges() { return edges; }
  
  @Override
  public String toString() {
    String result;
    if (name == null || name == "") {
      result = super.toString();
    }
    else {
      result = name;
    }
    for ( Edge<Vertex<T,K>,K> e : edges ) {
      result += e.toString() + ",, ";
    }
    return result;
  }
  
  @Override
  public boolean equals(Object other) {
  	if (other != null && other instanceof Vertex<?,?>) {
  		Vertex<?,?> o = (Vertex<?,?>) other;
  		return o.getX().equals(getX()) && o.getY().equals(getY()) && (name == null ? true : name.equals(o.name));
  	}
  	return false;
  }
  
  public void setVisit(boolean visit) {
		visited = visit;
	}
	
}