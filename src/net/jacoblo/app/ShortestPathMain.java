package net.jacoblo.app;

import java.util.ArrayList;

import net.jacoblo.data.Point;
import net.jacoblo.lib.ShortestPath;

public class ShortestPathMain {
	public static void main(String[] args) {
		ArrayList<ArrayList<Integer>> locations = generatePoints();
		ArrayList<Point<Integer>> points = convertToPoints(locations);
		
		ShortestPath<Point<Integer>,Integer> sp = new ShortestPath<Point<Integer>,Integer>();
		ArrayList<Point<Integer>> sorted = sp.shortestPathGreedyQuickSort(points);
		System.out.println(sorted);
		
		
	}
	
	public static ArrayList<Point<Integer>> convertToPoints(ArrayList<ArrayList<Integer>> locations) {
		ArrayList<Point<Integer>> result = new ArrayList<Point<Integer>>();
		for (int i = 0 ; i < locations.size() ; i++) {
			result.add(new Point<Integer>(locations.get(i).get(0), locations.get(i).get(1)));
		}
		return result;
	}
	
	public static ArrayList<ArrayList<Integer>> generatePoints() {
		ArrayList<ArrayList<Integer>> locations = new ArrayList<ArrayList<Integer>>();
		ArrayList<Integer> p1 = new ArrayList<Integer>();
		p1.add(5);
		p1.add(10);
		locations.add(p1);
		ArrayList<Integer> p2 = new ArrayList<Integer>();
		p2.add(1);
		p2.add(2);
		locations.add(p2);
		ArrayList<Integer> p3 = new ArrayList<Integer>();
		p3.add(1);
		p3.add(-1);
		locations.add(p3);
		ArrayList<Integer> p4 = new ArrayList<Integer>();
		p4.add(3);
		p4.add(4);
		locations.add(p4);
		return locations;
	}
}
