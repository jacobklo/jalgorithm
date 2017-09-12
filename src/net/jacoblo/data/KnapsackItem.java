package net.jacoblo.data;

public class KnapsackItem {
  private double value;
  private int weight;
  private String name;
  
  public KnapsackItem(String n, double v, int w) {
    name = n;
    setValue(v);
    setWeight(w);
  }
  
  public String getName() { return name; }
  public double getValue() { return value; }
  public int getWeight() { return weight; }
  public void setValue(double v) { 
    value = v; 
  }
  public void setWeight( int w ) { 
    weight = w; 
  }
  
  @Override
  public boolean equals(Object o) {
    if (o != null && o instanceof KnapsackItem) {
      KnapsackItem k = (KnapsackItem)o ;
      return value == k.value && weight == k.weight;
    }
    return false;
  }
  
  @Override
  public String toString() {
    String result = "";
    result += ( name == null ? "" : name);
    result += "{ ";
    result += value;
    result += ", " ;
    result += weight;
    result += " }";
    return result;
  }
}
