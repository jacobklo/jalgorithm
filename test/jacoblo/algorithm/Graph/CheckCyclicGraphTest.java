package jacoblo.algorithm.Graph;

import org.junit.jupiter.api.Test;
import jacoblo.algorithm.Graph.CheckCyclicGraph.Node;

import java.util.ArrayList;

import static jacoblo.algorithm.Graph.CheckCyclicGraph.isCyclicGraphUtil;
import static jacoblo.algorithm.Graph.CheckCyclicGraph.isCyclicGraphAndLinkedEnd;
import static org.junit.jupiter.api.Assertions.assertFalse;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class CheckCyclicGraphTest {


  @Test
  void testCyclicUtil() {
    Node[] map = genMap();
    assertTrue( isCyclicGraphUtil( map, map[4], map[4] ) );
  }
  @Test
  void testCyclicUtil2() {
    Node[] map = genMap();
    assertFalse( isCyclicGraphUtil( map, map[4], map[3] ) );
  }
  @Test
  void testCyclicGraphAndLinkedEnd() {
    Node[] map = genMap();
    assertTrue( isCyclicGraphAndLinkedEnd( map, map[4], map[4], map[2], false));

  }
  @Test
  void testCyclicGraphAndLinkedEnd2() {
    Node[] map = genMap();
    assertTrue( isCyclicGraphAndLinkedEnd( map, map[6], map[6], map[8], false));

  }

  // 1 > 2 > 3
  //     ↑   ↓
  //     ↑   4
  //     ↑   ↓
  //     6 < 5 > 7 > 8
  //             ↑   ↓
  //             10< 9
  private Node[] genMap() {
    Node n1 = new Node(0);
    Node n2 = new Node(1);
    n1.addConnections(n2);
    Node n3 = new Node(2);
    n2.addConnections(n3);
    Node n4 = new Node(3);
    n3.addConnections(n4);
    Node n5 = new Node(4);
    n4.addConnections(n5);
    Node n7 = new Node(6);
    Node n6 = new Node(5);
    n5.addConnections(n6);
    n5.addConnections(n7);
    n6.addConnections(n2);
    Node n8 = new Node(7);
    n7.addConnections(n8);
    Node n9 = new Node(8);
    n8.addConnections(n9);
    Node n10 = new Node(9);
    n9.addConnections(n10);
    n10.addConnections(n7);
    Node[] result = { n1, n2, n3, n4, n5, n6, n7, n8, n9, n10 };
    return result;
  }
}
