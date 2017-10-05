package net.jacoblo.algorithm.Sorting;

import java.util.ArrayList;
import java.util.InputMismatchException;

public class ClosetPair<T extends Comparable<T>> extends QuickSort<T>{
	public ArrayList<T> closetPair(ArrayList<T> elements) {
		return quickSort(elements);
	}
	
	@SuppressWarnings("unchecked")
	@Override
	public ArrayList<T> quickSort(ArrayList<T> elements) {
		Tuple tuple = quickSort(new ClosetPairTuple(new ArrayList<T>(), elements), 0, elements.size());
		if (!(tuple instanceof ClosetPair.ClosetPairTuple))	return tuple.elements;
		ClosetPairTuple cpTuple = (ClosetPairTuple) tuple;
		System.out.println("Finish Pair : " + cpTuple.pair);
		return cpTuple.elements;
	}
	
	@Override
	@SuppressWarnings("unchecked")
	protected void handleTupleBeforePartition(Tuple tuple, int leftIndex, int rightIndex) {
		if (!(tuple instanceof ClosetPair.ClosetPairTuple))	return;
		ClosetPairTuple cpTuple = (ClosetPairTuple) tuple;
		if ((rightIndex - leftIndex) == 2) {
			if (cpTuple.pair == null) {
				cpTuple.pair = new ArrayList<T>();
			}else{
				cpTuple.pair.clear();
			}
			cpTuple.pair.add(cpTuple.elements.get(leftIndex));
			cpTuple.pair.add(cpTuple.elements.get(leftIndex+1));
		}
		System.out.println("Pair : "+ cpTuple.pair + " " + cpTuple.elements);
	}
	
	@Override
	@SuppressWarnings("unchecked")
	protected void handleTupleAfterDivide(Tuple tuple, int leftIndex, int pivotIndex, int rightIndex) {
		if (!(tuple instanceof ClosetPair.ClosetPairTuple))	return;
		ClosetPairTuple cpTuple = (ClosetPairTuple) tuple;
		
		int leftCompare = Integer.MAX_VALUE;
		if (leftIndex < pivotIndex) {
			leftCompare = cpTuple.elements.get(pivotIndex-1).compareTo(cpTuple.elements.get(pivotIndex));
		}
		int rightCompare = Integer.MAX_VALUE;
		if (pivotIndex > rightIndex) {
			rightCompare = cpTuple.elements.get(pivotIndex).compareTo(cpTuple.elements.get(pivotIndex+1));
		}
		int currentPairCompare = Integer.MAX_VALUE;
		if (cpTuple.pair != null && cpTuple.pair.size() == 2) {
			currentPairCompare = cpTuple.pair.get(0).compareTo(cpTuple.pair.get(1));
		}
		
		if (leftCompare < currentPairCompare && leftCompare < rightCompare) {
			if (cpTuple.pair == null) {
				cpTuple.pair = new ArrayList<T>();
			}else{
				cpTuple.pair.clear();
			}
			cpTuple.pair.add(cpTuple.elements.get(pivotIndex-1));
			cpTuple.pair.add(cpTuple.elements.get(pivotIndex));
		}
		else if (rightCompare < currentPairCompare && rightCompare < leftCompare) {
			if (cpTuple.pair == null) {
				cpTuple.pair = new ArrayList<T>();
			}else{
				cpTuple.pair.clear();
			}
			cpTuple.pair.add(cpTuple.elements.get(pivotIndex));
			cpTuple.pair.add(cpTuple.elements.get(pivotIndex+1));
		}
		
	}
	
	public class ClosetPairTuple extends Tuple {
		public ArrayList<T> pair;
		
		public ClosetPairTuple(ArrayList<T> p, ArrayList<T> elements){
			super(elements);
			
			setPair( p );
		}
		
		public void setPair(ArrayList<T> p){
			// check pair, only no pair or 1 pair
			if (p == null || (p.size() != 0 && p.size() != 2)) {
				throw new InputMismatchException("Pair size != 2");
			}
			pair = p;
		}
	}
}
