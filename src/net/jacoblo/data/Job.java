package net.jacoblo.data;

public class Job<W extends Number,T extends Number> {
  private W weight;
  private T runningTime;
  
  public Job(W w, T t) {
    setWeight(w);
    setTime(t);
  }
  
  public W getWeight() { return weight; }
  public T getTime() { return runningTime; }
  public void setWeight(W w) { weight = w; }
  public void setTime(T t) { runningTime = t; }
  
  @Override
  public boolean equals(Object o) {
    if (o != null && o instanceof Job<?,?> ) {
      Job<?,?> j = (Job<?,?>) o;
      return weight.equals(j.getWeight()) && runningTime.equals(j.getTime());
    }
    return false;
  }
  
  @Override
  public String toString() {
    String result = "{ ";
    if (weight != null) {
      result += weight.toString();
    }
    result += ", ";
    if (runningTime != null) {
      result += runningTime.toString();
    }
    result += " }";
    return result;
  }
}
