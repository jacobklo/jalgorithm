package jacoblo.dataStructure;

public class BinarySearchTree {
  private Node m_Root;

  public BinarySearchTree() {}

  public void remove(int key) {
    m_Root = remove(m_Root, key);
  }

  public Node remove(Node n, int key) {
    // Case 0 : n should not be null
    if ( n == null ) return null;

    // Case 1 : recursively call remove to let left subtree handle. DON'T use contains(), definitely not efficient
    if (key < n.m_Key ) {
      n.m_Left = remove( n.m_Left, key );
      if ( n.m_Left != null ) {
        n.m_Left.m_Parent = n;
      }
    }
    // Case 2 : recursively call remove to let right subtree handle.
    else if (key > n.m_Key ) {
      n.m_Right = remove( n.m_Right, key );
      if ( n.m_Right != null ) {
        n.m_Right.m_Parent = n;
      }
    }
    // Case 3 : this is the key to remove
    else {
      // If only 1 child or 0 children, then just bring the child up and return
      if ( n.m_Left == null ) {
        if (n.m_Right != null ) {
          n.m_Right.m_Level = n.m_Level;
        }
        return n.m_Right;
      }
      else if ( n.m_Right == null ) {
        if (n.m_Left != null ) {
          n.m_Left.m_Level = n.m_Level;
        }
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

  // TODO : maybe use recursive?
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

  private static class Node {
    public int m_Key;
    public Node m_Left, m_Right, m_Parent;
    public int m_Level;

    public Node(int k, int level) {
      m_Key = k;
      m_Level = level;
    }

    // REMEMBER : In-order approach
    @Override
    public String toString() {
      return ( m_Left != null ? m_Left.toString() : "" ) + m_Level + "-" + m_Key + " " + ( m_Right != null ? m_Right.toString() : "" );
    }

    @Override
    public boolean equals(Object o) { return ( o instanceof Node ? ((Node) o).m_Key == this.m_Key : false); }
  }

  @Override
  public String toString() { return "{ " + (m_Root != null ? m_Root.toString() : "" ) + "}"; }
}
