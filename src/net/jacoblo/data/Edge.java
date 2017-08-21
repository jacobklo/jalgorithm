package net.jacoblo.data;

public class Edge<T extends Number> {
	private T weight;
	private Vertex<?> from;
	private Vertex<?> to;
	
	public Edge(Vertex<?> f, Vertex<?> t, T w) {
		setWeight(w);
		setFromVertex(f);
		setToVertex(t);
	}
	
	public Vertex<?> getFromVertex() { return from; }
	public Vertex<?> getToVertex() { return to; }
	public T getWeight() { return weight; }
	public void setFromVertex(Vertex<?> f) { from = f; }
	public void setToVertex(Vertex<?> t) { to = t; }
	public void setWeight(T w) { weight = w; }
	
}
