package jacoblo.data;

public class Triple<X,Y,Z> {
  public X x;
  public Y y;
  public Z z;
  public Triple(X x, Y y,Z z) {
    this.x = x;
    this.y = y;
    this.z = z;
  }
  
  @Override
  public String toString() {
    return "T{ " + x + " , " + y + " , " + z + " } ";
  }
}