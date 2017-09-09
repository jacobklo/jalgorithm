package net.jacoblo.data;

import java.util.ArrayList;

import net.jacoblo.data.Vertex.BasicVertex;

public class UnionFindVertex<P extends Number, W extends Number> extends BasicVertex<P,W> implements UnionFindable{
	public UnionFindVertex<P,W> leader;
	public ArrayList<UnionFindVertex<P,W>> children;
	
	public UnionFindVertex(String n, P x, P y) {
		super(n, x, y);
		leader = this;
    children = new ArrayList<>();
	}
	
	@Override
	public UnionFindable find(UnionFindable current) {
		if (current == null || !(current instanceof UnionFindVertex<?,?>)) return null;
		UnionFindVertex<P,W> u = (UnionFindVertex<P,W>) current;
    return u.leader;
	}

	@Override
	public UnionFindable union(UnionFindable group1, UnionFindable group2) {
		if (group1 == null || group2 == null || !(group1 instanceof UnionFindVertex<?,?>) || !(group2 instanceof UnionFindVertex<?,?>)) return null;
		UnionFindVertex<P,W> g1 = (UnionFindVertex<P,W>) group1;
		UnionFindVertex<P,W> g2 = (UnionFindVertex<P,W>) group2;
		
		UnionFindVertex<P,W> leader1 = g1.leader;
		UnionFindVertex<P,W> leader2 = g2.leader;
    
    if (leader1.equals(leader2)) {
      return leader1;
    }
    else if (leader1.children.size() >= leader2.children.size()) {
      for (UnionFindVertex<P,W> item : leader2.children) {
        item.leader = leader1;
        leader1.children.add(item);
      }
      leader1.children.add(leader2);
      leader2.leader = leader1;
      leader2.children.clear();
      return leader1;
    }
    else {
      for (UnionFindVertex<P,W> item : leader1.children) {
        item.leader = leader2;
        leader2.children.add(item);
      }
      leader2.children.add(leader1);
      leader1.leader = leader2;
      leader1.children.clear();
      return leader2;
    }
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
    if (o != null && (o instanceof UnionFindVertex<?,?>)) {
    	UnionFindVertex<?,?> u = (UnionFindVertex<?,?>) o;
      boolean result = true;
      result = super.equals(o) && leader == u.leader && children.equals(u.children);
      return result;
    }
    return false;
  }
}
