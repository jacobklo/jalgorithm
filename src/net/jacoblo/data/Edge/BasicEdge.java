package net.jacoblo.data.Edge;

import net.jacoblo.data.Vertex.Vertexable;

public class BasicEdge<K extends Number> 
	implements Edgeable,Comparable<Edgeable>{
	private final String EDGE_TYPE = "BasicEdge";
  protected K weight;
  protected Vertexable from;
  protected Vertexable to;
  
  public BasicEdge(Vertexable f, Vertexable t, K w) {
    setWeight(w);
    setToVertex(t);
    setFromVertex(f);
  }
  
  public String getEdgeType() {
  	return EDGE_TYPE;
  }
  
  @Override
  public String toString() {
    String result = "";
    if (weight != null) {
    	result += "e" + weight.toString();
    }
    return result;
  }
  
  // If vertex is from "from", then return to, if it is from "to", return "from"
  @Override
  public Vertexable getVertex(Vertexable fromWhere) {
    if (fromWhere.equals(getFromVertex())) {
      return getToVertex();
    }
    else if (fromWhere.equals(getToVertex())) {
      return getFromVertex();
    }
    return null;
  }
  @Override
  public Vertexable getToVertex() { return to; }
  @Override
  public Vertexable getFromVertex() { return from; }
  @Override
  public K getWeight() { return weight; }
  @Override
  public void setToVertex(Vertexable t) { to = t; }
  @Override
  public void setFromVertex(Vertexable f) { from = f; }
  @Override
  public void setWeight(Number w) { weight = (K)w; }

	@Override
	public int compareTo(Edgeable o) {
		return (int) (((Number) weight).doubleValue() - o.getWeight().doubleValue());
	}
	
}
