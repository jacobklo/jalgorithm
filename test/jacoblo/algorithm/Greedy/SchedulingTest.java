package jacoblo.algorithm.Greedy;

import jacoblo.data.Job;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;

public class SchedulingTest {

  @Test
  void testSample() {
    SchedulingGreedy<Integer,Integer> sg = new SchedulingGreedy<>();
//    sg.addJob(newJob(10,1));
//    sg.addJob(newJob(1,10));

    for (int i = 0 ; i < 5 ; i++) {
      for (int j = 10; j > 5 ; j--) {
        sg.addJob(newJob(i,j));
      }
    }
    ArrayList<Job<Integer,Integer>> result = sg.schedule();
    System.out.println(result);
  }

  public static Job<Integer,Integer> newJob(int weight, int time) {
    return new Job<Integer,Integer>(weight, time);
  }
}
