package net.jacoblo.app;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.PriorityQueue;

import net.jacoblo.data.ValuePoint;
import net.jacoblo.lib.HeapSort;

public class ShortestPathLowToHighMain<T extends Number,K extends Number> {
  public static void main(String[] args) {
    ShortestPathLowToHighMain<Integer,Integer> splhm = new ShortestPathLowToHighMain<>();
    ArrayList<ArrayList<Integer>> field = generateField();
    System.out.println(field);
    
    PriorityQueue<ValuePoint<Integer,Integer>> points = HeapSort.<Integer>pointToTravel(field);
    PriorityQueue<Integer> ii = new PriorityQueue<>();
    ii.add(1);ii.add(10);ii.add(13);ii.add(60);ii.add(2);
    for (Integer i : ii) {
      System.out.println(i+ " ");
    }
    
    
  }
  
  public static ArrayList<ArrayList<Integer>> generateField() {
    ArrayList<ArrayList<Integer>> field = new ArrayList<>();
    ArrayList<Integer> f0 = new ArrayList<>();
    f0.add(1);f0.add(1);f0.add(1);f0.add(0);f0.add(2);
    ArrayList<Integer> f1 = new ArrayList<>();
    f1.add(3);f1.add(1);f1.add(1);f1.add(1);f1.add(0);
    
    field.add(f0);
    field.add(f1);
    return field;
  }
  

  

}
