package net.jacoblo.dataStructure.UnionFind;

import net.jacoblo.dataStructure.UnionFind.UnionFind.UnionFindable;

public class UnionFind {
	
	public static <U extends UnionFindable> U find(U current) {
		if (current == null || !(current instanceof UnionFindable)) return null;
		U u = (U) current;
    return (U) u.getLeader();
	}

	public static <U extends UnionFindable> U union(U group1, U group2) {
		if (group1 == null || group2 == null || !(group1 instanceof UnionFindable) || !(group2 instanceof UnionFindable)) return null;
		U g1 = (U) group1;
		U g2 = (U) group2;
		
		U leader1 = (U) g1.getLeader();
		U leader2 = (U) g2.getLeader();
    
    if (leader1.equals(leader2)) {
      return leader1;
    }
    else if (leader1.getChildren().size() >= leader2.getChildren().size()) {
      for (UnionFindable item : leader2.getChildren()) {
        item.setLeader(leader1);
        leader1.getChildren().add(item);
      }
      leader1.getChildren().add(leader2);
      leader2.setLeader(leader1);
      leader2.getChildren().clear();
      return leader1;
    }
    else {
      for (UnionFindable item : leader1.getChildren()) {
        item.setLeader(leader2);
        leader2.getChildren().add(item);
      }
      leader2.getChildren().add(leader1);
      leader1.setLeader( leader2);
      leader1.getChildren().clear();
      return leader2;
    }
	}
}
