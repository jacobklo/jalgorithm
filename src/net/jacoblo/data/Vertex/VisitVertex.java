package net.jacoblo.data.Vertex;

public class VisitVertex<T extends Number> extends BasicVertex<T>{
public boolean visited;
//public K currentDistance;

	public VisitVertex(String n, T x, T y) {
		super(n, x, y);
		visited = false;
	}

	public void setVisit(boolean visit) {
		visited = visit;
	}

}
