package net.jacoblo.dataStructure;

import java.util.Stack;

// Same as BinarySearchTree, but Node class is without level and parent pointer
public class BinarySearchTreeSimplify {
  private Node m_Root;

  public BinarySearchTreeSimplify() {}

  public void remove(int key) {
    m_Root = remove(m_Root, key);
  }

  public Node remove(Node n, int key) {
    // Case 0 : n should not be null
    if ( n == null ) return null;

    // Case 1 : recursively call remove to let left subtree handle. DON'T use contains(), definitely not efficient
    if (key < n.m_Key ) {
      n.m_Left = remove( n.m_Left, key );
    }
    // Case 2 : recursively call remove to let right subtree handle.
    else if (key > n.m_Key ) {
      n.m_Right = remove( n.m_Right, key );
    }
    // Case 3 : this is the key to remove
    else {
      // If only 1 child or 0 children, then just bring the child up and return
      if ( n.m_Left == null ) {
        return n.m_Right;
      }
      else if ( n.m_Right == null ) {
        return n.m_Left;
      }
      // If 2 children, then we need to find the next node ( smallest that is greater than n node )
      Node nextNode = higherEntry( n );
      n.m_Key = nextNode.m_Key;
      // disconnect the swapped node ( nextNode is now == toRmove node )
      n.m_Right = remove( n.m_Right, n.m_Key );
    }

    return n;
  }

  public void put(int key) {
    m_Root = put( m_Root, key );
  }

  // Main Idea : recursively call put, and when n node finally null, add the key.
  private Node put(Node n, int key) {
    // case 1 : n is null, it means this subtree has no key at all, so add this key
    if ( n == null)
      n = new Node(key);

    // Case 2 : key is smaller than n node, than recursively add to the left subtree
    else if ( key < n.m_Key ) {
      n.m_Left = put( n.m_Left, key);
    }

    // Case 3 : key is bigger than n node, than recursively add to the right subtree
    else if ( key > n.m_Key) {
      n.m_Right = put( n.m_Right, key);
    }

    return n;
  }

  // TODO : maybe use recursive?
  public Node higherEntry(Node n) {
    return null;
  }

  private static class Node {
    public int m_Key;
    public Node m_Left, m_Right;

    public Node(int k) { m_Key = k; }

    // REMEMBER : In-order approach
    @Override
    public String toString() {
      return ( m_Left != null ? m_Left.toString() : "" ) + m_Key + " " + ( m_Right != null ? m_Right.toString() : "" );
    }

    @Override
    public boolean equals(Object o) { return ( o instanceof Node ? ((Node) o).m_Key == this.m_Key : false); }
  }

}
