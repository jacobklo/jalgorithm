package jacoblo.algorithm.Graph;

import java.util.ArrayList;
import java.util.HashMap;

public class CheckCyclicGraph {

  // TODO
  public static boolean isCyclicGraph(){ return false; }

  // REMEMBER : Using DFS to check if the start node be able to connect to end node
  public static boolean isCyclicGraphUtil(Node[] map, Node n, Node current) {

    if ( map == null || map.length <= 0 || n == null ) return false;

    if ( n.cityId == current.cityId ) return true;

    if ( current.visited ) return false;

    current.visited = true;

    for ( HashMap.Entry<Node, Boolean> me : map[current.cityId].connections.entrySet() ) {

      boolean subResult = isCyclicGraphUtil( map, n, me.getKey() );
      if (subResult)  return true;
    }

    return false;
  }

  public static boolean isCyclicGraphAndLinkedEnd(Node[] map, Node start, Node current, Node end, boolean comingBack) {

    if ( map == null || start == null || current == null || end == null ) return false;

    // case : if passed end node and come back to start node
    if ( comingBack && current.cityId == start.cityId ) return true;

    // case : if current is visited, end recursion
    if ( current.visited ) return false;

    // case : if not passed end node and come back to start node
    if ( !comingBack && current.cityId == end.cityId ) {
      comingBack = true;
    }

    current.visited = true;

    for ( HashMap.Entry<Node, Boolean> me : map[current.cityId].connections.entrySet()) {
      boolean subResult = isCyclicGraphAndLinkedEnd(map, start, me.getKey(), end, comingBack);
      if (subResult) return true;
    }

    return false;
  }

  protected static class Node {
    int cityId;
    boolean visited;
    HashMap<Node, Boolean> connections;

    public Node(int cityId) {
      this.cityId = cityId;
      connections = new HashMap<>();
    }

    public void addConnections( Node to) {
      connections.put( to, false );
    }

    @Override
    public String toString() { return ""+(cityId+1); }
  }
}
