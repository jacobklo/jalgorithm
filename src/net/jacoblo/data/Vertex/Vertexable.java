package net.jacoblo.data.Vertex;

import java.util.ArrayList;

import net.jacoblo.data.Edge.Edgeable;

public interface Vertexable {
	public String getVertexType();
	public void addEdge(Edgeable edge);
	public ArrayList<Edgeable> getEdges();
}
