package jacoblo.algorithm.Graph;

import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.List;

import static org.junit.jupiter.api.Assertions.assertFalse;

import static jacoblo.algorithm.Graph.PointInPolygon.calcPointInPolygon;
import static org.junit.jupiter.api.Assertions.assertTrue;

public class PointInPolygonTest {

  @Test
  void testOutside() {
    Point p = genCube();
    assertFalse( calcPointInPolygon(0, 0, p.vx, p.vy));
  }

  @Test
  void testOnEdge() {
    Point p = genCube();
    assertTrue( calcPointInPolygon(1, 0, p.vx, p.vy));
  }

  @Test
  void testOnCorner() {
    Point p = genCube();
    // TODO
    assertTrue( calcPointInPolygon(1, 1, p.vx, p.vy));
  }

  @Test
  void testInside() {
    Point p = genCube();
    assertTrue( calcPointInPolygon(1.5, 0, p.vx, p.vy));
  }


  private Point genCube() {
    ArrayList<Double> vx = new ArrayList<>();
    ArrayList<Double> vy = new ArrayList<>();
    Collections.addAll(vx,1.0,1.0,2.0,2.0);
    Collections.addAll(vy, 1.0,-1.0, -1.0, 1.0);
    return new Point(vx,vy);
  }

  private class Point {
    List<Double> vx;
    List<Double> vy;

    public Point(List<Double> verticesX, List<Double> verticesY) {
      vx = verticesX;
      vy = verticesY;
    }
  }

}
