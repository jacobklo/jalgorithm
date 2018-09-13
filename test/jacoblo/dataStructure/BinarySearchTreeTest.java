package jacoblo.dataStructure;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class BinarySearchTreeTest {

  // Methods that do not use from BinarySearchTree class
  /*
// TODO : use swap Node to swap all pointer, instead of just changing the key
  private void swapValue(Node a, Node b ) {
    int tmpKey = a.m_Key;
    a.m_Key = b.m_Key;
    b.m_Key = tmpKey;
  }

  public Node contains(Node n, int key) {
    if ( n == null ) return null;
    if ( n.m_Key == key ) return n;
    Node result = contains( n.m_Left, key );
    if ( result == null ) {
      contains( n.m_Right, key );
    }
    return result;
  }

  public Node lowerEntry(Node n ) {
    if ( n == null ) return null;
    Node current = n;

    // Case 1 : if n.left is not null, then the last node is the greatest key of that node ( left node )
    if ( n.m_Left != null ) {
      current = n.m_Left;
      while ( current.m_Right != null ) {
        current = current.m_Right;
      }
      return current;
    }

    // Case 2 : if n.left is null, then last null must be the parent. More particular, the first gen that grandpa is a right node.
    while ( current.m_Parent != null ) {
      Node currentParent = current.m_Parent;
      // REMEMBER: null check
      if ( currentParent.m_Right != null && currentParent.m_Right.m_Key == current.m_Key ) {
        return currentParent;
      }
      current = currentParent;
    }

    return null;
  }


   */

  private class BinarySearchTreeClass extends BinarySearchTreeSimplify {}
//  private class BinarySearchTreeClass extends BinarySearchTree {}

  @Test
  void testEmpty() {
    BinarySearchTreeClass bst = new BinarySearchTreeClass();
    assertEquals(null, bst.m_Root);
  }

  @Test
  void testOne() {
    BinarySearchTreeClass bst = new BinarySearchTreeClass();
    bst.put(1);
    assertEquals("0-1 ", bst.toString());
  }

  @Test
  void testOneMulti() {
    BinarySearchTreeClass bst = new BinarySearchTreeClass();
    bst.put(1);
    bst.put( 1 );
    assertEquals("0-1 ", bst.toString());
  }

  @Test
  void testTwo() {
    BinarySearchTreeClass bst = new BinarySearchTreeClass();
    bst.put(1);
    bst.put( 2 );
    assertEquals("0-1 1-2 ", bst.toString());
  }

  @Test
  void testTwoV2() {
    BinarySearchTreeClass bst = new BinarySearchTreeClass();
    bst.put(2);
    bst.put( 1 );
    assertEquals("1-1 0-2 ", bst.toString());
  }

  @Test
  void testTwoMulti() {
    BinarySearchTreeClass bst = new BinarySearchTreeClass();
    bst.put(2);
    bst.put(2);
    bst.put( 1 );
    bst.put( 1 );
    assertEquals("1-1 0-2 ", bst.toString());
  }

  @Test
  void testThree() {
    BinarySearchTreeClass bst = new BinarySearchTreeClass();
    bst.put(1);
    bst.put(2);
    bst.put(3);
    assertEquals("0-1 1-2 2-3 ", bst.toString());
  }

  @Test
  void testThreeV2() {
    BinarySearchTreeClass bst = new BinarySearchTreeClass();
    bst.put(3);
    bst.put(2);
    bst.put(1);
    assertEquals("2-1 1-2 0-3 ", bst.toString());
  }

  @Test
  void testThreeV3() {
    BinarySearchTreeClass bst = new BinarySearchTreeClass();
    bst.put(2);
    bst.put(3);
    bst.put(1);
    assertEquals("1-1 0-2 1-3 ", bst.toString());
  }

  @Test
  void testThreeV4() {
    BinarySearchTreeClass bst = new BinarySearchTreeClass();
    bst.put(2);
    bst.put(1);
    bst.put(3);
    assertEquals("1-1 0-2 1-3 ", bst.toString());
  }

  @Test
  void testThreeV5() {
    BinarySearchTreeClass bst = new BinarySearchTreeClass();
    bst.put(1);
    bst.put(3);
    bst.put(2);
    assertEquals("0-1 2-2 1-3 ", bst.toString());
  }

  @Test
  void testSevenUnbalanced() {
    BinarySearchTreeClass bst = new BinarySearchTreeClass();
    for (int i = 1; i <= 7 ; i++ ) {
      bst.put( i );
    }
    assertEquals("0-1 1-2 2-3 3-4 4-5 5-6 6-7 ", bst.toString());
  }

  @Test
  void testSevenUnbalancedReverse() {
    BinarySearchTreeClass bst = new BinarySearchTreeClass();
    for (int i = 7; i > 0 ; i-- ) {
      bst.put( i );
    }
    assertEquals("6-1 5-2 4-3 3-4 2-5 1-6 0-7 ", bst.toString());
  }

  @Test
  void testSevenUnbalancedV2() {
    BinarySearchTreeClass bst = new BinarySearchTreeClass();
    bst.put(4);
    bst.put(3);
    bst.put(2);
    bst.put(1);
    bst.put(6);
    bst.put(5);
    bst.put(7);

    assertEquals("3-1 2-2 1-3 0-4 2-5 1-6 2-7 ", bst.toString());
  }


  private BinarySearchTreeClass genBalancedTree3Level() {
    BinarySearchTreeClass bst = new BinarySearchTreeClass();
    bst.put(8);
    bst.put(4);
    bst.put(2);
    bst.put(1);
    bst.put(3);
    bst.put(6);
    bst.put(7);
    bst.put(12);
    bst.put(10);
    bst.put(9);
    bst.put(14);
    bst.put(13);
    bst.put(15);
    return bst;
  }

  @Test
  void testBalancedTree3Level() {
    BinarySearchTreeClass bst = genBalancedTree3Level();
    assertEquals("3-1 2-2 3-3 1-4 2-6 3-7 0-8 3-9 2-10 1-12 3-13 2-14 3-15 ", bst.toString());
  }

  @Test
  void testEmptyRemove() {
    BinarySearchTreeClass bst = new BinarySearchTreeClass();
    bst.remove(1);
    assertEquals(null, bst.m_Root);
  }

  @Test
  void testRemoveNoChild() {
    BinarySearchTreeClass bst = new BinarySearchTreeClass();
    bst.put(1);
    bst.remove( 1 );
    assertEquals(null, bst.m_Root);
  }

  @Test
  void testRemoveNoChild2() {
    BinarySearchTreeClass bst = genBalancedTree3Level();
    bst.remove(1);
    assertEquals("2-2 3-3 1-4 2-6 3-7 0-8 3-9 2-10 1-12 3-13 2-14 3-15 ", bst.toString());
  }

  @Test
  void testRemoveNoChild3() {
    BinarySearchTreeClass bst = genBalancedTree3Level();
    bst.remove(3);
    assertEquals("3-1 2-2 1-4 2-6 3-7 0-8 3-9 2-10 1-12 3-13 2-14 3-15 ", bst.toString());
  }

  @Test
  void testRemoveOneNodeWithOneChild() {
    BinarySearchTreeClass bst = genBalancedTree3Level();
    bst.remove(10);
    assertEquals("3-1 2-2 3-3 1-4 2-6 3-7 0-8 2-9 1-12 3-13 2-14 3-15 ", bst.toString());
  }

  @Test
  void testRemoveOneNodeWithOneChild2() {
    BinarySearchTreeClass bst = genBalancedTree3Level();
    bst.remove(6);
    assertEquals("3-1 2-2 3-3 1-4 2-7 0-8 3-9 2-10 1-12 3-13 2-14 3-15 ", bst.toString());
  }

  @Test
  void testRemoveOneNodeWithTwoChildren() {
    BinarySearchTreeClass bst = genBalancedTree3Level();
    bst.remove(2);
    assertEquals("3-1 2-3 1-4 2-6 3-7 0-8 3-9 2-10 1-12 3-13 2-14 3-15 ", bst.toString());
  }

  @Test
  void testRemoveOneNodeWithTwoChildren2() {
    BinarySearchTreeClass bst = genBalancedTree3Level();
    bst.remove(4);
    assertEquals("3-1 2-2 3-3 1-6 2-7 0-8 3-9 2-10 1-12 3-13 2-14 3-15 ", bst.toString());
  }

  @Test
  void testRemoveOneNodeWithTwoChildren3() {
    BinarySearchTreeClass bst = genBalancedTree3Level();
    bst.remove(14);
    assertEquals("3-1 2-2 3-3 1-4 2-6 3-7 0-8 3-9 2-10 1-12 3-13 2-15 ", bst.toString());
  }

  @Test
  void testRemoveRoot() {
    BinarySearchTreeClass bst = genBalancedTree3Level();
    bst.remove(8);
    assertEquals("3-1 2-2 3-3 1-4 2-6 3-7 0-9 2-10 1-12 3-13 2-14 3-15 ", bst.toString());
  }

  // REMEMBER : stream.collect, stream.map
  @Test
  void testToArray() {
    BinarySearchTreeClass bst = genBalancedTree3Level();
    ArrayList<Integer> al = Arrays.stream(bst.toArray(bst.m_Root))
                                  .map(node -> node.m_Key)
                                  .collect(Collectors.toCollection(ArrayList::new));
    assertEquals("[1, 2, 3, 4, 6, 7, 8, 9, 10, 12, 13, 14, 15]", al.toString());
  }
}