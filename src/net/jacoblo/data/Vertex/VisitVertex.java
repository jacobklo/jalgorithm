package net.jacoblo.data.Vertex;

public class VisitVertex<T extends Number> extends BasicVertex<T>{
	private final String VERTEX_TYPE = "VisitVertex";
	public boolean visited;
	//public K currentDistance;

	public VisitVertex(String n, T x, T y) {
		super(n, x, y);
		visited = false;
	}

	public void setVisit(boolean visit) {
		visited = visit;
	}

	@Override
	public String getVertexType() {
		return VERTEX_TYPE;
	}
}
