package net.jacoblo.lib;

import java.util.ArrayList;

public class Util {
	public static <T extends Number> T max(T... inputs) {
		double result = inputs[0].doubleValue();
		T current = inputs[0];
		for (T i : inputs) {
			if (result < i.doubleValue()) {
				result = i.doubleValue();
				current = i;
			}
		}
		return current;
	}
	
	public static <T extends Number> T min(T... inputs) {
    double result = inputs[0].doubleValue();
    T current = inputs[0];
    for (T i : inputs) {
      if (result > i.doubleValue()) {
        result = i.doubleValue();
        current = i;
      }
    }
    return current;
  }
	
	public static <T> String printResult(ArrayList<ArrayList<T>> result) {
    if (result == null || result.size() == 0) return "Empty";
    
    String s = "";
    for (ArrayList<T> each : result) {
      s += "(";
      for (int i = 0 ; i < each.size(); i++) {
        s += each.get(i);
        if (i + 1 < each.size()) {
          s += " ";
        }
      }
      s += ")";
    }
    return s;
  }
}
