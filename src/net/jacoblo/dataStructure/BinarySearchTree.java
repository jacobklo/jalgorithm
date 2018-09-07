package net.jacoblo.dataStructure;

public class BinarySearchTree {
  private Node m_Root;

  public BinarySearchTree() {}

  public Node remove(int key) {
    m_Root = remove(m_Root, key);
  }

  public Node remove(Node n, int key) {
    // Case 0 : n should not be null
    if ( n == null ) return null;

    // Case 1 : recursively call remove to let lower subtree handle. DON'T use contains(), definitely not efficient
    if (key < n.m_Key ) {
      n.m_Left = remove( n.m_Left, key );
      n.m_Left.m_Parent = n;
    }

    else if (key > n.m_Key ) {
      n.m_Right = remove( n.m_Right, key );
      n.m_Right.m_Parent = n;
    }

    else {
      // TODO
    }
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

  // TODO : use swap Node to swap all pointer, instead of just changing the key
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

  public static void main(String[] main) {
    BinarySearchTree bst = new BinarySearchTree();
    System.out.println(bst);
  }
}
