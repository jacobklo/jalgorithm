package net.jacoblo.data;

import java.util.ArrayList;

public class UnionFindItem<T> {
  public T item;
  public UnionFindItem<T> leader;
  public ArrayList<UnionFindItem<T>> children;
  
  public UnionFindItem(T i) {
    item = i;
    leader = this;
    children = new ArrayList<>();
  }
  
  @Override
  public String toString() {
    String result = "+[ ";
    if (leader != null && leader.item != null) {
      result += "L_" + leader.item.toString();
    }
    if (item != null) {
      result += "->" + item.toString();
    }
    if (children != null) {
      result += "_" + children.size();
    }
    return result;
  }
  
  @Override
  public boolean equals(Object o) {
    if (o != null && (o instanceof UnionFindItem<?>)) {
      UnionFindItem<?> u = (UnionFindItem<?>) o;
      boolean result = true;
      if ( item == null) {
        result = result & u.item == null;
      }
      else {
        result = result & item.equals(u.item);
      }
      if (leader == null) {
        result = result & u.leader == null;
      }
      else {
        result = result & leader.equals(u.leader);
      }
      if (children == null) {
        result = result & u.children == null;
      }
      else {
        result = result & children.equals(u.children);
      }
      return result;
    }
    return false;
  }
}
