package jacoblo.algorithm.Sorting;

import jacoblo.dataStructure.Heap;

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
//		heap.add(10);
//		heap.add(1);heap.add(12);
//		heap.add(3);heap.add(14);heap.add(15);heap.add(16);
//		heap.add(7);heap.add(6);heap.add(19);heap.add(20);heap.add(21);heap.add(2);heap.add(23);heap.add(24);
//		heap.add(25);
		
//		heap.add(10);
//		heap.add(9);heap.add(8);
//		heap.add(7);heap.add(6);heap.add(5);heap.add(4);
//		heap.add(3);heap.add(2);heap.add(1);heap.add(0);heap.add(-1);heap.add(-2);heap.add(-3);heap.add(-4);
		
		for ( int i = 0 , j = 100 ; j > 0 ; i++,j--) {
		  heap.add(j);
		  
		}
		System.out.println(heap);
		System.out.println(heap.size());
		
		for (int i = 0 ; i < 90 ; i++) {
		  System.out.println(heap.poll());
		}
		
		System.out.println(heap);
    System.out.println(heap.size());
    
    for (int i = 0 ; i < 10 ; i++) {
      heap.add(i);
    }
    
    System.out.println(heap);
    System.out.println(heap.size());
	}
}
