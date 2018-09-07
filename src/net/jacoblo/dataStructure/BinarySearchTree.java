package net.jacoblo.dataStructure;

public class BinarySearchTree {
  private Node m_Root;

  public BinarySearchTree() {}

  public Node contains(Node n, int key) {
    if ( n == null ) return null;
    if ( n.m_Key == key ) return n;
    Node result = contains( n.m_Left, key );
    if ( result == null ) {
      contains( n.m_Right, key );
    }
    return result;
  }

  public Node remove(int key) {
    Node toRemove = contains( m_Root, key );

    // Case 1 : this tree did not contains
    if ( toRemove == null ) return null;

    // Case 2 : remove node's left subtree is not empty. move the greatest key in that left subtree
    if ( toRemove.m_Left != null ) {
      Node lastNode = lowerEntry( toRemove );
      swapValue ( toRemove, lastNode );
      // REMEMBER : Consider the tree : Root-8, left of 8 = 3, right of 3 = 6, left of 6 = 4, The lastNode is 6, but also has a child 4 on left.
      lastNode.m_Parent.m_Right = lastNode.m_Left;
      if ( lastNode.m_Left != null ) {
        lastNode.m_Left.m_Parent = lastNode.m_Parent;
      }
    }

    // Case 3 : remove node's left subtree is empty. move the least key in the right subtree then
    else if ( toRemove.m_Right != null ){
      Node nextNode = higherEntry( toRemove );
      swapValue ( toRemove, nextNode );
      nextNode.m_Parent.m_Left = nextNode.m_Right;
      if ( nextNode.m_Right != null ) {
        nextNode.m_Right.m_Parent = nextNode.m_Parent;
      }
    }
    // Case 4 : the remove node is end node, no child, but it is not the root node.
    else if ( toRemove.m_Key != m_Root.m_Key ){
      Node parentNode = toRemove.m_Parent;
      if (parentNode.m_Left.m_Key == toRemove.m_Key ) {
        parentNode.m_Left = null;
      }
      else if ( parentNode.m_Right.m_Key == toRemove.m_Key ) {
        parentNode.m_Right = null;
      }
    }
    // Case 5 : this tree has only 1 node, and to remove this node
    else {
      m_Root = null;
    }

    return toRemove;
  }

  public void put(int key) {
    m_Root = put( m_Root, key, 0 );
  }

  // Main Idea : recursively call put, and when n node finally null, add the key.
  private Node put(Node n, int key, int level) {
    // case 1 : n is null, it means this subtree has no key at all, so add this key
    if ( n == null)
      n = new Node(key, level);

    // Case 2 : key is smaller than n node, than recursively add to the left subtree
    else if ( key < n.m_Key ) {
      n.m_Left = put( n.m_Left, key, level + 1 );
      n.m_Left.m_Parent = n;
    }

    // Case 3 : key is bigger than n node, than recursively add to the right subtree
    else if ( key > n.m_Key) {
      n.m_Right = put( n.m_Right, key, level + 1);
      n.m_Right.m_Parent = n;
    }

    return n;
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
      if ( currentParent.m_Right != null /*REMEMBER: null check */ && currentParent.m_Right.m_Key == current.m_Key ) {
        return currentParent;
      }
      current = currentParent;
    }

    return null;
  }

  public Node higherEntry(Node n) {
    if ( n == null ) return null;
    Node current = n;

    // Case 1 : if n.right is not null, then the next node is the most left of that right node
    if ( n.m_Right != null) {
      current = n.m_Right;
      while( current.m_Left != null ) {
        current = current.m_Left;
      }
      return current;
    }

    // Case 2 : if n is on the left of parent, then n's parent is the next key, next smallest key that is higher than n.
    // Case 3 : if n is on the right of parent, and n has no child, then the first grandpa which is left of grandgrandma is the node

    while (current.m_Parent != null) {
      Node currentParent = current.m_Parent;
      if ( currentParent.m_Left != null /*REMEMBER: null check */ && currentParent.m_Left.m_Key == current.m_Key ) {
        return currentParent;
      }
      current = currentParent;
    }

    return null;
  }


  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    sb.append("{ ");

    Node current = m_Root;

    // Step 1 : go to left most node, it is the smallest
    while ( current != null && current.m_Left != null ) {
      current = current.m_Left;
    }

    // Step 2 : for each next node, print key out
    while ( current != null) {
      sb.append(current + " ");
      current = higherEntry( current );
    }

    sb.append ("}");
    return sb.toString();
  }

  private void swapValue(Node a, Node b ) {
    int tmpKey = a.m_Key;
    a.m_Key = b.m_Key;
    b.m_Key = tmpKey;
  }

  private static class Node {
    public int m_Key;
    public Node m_Left, m_Right, m_Parent;
    public int m_Level;

    public Node(int k, int level) {
      m_Key = k;
      m_Level = level;
    }

    @Override
    public String toString() { return ""+m_Level+"-"+m_Key; }
  }
}
