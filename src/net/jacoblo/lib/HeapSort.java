package net.jacoblo.lib;

import java.util.ArrayList;
import java.util.List;
import java.util.PriorityQueue;

import net.jacoblo.data.ValuePoint;

public class HeapSort {
  public static <K extends Number> PriorityQueue<ValuePoint<Integer,K>> pointToTravel(ArrayList<ArrayList<K>> field) {
    PriorityQueue<ValuePoint<Integer,K>> points = new PriorityQueue<>();
    if (field == null) return points;
    
    for (int i = 0 ; i < field.size(); i++) {
      List<K> row = field.get(i);
      for (int j = 0 ; j < row.size(); j++) {
        ValuePoint<Integer,K> p = new ValuePoint<Integer,K>((Integer)i,(Integer)j,row.get(j));
        points.add(p);
      }
    }
    
    return points;
  }
}
