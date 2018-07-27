package net.jacoblo.designPattern;

import java.util.ArrayList;
import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;

public class IteratorMain {
  public static void main(String[] args) {
    HashMap<IntKey, StringValue> map = new HashMap<>();
    map.put(new IntKey(1), new StringValue("1"));
    map.put(new IntKey(2), new StringValue("2"));
    map.put(new IntKey(3), new StringValue("3"));
    map.put(new IntKey(4), new StringValue("4"));
    map.put(new IntKey(5), new StringValue("5"));
    
    ArrayList<StringValue> arr = getElements(map.values(), null);
    System.out.println(toStringArrayList(arr));
  }
  
  
  
  public static <E> ArrayList<E> getElements(Collection<E> cols, Iterator<E> it ) {
    if ( cols == null || cols.size() <= 0 ) return new ArrayList<>();
    
    ArrayList<E> resultValues = new ArrayList<>();
    if ( it == null) {
      it = cols.iterator();
    }
    while ( it.hasNext() ) {
      resultValues.add(it.next());
    }
    
    return resultValues;
  }
  
  public static <V> String toStringArrayList(ArrayList<V> arr) {
    if ( arr == null || arr.size() <= 0 ) return "";
    
    // REMEMBER!
    StringBuffer sb = new StringBuffer();
    sb.append("[");
    for ( V v : arr) {
      sb.append(" " + v.toString() + ",");
    }
    sb.replace(sb.length()-1, sb.length(), " ]");
    
    return sb.toString();
  }
  private static class IntKey implements Comparable<IntKey>{
    public Integer key;
    public IntKey(int k ) { key = k; }
    @Override
    public String toString() { return Integer.toString(key); }
    @Override
    public int compareTo(IntKey o) {
      if ( o == null ) return Integer.MAX_VALUE;
      return o.key - key;
    }
  }
  
  private static class StringValue {
    public String value;
    public StringValue( String s ) { value = s; }
    @Override
    public String toString() { return value; }
  }
}
