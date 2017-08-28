package net.jacoblo.dataStructure;

import java.util.AbstractQueue;
import java.util.ArrayList;
import java.util.Iterator;

import net.jacoblo.data.Node;
import net.jacoblo.data.Tuple;

public class Heap<E extends Object & Comparable<E>> extends AbstractQueue<E> {
	private Node<E> root;
	private int numOfItems;
	private Tuple<Integer, Node<E>> nextMove;
	
	public Heap() {
		numOfItems = 0;
	}
	

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
			if (nextMove.y.equals(nodeNeedToSwap.getParent())) {
				nextMove.y = nodeNeedToSwap;
			}
			// For root, need to renew the pointer to root
			if (root.equals(nodeNeedToSwap.getParent())) {
				root = nodeNeedToSwap;
			}
			Node.<E>swap(nodeNeedToSwap, nodeNeedToSwap.getParent());
		}
		
		numOfItems++;
		return true;
		
	}

	@Override
	public E poll() {
		// TODO Auto-generated method stub
		return null;
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
		return numOfItems;
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
			Node<E> grandParent = currentLatestPosition.getParent().getParent();
			if (grandParent == null || grandParent.getRight().equals(currentLatestPosition)) {
				Node<E> mostLeft = root;
				while(mostLeft.getLeft() != null) {
					mostLeft = mostLeft.getLeft();
				}
				return new Tuple<>(1,mostLeft);
			}
			else {
				return new Tuple<>(1,grandParent.getRight());
			}
		}
		else {
			//SHOUDL not go here
			return new Tuple<>(-1,null);
		}
	}
}
