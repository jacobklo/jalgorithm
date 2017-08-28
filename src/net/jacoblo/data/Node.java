package net.jacoblo.data;

public class Node<E extends Object & Comparable<E>> implements Comparable<Node<E>>{
	private String name;
	private E value;
	private Node<E> parent;
	private Node<E> left;
	private Node<E> right;
	private int hash;
	// subsize : including myself, how many of the nodes does this subtree has
	private int subSize;
	
	public Node(Node<E> p, E v) {
		setValue(v);
		setParent(p);
		hash = (int) (Math.random() * Integer.MAX_VALUE);
		subSize = 1;
	}
	
	public Node(Node<E> p, E v, Node<E> l, Node<E> r) {
		this(p,v);
		setLeft(l);
		setRight(r);
	}
	
	public Node(String n, Node<E> p, E v, Node<E> l, Node<E> r) {
		this(p,v,l,r);
		name = n;
	}
	
	public E getValue() { return value; }
	public Node<E> getLeft() { return left; }
	public Node<E> getRight() { return right; }
	public Node<E> getParent() { return parent; }
	public int getSubSize() { return subSize; }
	public void setSubSize(int s) { subSize = s; }
	
	public void setParent(Node<E> p) {
		parent = p;
	}
	public void setValue(E v) {
		if (v == null) throw new NullPointerException();
		value = v;
	}
	public void setLeft(Node<E> l) { 
		left = l; 
	}
	public void setRight(Node<E> r) { 
		right = r;
	}
	
	@Override
	public int compareTo(Node<E> o) {
		if (o == null) return Integer.MAX_VALUE;
		return value.compareTo(o.value);
	}

	@Override
	public int hashCode() {
		return hash;
	}
	
	@Override
	public boolean equals(Object o) {
		if (o != null && o instanceof Node<?>) {
			return ((Node<?>)o).value.equals(this.value);
		}
		return false;
	}
	
	@Override
	public String toString() {
		String result = "N";
		if (name != null && name.length() > 0) {
			result = name;
		}
		result += "(" + ( left != null ? "/" : " ") + value + ( right != null ? "\\" : " " ) + ") ";
		return result;
	}
	
	public static <E extends Object & Comparable<E>> void swap(Node<E> a, Node<E> b) {
		if (a == null || b == null) return;
		String aName = a.name;
		E aValue = a.value;
		int aHash = a.hash;
		
		a.name = b.name;
    a.value = b.value;
    a.hash = b.hash;
    
		b.name = aName;
		b.value = aValue;
		b.hash = aHash;
		
//		Node<E> aParent = a.getParent();
//		Node<E> aParentLeft = ( a.getParent() != null ? a.getParent().getLeft() : null);
//		Node<E> aParentRight = ( a.getParent() != null ? a.getParent().getRight() : null);
//		Node<E> aLeft = a.getLeft();
//		Node<E> aRight = a.getRight();
//		
//		Node<E> bParent = b.getParent();
//		Node<E> bParentLeft = ( b.getParent() != null ? b.getParent().getLeft() : null);
//		Node<E> bParentRight = ( b.getParent() != null ? b.getParent().getRight() : null);
//		Node<E> bLeft = b.getLeft();
//		Node<E> bRight = b.getRight();
//		
//		// if a and b are parent and child, need to handle differently 
//		if (b.getParent() != null && b.getParent().equals(a)) {
//			
//			a.setLeft(b.getLeft());
//			a.setRight(b.getRight());
//			a.setParent(b);
//			
//			if (aLeft != null && aLeft.equals(b)) {
//				b.setLeft(a);
//				b.setRight(aRight);
//			}
//			else {
//				b.setLeft(aLeft);
//				b.setRight(a);
//			}
//			b.setParent(aParent);
//			//need to set from original parent to new swapped child
//			if (aParent != null && a.equals(aParent.getLeft())) {
//				aParent.setLeft(b);
//			}else if ( aParent != null && a.equals(aParent.getRight())){
//				bParent.setRight(b);
//			}
//		}
//		else if (a.getParent() != null && a.getParent().equals(b)) {
//			
//			b.setLeft(a.getLeft());
//			b.setRight(a.getRight());
//			b.setParent(a);
//			
//			if (bLeft != null && bLeft.equals(a)) {
//				a.setLeft(b);
//				a.setRight(bRight);
//			}
//			else {
//				a.setLeft(bLeft);
//				a.setRight(b);
//			}
//			a.setParent(bParent);
//			//need to set from original parent to new swapped child
//			if (bParent != null && b.equals(bParent.getLeft())) {
//				bParent.setLeft(a);
//			}else if ( bParent != null && b.equals(bParent.getRight())){
//				bParent.setRight(a);
//			}
//		}
//		else {
//			if (aParent != null && a.equals(aParentLeft)) {
//				aParent.setLeft(b);
//			}
//			else if (aParent != null && a.equals(aParentRight)){
//				aParent.setRight(b);
//			}
//			b.setLeft(aLeft);
//			b.setRight(aRight);
//			b.setParent(aParent);
//			
//			if (bParent != null && b.equals(bParentLeft)) {
//				bParent.setLeft(a);
//			}
//			else if (bParent != null && b.equals(bParentRight)){
//				bParent.setRight(a);
//			}
//			a.setLeft(bLeft);
//			a.setRight(bRight);
//			a.setParent(bParent);
//			
//		}
		
	}
}
