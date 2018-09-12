package jacoblo.dataStructure.graph.Vertex;

import java.util.ArrayList;

import jacoblo.data.Point;
import jacoblo.dataStructure.graph.Edge.Edgeable;

public class BasicVertex<T extends Number> extends Point<T> implements Vertexable{
	private final String VERTEX_TYPE = "BasicVertex";
  private ArrayList<Edgeable> edges;
  public String name;

  public BasicVertex(String n, T x, T y) {
    this(x,y);
    name = n;
  }
  public BasicVertex(T x, T y) {
    super(x, y);
    edges = new ArrayList<Edgeable>();
  }
  
  @Override
  public String getVertexType() {
  	return VERTEX_TYPE;
  }
  
  @Override
  public void addEdge(Edgeable edge) {
    // TODO L expensive check
    for ( Edgeable e : edges) {
      if (e.getVertex(this).equals(edge.getVertex(this))) {
        System.out.println("Edge is set already");
        return;
      }
    }
    edges.add(edge);
  }
  
  @Override
  public ArrayList<Edgeable> getEdges() { return edges; }
  
  @Override
  public String toString() {
    String result;
    if (name == null || name == "") {
      result = super.toString();
    }
    else {
      result = name;
    }
//    for ( Edgeable e : edges ) {
//      result += e.toString() + ",, ";
//    }
    return result;
  }
  
  @Override
  public boolean equals(Object other) {
  	if (other != null && other instanceof BasicVertex<?>) {
  		BasicVertex<?> o = (BasicVertex<?>) other;
  		return o.getX().equals(getX()) && o.getY().equals(getY()) && (name == null ? true : name.equals(o.name));
  	}
  	return false;
  }
  
}