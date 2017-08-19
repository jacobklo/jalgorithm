// Jacob Lo
// Lisence : MIT
// Randomized QuickSort In-place algorithm, very basic

package net.jacoblo.lib;

import java.util.ArrayList;

public class QuickSort<T extends Comparable<T>> {
	public ArrayList<T> quickSort(ArrayList<T> elements) {
		return quickSort(elements, 0, elements.size());
	}

	public ArrayList<T> quickSort(ArrayList<T> elements, int leftIndex, int rightIndex) {
		// leftIndex is start element of subArray, rightIndex is end element of
		// subArray, for recursive use.
		if (elements == null)
			return null;
		if (elements.size() < leftIndex || elements.size() < rightIndex || leftIndex < 0 || rightIndex < 0
		    || leftIndex > rightIndex) {
			System.out.println(
			    "ERROR : leftIndex or rightIndex out of bound : leftIndex : " + leftIndex + " rightIndex : " + rightIndex);
			return null;
		}
		// Base case
		if ((rightIndex - leftIndex) <= 1)
			return elements;

		// Get random pivot
		int pivotIndex = leftIndex + (int) (Math.random() * (rightIndex - leftIndex));
		T pivot = elements.get(pivotIndex);
		swapElement(elements, leftIndex, pivotIndex);

		// partition
		int maxIndexLessThanPivot = leftIndex + 1;
		for (int i = leftIndex + 1; i < rightIndex; i++) {
			if (elements.get(i) != null && elements.get(i).compareTo(pivot) < 0) {
				swapElement(elements, maxIndexLessThanPivot, i);
				maxIndexLessThanPivot++;
			}
		}
		// put pivot back
		swapElement(elements, leftIndex, maxIndexLessThanPivot - 1);

		// Divide
		quickSort(elements, leftIndex, maxIndexLessThanPivot - 1);
		quickSort(elements, maxIndexLessThanPivot, rightIndex);

		return elements;
	}

	private void swapElement(ArrayList<T> elements, int i, int j) {
		if (elements == null || elements.size() <= 0 || i >= elements.size() || j >= elements.size() || i < 0 || j < 0)
			return;
		T tmp = elements.get(i);
		elements.set(i, elements.get(j));
		elements.set(j, tmp);
	}

}
