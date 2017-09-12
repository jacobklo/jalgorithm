package net.jacoblo.algorithm;

import java.util.ArrayList;

import net.jacoblo.data.KnapsackItem;

public class Knapsack {
  public static double knapsack(ArrayList<KnapsackItem> items, int maxWeightAllow) {
    if (items == null) return 0;
    // Double array[items.size()][weight] = value to calculate
    ArrayList<ArrayList<Double>> calc = new ArrayList<>(items.size());
    
    // Initialize when zero item, there is no value
    for (int i = 0 ; i < items.size(); i++) {
      ArrayList<Double> array = new ArrayList<>();
      for (int j = 0; j < maxWeightAllow ; j++) {
        array.add((double) 0);
      }
      calc.add(array);
    }
    
    // Fun part, for each adding item, calculate Max value of { sub-optimal solution without new item, or sub-optimal solution with new item } if adding each item
    for ( int i = 1; i < items.size(); i++) {
      for (int j = 0 ; j < maxWeightAllow; j++) {
        double valueWithoutThisItem = calc.get(i-1).get(j);
        double valueWithThisItem = -1;
        if (j - items.get(i-1).getWeight() >= 0) {
          valueWithThisItem = items.get(i).getValue() + calc.get(i-1).get((int) (j - items.get(i-1).getWeight()));
        }
        calc.get(i).set(j, ( valueWithoutThisItem > valueWithThisItem ? valueWithoutThisItem : valueWithThisItem));
      }
    }
    
    return calc.get(items.size()-1).get(maxWeightAllow-1);
    
  }
}
