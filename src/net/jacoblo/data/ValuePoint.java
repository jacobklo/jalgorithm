package net.jacoblo.data;

import java.util.Comparator;

public class ValuePoint<T extends Number,K extends Number> extends Point<T> {
  public K value;
  
  
  public ValuePoint(T x, T y, K v) {
    super(x, y);
    value = v;
  }
  
  @Override
  public String toString (){
    return "("+x+","+y+")-"+value+"- ";
  }
  
  public class ValuePointComparator<T extends Number, K extends Number> implements Comparator<ValuePoint<T,K>> {

    @Override
    public int compare(ValuePoint<T, K> o1, ValuePoint<T, K> o2) {
       if (o1 == null || o1.value.doubleValue() < o2.value.doubleValue()) {
         return Integer.MIN_VALUE;
       }else if (o2 == null || o1.value.doubleValue() > o2.value.doubleValue()) {
         return Integer.MAX_VALUE;
       }else {
         return o1.compareTo(o2);
       }
    }
  }
}

