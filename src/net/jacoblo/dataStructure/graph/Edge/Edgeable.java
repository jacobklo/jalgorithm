package net.jacoblo.dataStructure.graph.Edge;

import net.jacoblo.dataStructure.graph.Vertex.Vertexable;

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
