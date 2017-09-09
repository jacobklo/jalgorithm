package net.jacoblo.data.Edge;

import net.jacoblo.data.Vertex.Vertexable;

public interface Edgeable {
	public String getEdgeType();
	public Vertexable getVertex(Vertexable fromWhere);
	public Vertexable getFromVertex();
	public Vertexable getToVertex();
	public Number getWeight();
	public void setToVertex(Vertexable to);
	public void setFromVertex(Vertexable from);
	public void setWeight(Number w);
}
