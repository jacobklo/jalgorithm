package net.jacoblo.app;

import java.util.ArrayList;

import net.jacoblo.algorithm.SchedulingGreedy;
import net.jacoblo.data.Job;

public class SchedulingMain {
  public static void main(String[] args) {
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
