package jacoblo.dataStructure.graph.Vertex;

import java.util.ArrayList;

import jacoblo.dataStructure.graph.Edge.Edgeable;

public interface Vertexable {
	public String getVertexType();
	public void addEdge(Edgeable edge);
	public ArrayList<Edgeable> getEdges();
}
