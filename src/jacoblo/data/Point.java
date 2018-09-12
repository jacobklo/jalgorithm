package jacoblo.data;
import java.util.Comparator;

public class Point<T extends Number> implements Comparable<Point<T>>{
 
 protected T x;
 protected T y;
 
 public Point(T x, T y) {
   setX(x);
   setY(y);
 }
 
 public T getX() { return x; }
 public T getY() { return y; }
 public void setX(T x) { this.x = x; }
 public void setY(T y) { this.y = y; }
 
 public double distanceSquare(double x1, double x2, double y1, double y2) {
   return (Math.pow((x1 - x2), 2) + Math.pow((y1 - y2), 2));
 }
 
 public double distanceSquare(Point<T> p1, Point<T> p2) {
   return distanceSquare(p1.x.doubleValue(), p2.x.doubleValue(), p1.y.doubleValue(), p2.y.doubleValue());
 }
 
 public double distance(Point<T> p1, Point<T> p2) {
   return Math.sqrt(distanceSquare(p1,p2));
 }
 
 @Override
 public String toString(){
   return "( " + x + " , " + y + " )";
 }
 
 @Override
 public boolean equals(Object o) {
   if (o != null && (o instanceof Point<?>)) {
     if (x.equals(((Point<?>)o).x) && y.equals(((Point<?>)o).y)) {
       return true;
     }
   }
   return false;
 }
 
 
 @Override
 public int compareTo(Point<T> o) {
	if (o == null) return Integer.MAX_VALUE;
	double thisPointDistance = distanceSquare(Double.MIN_VALUE, x.doubleValue(), Double.MIN_VALUE, y.doubleValue());
	double otherPointDistance = distanceSquare(Double.MIN_VALUE, o.x.doubleValue(), Double.MIN_VALUE, o.y.doubleValue());
	return (int)((thisPointDistance - otherPointDistance) * 10000);
 }
 
 public class PointComparator implements Comparator<Point<T>> {

	@Override
	public int compare(Point<T> p1, Point<T> p2) {
		return p1.compareTo(p2);
	}
	 
 }

}