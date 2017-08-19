// Jacob Lo
// Lisence : MIT
// Randomized QuickSort In-place algorithm, very basic

package net.jacoblo.lib;

import java.util.ArrayList;

public class QuickSort<T extends Comparable<T>> {
	public ArrayList<T> quickSort(ArrayList<T> elements) {
		return quickSort(new Tuple(elements), 0, elements.size()).elements;
	}

	public Tuple quickSort(Tuple tuple, int leftIndex, int rightIndex) {
		// leftIndex is start element of subArray, rightIndex is end element of
		// subArray, for recursive use.
		if (tuple == null || tuple.elements == null)
			return null;
		if (tuple.elements.size() < leftIndex || tuple.elements.size() < rightIndex || leftIndex < 0 || rightIndex < 0
		    || leftIndex > rightIndex) {
			System.out.println(
			    "ERROR : leftIndex or rightIndex out of bound : leftIndex : " + leftIndex + " rightIndex : " + rightIndex);
			return null;
		}
		// Base case
		if ((rightIndex - leftIndex) <= 1)
			return tuple;
		
		handleTupleBeforePartition(tuple, leftIndex, rightIndex);

		// Get random pivot
		int pivotIndex = leftIndex + (int) (Math.random() * (rightIndex - leftIndex));
		T pivot = tuple.elements.get(pivotIndex);
		swapElement(tuple.elements, leftIndex, pivotIndex);

		// partition
		int maxIndexLessThanPivot = leftIndex + 1;
		for (int i = leftIndex + 1; i < rightIndex; i++) {
			if (tuple.elements.get(i) != null && tuple.elements.get(i).compareTo(pivot) < 0) {
				swapElement(tuple.elements, maxIndexLessThanPivot, i);
				maxIndexLessThanPivot++;
			}
		}
		// put pivot back
		swapElement(tuple.elements, leftIndex, maxIndexLessThanPivot - 1);

		handleTupleAfterPartition(tuple, leftIndex, maxIndexLessThanPivot - 1, rightIndex);
		
		// Divide
		quickSort(tuple, leftIndex, maxIndexLessThanPivot - 1);
		quickSort(tuple, maxIndexLessThanPivot, rightIndex);

		handleTupleAfterDivide(tuple, leftIndex, maxIndexLessThanPivot - 1, rightIndex);
		
		return tuple;
	}

	private void swapElement(ArrayList<T> elements, int i, int j) {
		if (elements == null || elements.size() <= 0 || i >= elements.size() || j >= elements.size() || i < 0 || j < 0)
			return;
		T tmp = elements.get(i);
		elements.set(i, elements.get(j));
		elements.set(j, tmp);
	}
	
	protected void handleTupleBeforePartition(Tuple tuple, int leftIndex, int rightIndex) {
		// abstract method for sub class to extends features
	}
	
	protected void handleTupleAfterPartition(Tuple tuple, int leftIndex, int pivotIndex, int rightIndex) {
		// abstract method for sub class to extends features
	}
	
	protected void handleTupleAfterDivide(Tuple tuple, int leftIndex, int pivotIndex, int rightIndex) {
		// abstract method for sub class to extends features
	}

	protected class Tuple{
		public ArrayList<T> elements;
		
		public Tuple(ArrayList<T> e) {
			elements = e;
		}
	}
}
