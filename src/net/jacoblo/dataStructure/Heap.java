package net.jacoblo.dataStructure;

import java.util.AbstractQueue;
import java.util.ArrayList;
import java.util.Iterator;

import net.jacoblo.data.Node;
import net.jacoblo.data.Tuple;

public class Heap<E extends Object & Comparable<E>> extends AbstractQueue<E> {
	private Node<E> root;
	private Tuple<Integer, Node<E>> nextMove;
	
	public Heap() {}
	
	@Override
	public boolean offer(E e) {
		if (e == null) { return false; }
		Node<E> newNode = new Node<>(null,e);
		
		// 1. add to the latest position, aka most non empty right bottom
		if (root == null) {
			root = newNode;
			nextMove = nextPositionToAdd(root,root);
		}
		else if (nextMove != null && nextMove.x == 1) {
			nextMove.y.setLeft(newNode);
			newNode.setParent(nextMove.y);
			nextMove = nextPositionToAdd(root, nextMove.y.getLeft());
		}
		else if (nextMove != null && nextMove.x == 2) {
			nextMove.y.setRight(newNode);
			newNode.setParent(nextMove.y);
			nextMove = nextPositionToAdd(root, nextMove.y.getRight());
		}
		
		// 2. verify if the new added node is not violating heap rules, aka parent node is always smaller than all child nodes
		Node<E> nodeNeedToSwap = newNode;
		while (nodeNeedToSwap.compareTo(nodeNeedToSwap.getParent()) < 0) {

			Node.<E>swap(nodeNeedToSwap, nodeNeedToSwap.getParent());
			nodeNeedToSwap = nodeNeedToSwap.getParent();
		}
		
		// 3. update all subsizes
		Node<E> nodeNeedToUpdate = newNode.getParent();
		while (nodeNeedToUpdate != null ) {
		  nodeNeedToUpdate.setSubSize(nodeNeedToUpdate.getSubSize()+1);
		  nodeNeedToUpdate = nodeNeedToUpdate.getParent();
		}
		
		return true;
		
	}

	@Override
	public E poll() {
		// find which child has smaller value, swap it. keep swapping until the end. return
	  if (root == null ) return null;
	  Node<E> nodeToSwap = root;
	  while(nodeToSwap.getLeft() != null || nodeToSwap.getRight() != null) {
	    if (nodeToSwap.getLeft() != null && nodeToSwap.getRight() != null) { 
	      if (nodeToSwap.getLeft().compareTo(nodeToSwap.getRight()) < 0){
	        Node.<E>swap(nodeToSwap, nodeToSwap.getLeft());
	        nodeToSwap = nodeToSwap.getLeft();
	      }
	      else {
	        Node.<E>swap(nodeToSwap, nodeToSwap.getRight());
          nodeToSwap = nodeToSwap.getRight();
	      }
	    }
	    else if (nodeToSwap.getLeft() != null && nodeToSwap.getRight() == null) {
	      Node.<E>swap(nodeToSwap, nodeToSwap.getLeft());
	      nodeToSwap = nodeToSwap.getLeft();
	    }
	    else if (nodeToSwap.getLeft() == null && nodeToSwap.getRight() != null) {
	      Node.<E>swap(nodeToSwap, nodeToSwap.getRight());
	      nodeToSwap = nodeToSwap.getRight();
	    }
	  }
	  // Last node, remove the root too
	  if (nodeToSwap.equals(root)) {
	    root = null;
	  }
	  // detach that node from the heap
	  Node<E> removingNodeParent = nodeToSwap.getParent();
	  if (removingNodeParent != null && nodeToSwap.equals(removingNodeParent.getLeft())) {
	    removingNodeParent.setLeft(null);
	  }
	  else if (removingNodeParent != null && nodeToSwap.equals(removingNodeParent.getRight())){
	    removingNodeParent.setRight(null);
	  }
	  // decrease all subsize
	  while (removingNodeParent != null) {
	    removingNodeParent.setSubSize(removingNodeParent.getSubSize()-1);
	    removingNodeParent = removingNodeParent.getParent();
	  }
	  
	  return nodeToSwap.getValue();
	}

	@Override
	public E peek() {
		return (root != null ? root.getValue() : null);
	}

	@Override
	public Iterator<E> iterator() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public int size() {
		return root.getSubSize();
	}
	
	@Override
	public String toString() {
		String result = "";
		ArrayList<Tuple<Integer/*Level*/,Node<E>>> list = new ArrayList<>();
		int currentLevel = 0;
		list.add(new Tuple<>(currentLevel,root));
		
		while(list.size() > 0) {
			Tuple<Integer,Node<E>> current = list.remove(0);
			if (current.x > currentLevel) {
				result += "\n";
				currentLevel = current.x;
			}
			
			result += current.y.toString() + " ";
			if (current.y.getLeft() != null) {
				list.add(new Tuple<>(currentLevel+1, current.y.getLeft()));
			}
			if (current.y.getRight() != null) {
				list.add(new Tuple<>(currentLevel+1, current.y.getRight()));
			}
		}
		return result;
	}
	
	/**
	 * nextPositionToAdd() calculate next position to add a node.
	 * @param currentLatestPosition
	 * @return a tuple. Integer identicate what child. 1 = left, 2 = right, -1 = not supported. Node is the parent of that position, as i cannot represent new position as it is null.
	 *  
	 */
	private Tuple<Integer, Node<E>> nextPositionToAdd(Node<E> root, Node<E> currentLatestPosition) {
		if (currentLatestPosition == null) return new Tuple<>(-1,null);
		// root, next is left child
		else if (currentLatestPosition.getParent() == null) {
			return new Tuple<>(1,currentLatestPosition);
		}
		else if (currentLatestPosition.getParent().getLeft() != null && currentLatestPosition.getParent().getRight() == null) {
			return new Tuple<>(2,currentLatestPosition.getParent());
		}
		else if (currentLatestPosition.getParent().getRight() != null){
		  boolean isRightMostNode = true;
		  Node<E> currentNode = currentLatestPosition.getParent();
		  while(isRightMostNode && !(currentNode.equals(root))) {
		    if (currentNode.getParent() != null && currentNode.equals(currentNode.getParent().getLeft())) {
		      isRightMostNode = false;
		    }
		    currentNode = currentNode.getParent();
		  }
		  
		  if (isRightMostNode) {
		    Node<E> mostLeft = root;
        while(mostLeft.getLeft() != null) {
          mostLeft = mostLeft.getLeft();
        }
        return new Tuple<>(1,mostLeft);
		  }
		  else {
		    Node<E> nextMostLeft = currentNode.getRight();
		    // base on heap, the grandparents child right side then left grandchild should not be null, but still check
		    while(nextMostLeft.getLeft() == null && nextMostLeft.getRight() != null) {
		      nextMostLeft = nextMostLeft.getRight();
		    }
		    
		    while(nextMostLeft.getLeft() != null) {
		      nextMostLeft = nextMostLeft.getLeft();
		    }
		    
		    return new Tuple<>(1,nextMostLeft);
		  }
		  
			
		}
		else {
			//SHOUDL not go here
			return new Tuple<>(-1,null);
		}
	}
}
