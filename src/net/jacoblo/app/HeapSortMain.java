package net.jacoblo.app;

import net.jacoblo.data.Node;
import net.jacoblo.dataStructure.Heap;

public class HeapSortMain {
	public static void main(String[] args) {
//		Node<Integer> root = new Node<Integer>(null,10);
//		Node<Integer> l = new Node<>(null,3);
//		Node<Integer> ll = new Node<>(null,1);
//		Node<Integer> r = new Node<>(null,100);
//		root.setLeft(l);
//		l.setParent(root);
//		root.setRight(r);
//		r.setParent(root);
//		l.setLeft(ll);
//		ll.setParent(l);
//		System.out.println(root);
//		System.out.println(l);
//		System.out.println(r);
//		System.out.println(ll);
//		System.out.println(root);
		
		Heap<Integer> heap = new Heap<Integer>();
		heap.add(10);
		heap.add(1);heap.add(12);
		heap.add(3);heap.add(14);heap.add(15);heap.add(16);
		System.out.println(heap);
	}
}
