package net.jacoblo.algorithm.DynamicProgramming;

import java.util.ArrayList;

import net.jacoblo.data.KnapsackItem;

public class Knapsack {
  
  public static ArrayList<KnapsackItem> knapsack(ArrayList<KnapsackItem> items, int maxWeightAllow) {
    if (items == null) return new ArrayList<>();
    // Double array[items.size()][weight] = value to calculate
    double[][] calc = new double[items.size()+1][maxWeightAllow+1]; // need space for 0 item and 0 weight
    // Fun part, for each adding item, calculate Max value of { sub-optimal solution without new item, or sub-optimal solution with new item } if adding each item
    for (int i = 1 ; i <= items.size(); i++) {
      KnapsackItem currentItem = items.get(i-1); // first item is in 0 position
      for ( int j = 0 ; j <= maxWeightAllow ; j++) {
        // valueWithout = valueIsOptimalWithoutCurrentItem
        double valueWithout = calc[i-1][j];
        // valueWith = valueIsOptimalWitCurrentItem
        double valueWith = -1;
        if (j-currentItem.getWeight() >= 0) {
          valueWith = calc[i-1][j-currentItem.getWeight()] + currentItem.getValue();
        }
        
        // calculate max
        if (valueWithout > valueWith) {
          calc[i][j] = valueWithout;
        }
        else {
          calc[i][j] = valueWith;
        }
      }
    }
    System.out.println(doubleArrayToString(calc));
    
    // Now, we need to backward pass recalculate each item, to see if it is included
    ArrayList<KnapsackItem> result = new ArrayList<>();
    int currentWeightTracker = maxWeightAllow;
    
    for (int i = items.size() ; i > 0 && currentWeightTracker > 0; i--) {
      KnapsackItem currentItem = items.get(i-1);
      CURRENTITEM:
      for (int j = currentWeightTracker ; j >= 0 ; j--) {
        // It means that the total weight is the same with or with this item, so this item is not included
        if (calc[i][j] == calc[i-1][j]) {
          break CURRENTITEM;
        }
        // else it means this item is included
        else {
          result.add(currentItem);
          currentWeightTracker -= currentItem.getWeight();
          break CURRENTITEM;
        }
        
      }
    }
    
    return result;
    
  }
  
  public static String doubleArrayToString(double[][] array) {
    if (array == null) return "";
    String result = "[\n";
    for (int i = 0 ; i < array.length ; i++) {
      result += "[";
      for (int j = 0 ; j < array[i].length ; j++) {
        result += array[i][j] + ", ";
      }
      result += "]\n";
    }
    result += "]";
    return result;
  }
}
