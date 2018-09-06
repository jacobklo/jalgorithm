package net.jacoblo.designPattern;

import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.Comparator;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Map.Entry;

public class IteratorMain {
  public static void main(String[] args) {
    HashMap<IntKey, StringValue> map = new HashMap<>();
    map.put(new IntKey(1), new StringValue("1"));
    map.put(new IntKey(2), new StringValue("2"));
    map.put(new IntKey(3), new StringValue("3"));
    map.put(new IntKey(4), new StringValue("4"));
    map.put(new IntKey(5), new StringValue("5"));
    
    //Default Iterator from HashMap Values
    ArrayList<StringValue> arr = getElements(map.values(), null);
    System.out.println(toStringArrayList(arr));
    
    // Use my MapIterator, with smallest key first sorted
    ArrayList<Map.Entry<IntKey, StringValue>> arr2 = getElements( 
        map.entrySet()
        , new MapIterator<IntKey, StringValue>( 
            map
            , new Comparator<Map.Entry<IntKey, StringValue>>() {

              @Override
              public int compare(Entry<IntKey, StringValue> o1, Entry<IntKey, StringValue> o2) {
                return o1.getKey().compareTo( o2.getKey() );
              }
          
        }));
    System.out.println(toStringArrayList(arr2));
    
    // Use my MapIterator, with BIGgest key first sorted
    ArrayList<Map.Entry<IntKey, StringValue>> arr3 = getElements( 
        map.entrySet()
        , new MapIterator<IntKey, StringValue>( 
            map
            , new Comparator<Map.Entry<IntKey, StringValue>>() {

              @Override
              public int compare(Entry<IntKey, StringValue> o1, Entry<IntKey, StringValue> o2) {
                return o2.getKey().compareTo( o1.getKey() );
              }
          
        }));
    System.out.println(toStringArrayList(arr3));
    
    // Use my MapIterator, with smallest VALUE first sorted
    ArrayList<Map.Entry<IntKey, StringValue>> arr4 = getElements( 
        map.entrySet()
        , new MapIterator<IntKey, StringValue>( 
            map
            , new Comparator<Map.Entry<IntKey, StringValue>>() {

              @Override
              public int compare(Entry<IntKey, StringValue> o1, Entry<IntKey, StringValue> o2) {
                return o1.getValue().compareTo( o2.getValue() );
              }
          
        }));
    System.out.println(toStringArrayList(arr4));
    
    
    MapIterator<IntKey, StringValue> tryRemoveItr = new MapIterator<IntKey, StringValue>( 
        map
        , new Comparator<Map.Entry<IntKey, StringValue>>() {

          @Override
          public int compare(Entry<IntKey, StringValue> o1, Entry<IntKey, StringValue> o2) {
            return o1.getKey().compareTo( o2.getKey() );
          }
      
    });
    
    while(tryRemoveItr.hasNext()) {
      Map.Entry<IntKey, StringValue> curEntry = tryRemoveItr.next();
      if (curEntry.getKey().equals(new IntKey(3))) {
        tryRemoveItr.remove();
      }
    }
    // Try remove 1 element
    ArrayList<Map.Entry<IntKey, StringValue>> tryRemoveArr = getElements( 
        map.entrySet()
        , new MapIterator<IntKey, StringValue>( 
            map
            , new Comparator<Map.Entry<IntKey, StringValue>>() {

              @Override
              public int compare(Entry<IntKey, StringValue> o1, Entry<IntKey, StringValue> o2) {
                return o1.getValue().compareTo( o2.getValue() );
              }
          
        }));
    System.out.println("Remove : " + toStringArrayList(tryRemoveArr));
    
  }
  
  /// REMEMBER!!!
  public static class MapIterator<K, V> implements Iterator<Map.Entry<K, V>> {

    private Map<K,V> m_Map;
    private ArrayList<Map.Entry<K, V>> m_List;
    private int m_Index;
    
    public MapIterator(Map<K,V> map, Comparator<Map.Entry<K, V>> comparator) {
      m_Map = map;
      m_List = new ArrayList<>(m_Map.entrySet());
      /// REMEMBER!!!
      Collections.sort(m_List, comparator);
    }
    @Override
    public boolean hasNext() {
      return m_Index < m_List.size();
    }
    
    @Override
    public Map.Entry<K, V> next() {
      return m_List.get(m_Index++);
    }
    
    @Override
    public void remove() {
      Map.Entry<K, V> currentEntry = m_List.get(m_Index-1); // next() added 1
      m_List.remove(m_Index-1);
      m_Map.remove(currentEntry.getKey());
    }
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
    
    /// REMEMBER!
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
      if (o == null) return Integer.MAX_VALUE;
      return key - o.key;
    }
    @Override
    public boolean equals(Object o) {
      if ( o == null || !(o instanceof IntKey)) return false;
      IntKey castO = (IntKey) o;
      return key.equals(castO.key);
    }
  }
  
  private static class StringValue implements Comparable<StringValue>{
    public String value;
    public StringValue( String s ) { value = s; }
    @Override
    public String toString() { return value; }
    @Override
    public int compareTo(StringValue o) {
      if (o == null) return Integer.MAX_VALUE;
      return (int) (Double.parseDouble(value) - Double.parseDouble(o.value));
    }
  }
}
