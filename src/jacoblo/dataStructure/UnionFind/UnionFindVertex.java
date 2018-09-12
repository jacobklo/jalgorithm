package jacoblo.dataStructure.UnionFind;

import java.util.ArrayList;

import jacoblo.dataStructure.graph.Vertex.VisitVertex;

public class UnionFindVertex<P extends Number> extends VisitVertex<P> implements UnionFindable{
	private final String VERTEX_TYPE = "UnionFindVertex";
	public UnionFindVertex<P> leader;
	public ArrayList<UnionFindable> children;
	
	public UnionFindVertex(String n, P x, P y) {
		super(n, x, y);
		leader = this;
    children = new ArrayList<>();
	}
	
	@Override
	public String getVertexType() {
		return VERTEX_TYPE;
	}

	@Override
  public String toString() {
    String result = "+( ";
    if (leader != null ) {
      result += "L_" + leader.name;
    }
    if (name != null) {
      result += "->" + name;
    }
    if (children != null) {
      result += "" + children.size();
    }
    result += " )";
    return result;
  }
  
  @Override
  public boolean equals(Object o) {
    if (o != null && (o instanceof UnionFindVertex<?>)) {
    	UnionFindVertex<?> u = (UnionFindVertex<?>) o;
      boolean result = true;
      result = super.equals(o) && leader == u.leader && children.equals(u.children);
      return result;
    }
    return false;
  }

	@Override
	public UnionFindable getLeader() {
		return leader;
	}

	@Override
	public boolean setLeader(UnionFindable newLeader) {
		if (newLeader == null || !(newLeader instanceof UnionFindVertex<?>)) {
			return false;
		}
		leader = (UnionFindVertex<P>) newLeader;
		return true;
	}

	@Override
	public ArrayList<UnionFindable> getChildren() {
		return children;
	}

}
