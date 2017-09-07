package net.jacoblo.algorithm;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.PriorityQueue;

import net.jacoblo.data.Job;

public class SchedulingGreedy<W extends Number, T extends Number> {
  private PriorityQueue<Job<W,T>> jobs;
  
  public SchedulingGreedy() {
    JobComparator jobCom = new JobComparator();
    jobs = new PriorityQueue<>(jobCom);
  }
  
  public void addJob(Job<W,T> job) {
    jobs.add(job);
  }
  
  public ArrayList<Job<W,T>> schedule() {
    ArrayList<Job<W,T>> result = new ArrayList<>();
    while(jobs.size() > 0) {
      result.add(jobs.poll());
    }
    return result;
  }
  
  /**
   * return job priority base on:
   * weight / running time
   * 
   * If b is more important, b will has larger result than a
   */
  private class JobComparator implements Comparator<Job<W,T>> {

    @Override
    public int compare(Job<W, T> a, Job<W, T> b) {
      double av = a.getWeight().doubleValue() / a.getTime().doubleValue();
      double bv = b.getWeight().doubleValue() / b.getTime().doubleValue();
      return (int)(( bv - av) * 100000);
    }
    
  }
}
