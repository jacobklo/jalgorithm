package jacoblo.dataStructure;

import java.util.Arrays;
import java.util.stream.IntStream;
import java.util.stream.Stream;

// Same as BinarySearchTree, but Node class is without level and parent pointer
public class BinarySearchTreeSimplify {
  public Node m_Root;

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

  // O ( n log n ) implementation, need to generate an array
  // REMEMBER : IntStream
  public Node higherEntry(Node n) {
    Node[] treeToArray = toArray(m_Root);
    int currentIndex = IntStream.range(0, treeToArray.length)
                             .filter(i -> n.equals(treeToArray[i]))
                             .findFirst()
                             .orElse(-1);
    // check if currentIndex is valid and not the last node.
    return ( currentIndex > 0 && currentIndex < treeToArray.length - 1 ? treeToArray[currentIndex+1] : null);
  }

  // REMEMBER : Arrays.stream, IntSteam.concat, Stream.toArray, Steam supplier
  public Node[] toArray(Node n) {
    if ( n == null ) return new Node[0];
    Stream<Node> left = Arrays.stream(toArray(n.m_Left));
    Stream<Node> right = Arrays.stream(toArray(n.m_Right));
    return Stream.concat(left, Stream.concat(Stream.of(n), right) ).toArray(Node[]::new);
  }

  public static class Node {
    public int m_Key;
    public Node m_Left, m_Right;

    public Node(int k) { m_Key = k; }

    @Override
    public boolean equals(Object o) { return ( o instanceof Node ? ((Node) o).m_Key == this.m_Key : false); }
  }

  // REMEMBER : In-order approach
  private int calcNodeAncestry(Node root, Node n, int currentLevel) {
    if ( root == null || n == null) return Integer.MIN_VALUE;
    if ( n.m_Key < root.m_Key ) return calcNodeAncestry(root.m_Left, n , currentLevel + 1);
    if ( n.m_Key > root.m_Key ) return calcNodeAncestry(root.m_Right, n , currentLevel + 1);
    return ( root.m_Key == n.m_Key ? currentLevel : Integer.MIN_VALUE);
  }

  @Override
  public String toString() {
    StringBuilder sb = new StringBuilder();
    Arrays.stream(toArray(m_Root)).forEach(n -> sb.append(""+calcNodeAncestry(m_Root, n, 0) + "-" + n.m_Key + " "));
    return sb.toString();
  }
}
