package jacoblo.dataStructure;

import static org.junit.jupiter.api.Assertions.assertEquals;

import org.junit.jupiter.api.Test;

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
  @Test
  void testEmpty() {
    BinarySearchTree bst = new BinarySearchTree();
    assertEquals("{ }", bst.toString());
  }

  @Test
  void testOne() {
    BinarySearchTree bst = new BinarySearchTree();
    bst.put(1);
    assertEquals("{ 0-1 }", bst.toString());
  }

  @Test
  void testOneMulti() {
    BinarySearchTree bst = new BinarySearchTree();
    bst.put(1);
    bst.put( 1 );
    assertEquals("{ 0-1 }", bst.toString());
  }

  @Test
  void testTwo() {
    BinarySearchTree bst = new BinarySearchTree();
    bst.put(1);
    bst.put( 2 );
    assertEquals("{ 0-1 1-2 }", bst.toString());
  }

  @Test
  void testTwoV2() {
    BinarySearchTree bst = new BinarySearchTree();
    bst.put(2);
    bst.put( 1 );
    assertEquals("{ 1-1 0-2 }", bst.toString());
  }

  @Test
  void testTwoMulti() {
    BinarySearchTree bst = new BinarySearchTree();
    bst.put(2);
    bst.put(2);
    bst.put( 1 );
    bst.put( 1 );
    assertEquals("{ 1-1 0-2 }", bst.toString());
  }

  @Test
  void testThree() {
    BinarySearchTree bst = new BinarySearchTree();
    bst.put(1);
    bst.put(2);
    bst.put(3);
    assertEquals("{ 0-1 1-2 2-3 }", bst.toString());
  }

  @Test
  void testThreeV2() {
    BinarySearchTree bst = new BinarySearchTree();
    bst.put(3);
    bst.put(2);
    bst.put(1);
    assertEquals("{ 2-1 1-2 0-3 }", bst.toString());
  }

  @Test
  void testThreeV3() {
    BinarySearchTree bst = new BinarySearchTree();
    bst.put(2);
    bst.put(3);
    bst.put(1);
    assertEquals("{ 1-1 0-2 1-3 }", bst.toString());
  }

  @Test
  void testThreeV4() {
    BinarySearchTree bst = new BinarySearchTree();
    bst.put(2);
    bst.put(1);
    bst.put(3);
    assertEquals("{ 1-1 0-2 1-3 }", bst.toString());
  }

  @Test
  void testThreeV5() {
    BinarySearchTree bst = new BinarySearchTree();
    bst.put(1);
    bst.put(3);
    bst.put(2);
    assertEquals("{ 0-1 2-2 1-3 }", bst.toString());
  }

  @Test
  void testSevenUnbalanced() {
    BinarySearchTree bst = new BinarySearchTree();
    for (int i = 1; i <= 7 ; i++ ) {
      bst.put( i );
    }
    assertEquals("{ 0-1 1-2 2-3 3-4 4-5 5-6 6-7 }", bst.toString());
  }

  @Test
  void testSevenUnbalancedReverse() {
    BinarySearchTree bst = new BinarySearchTree();
    for (int i = 7; i > 0 ; i-- ) {
      bst.put( i );
    }
    assertEquals("{ 6-1 5-2 4-3 3-4 2-5 1-6 0-7 }", bst.toString());
  }

  @Test
  void testSevenUnbalancedV2() {
    BinarySearchTree bst = new BinarySearchTree();
    bst.put(4);
    bst.put(3);
    bst.put(2);
    bst.put(1);
    bst.put(6);
    bst.put(5);
    bst.put(7);

    assertEquals("{ 3-1 2-2 1-3 0-4 2-5 1-6 2-7 }", bst.toString());
  }


  private BinarySearchTree genBalancedTree3Level() {
    BinarySearchTree bst = new BinarySearchTree();
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
    BinarySearchTree bst = genBalancedTree3Level();
    assertEquals("{ 3-1 2-2 3-3 1-4 2-6 3-7 0-8 3-9 2-10 1-12 3-13 2-14 3-15 }", bst.toString());
  }

  @Test
  void testEmptyRemove() {
    BinarySearchTree bst = new BinarySearchTree();
    bst.remove(1);
    assertEquals("{ }", bst.toString());
  }

  @Test
  void testRemoveNoChild() {
    BinarySearchTree bst = new BinarySearchTree();
    bst.put(1);
    bst.remove( 1 );
    assertEquals("{ }", bst.toString());
  }

  @Test
  void testRemoveNoChild2() {
    BinarySearchTree bst = genBalancedTree3Level();
    bst.remove(1);
    assertEquals("{ 2-2 3-3 1-4 2-6 3-7 0-8 3-9 2-10 1-12 3-13 2-14 3-15 }", bst.toString());
  }

  @Test
  void testRemoveNoChild3() {
    BinarySearchTree bst = genBalancedTree3Level();
    bst.remove(3);
    assertEquals("{ 3-1 2-2 1-4 2-6 3-7 0-8 3-9 2-10 1-12 3-13 2-14 3-15 }", bst.toString());
  }

  @Test
  void testRemoveOneNodeWithOneChild() {
    BinarySearchTree bst = genBalancedTree3Level();
    bst.remove(10);
    assertEquals("{ 3-1 2-2 3-3 1-4 2-6 3-7 0-8 2-9 1-12 3-13 2-14 3-15 }", bst.toString());
  }

  @Test
  void testRemoveOneNodeWithOneChild2() {
    BinarySearchTree bst = genBalancedTree3Level();
    bst.remove(6);
    assertEquals("{ 3-1 2-2 3-3 1-4 2-7 0-8 3-9 2-10 1-12 3-13 2-14 3-15 }", bst.toString());
  }

  @Test
  void testRemoveOneNodeWithTwoChildren() {
    BinarySearchTree bst = genBalancedTree3Level();
    bst.remove(2);
    assertEquals("{ 3-1 2-3 1-4 2-6 3-7 0-8 3-9 2-10 1-12 3-13 2-14 3-15 }", bst.toString());
  }

  @Test
  void testRemoveOneNodeWithTwoChildren2() {
    BinarySearchTree bst = genBalancedTree3Level();
    bst.remove(4);
    assertEquals("{ 3-1 2-2 3-3 1-6 2-7 0-8 3-9 2-10 1-12 3-13 2-14 3-15 }", bst.toString());
  }

  @Test
  void testRemoveOneNodeWithTwoChildren3() {
    BinarySearchTree bst = genBalancedTree3Level();
    bst.remove(14);
    assertEquals("{ 3-1 2-2 3-3 1-4 2-6 3-7 0-8 3-9 2-10 1-12 3-13 2-15 }", bst.toString());
  }

  @Test
  void testRemoveRoot() {
    BinarySearchTree bst = genBalancedTree3Level();
    bst.remove(8);
    assertEquals("{ 3-1 2-2 3-3 1-4 2-6 3-7 0-9 2-10 1-12 3-13 2-14 3-15 }", bst.toString());
  }
}