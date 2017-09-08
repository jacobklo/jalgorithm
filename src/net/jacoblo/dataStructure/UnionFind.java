package net.jacoblo.dataStructure;

import net.jacoblo.data.UnionFindItem;

public class UnionFind {
  public static <T> UnionFindItem<T> find(UnionFindItem<T> current) {
    // Find the leader of the current Node, the leader which is represented current group
    if (current == null) return null;
    return current.leader;
  }
  
  public static <T> UnionFindItem<T> union(UnionFindItem<T> group1, UnionFindItem<T> group2) {
    if (group1 == null || group2 == null) return null;
    UnionFindItem<T> leader1 = group1.leader;
    UnionFindItem<T> leader2 = group2.leader;
    
    if (leader1.equals(leader2)) {
      return leader1;
    }
    else if (leader1.children.size() >= leader2.children.size()) {
      for (UnionFindItem<T> item : leader2.children) {
        item.leader = leader1;
        leader1.children.add(item);
      }
      leader1.children.add(leader2);
      leader2.leader = leader1;
      leader2.children.clear();
      return leader1;
    }
    else {
      for (UnionFindItem<T> item : leader1.children) {
        item.leader = leader2;
        leader2.children.add(item);
      }
      leader2.children.add(leader1);
      leader1.leader = leader2;
      leader1.children.clear();
      return leader2;
    }
  }
}
