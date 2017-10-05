package net.jacoblo.algorithm.Sorting;

import java.util.ArrayList;
import java.util.List;

import net.jacoblo.data.Point;

//Question : What is the shortest path to travel all the given (x,y) points, starting from (0, 0)? 
// It is travel salesmand problem, but just using greedy Dijkstra for now.
//Example : (5, 10), (1, 2), (1, -1), (3, 4)
//Return : (1, -1), (1, 2), (3, 4), (5, 10)

public class ShortestPath<T extends Point<K>, K extends Number> {
	public ArrayList<T> shortestPathGreedyQuickSort(List<T> locations) {
		QuickSort<Point<K>> qs = new QuickSort<Point<K>>();
		ArrayList<Point<K>> sorted = qs.quickSort(new ArrayList<Point<K>>(locations));
		
		return (ArrayList<T>) sorted;
	}
	
}
