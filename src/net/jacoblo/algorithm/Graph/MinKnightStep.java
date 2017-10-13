package net.jacoblo.algorithm.Graph;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

public class MinKnightStep {
  public static void main(String[] args) {
  	int n = 4, m = 7;
  	int from[] = { 2, 6 };
  	int to[] = { 2, 4 };
  	
  	
  	
  	int result = minKnightStep( m, n, from, to);
  	System.out.println(result);
  }
  
  public static int minKnightStep( int m, int n, int[] from, int[] to) {
  	if (  from == null || to == null ) return -1;
  	
  	if ( from[0] < 1 || from[0] > n || to[0] < 1 || to[0] > n ||  from[1] < 1 || from[1] > m || to[1] < 1 || to[1] > m) return -1;
  	
  	int[][] moves = { 
  			{ -2, -1 },
  			{ -2, 1 },
  			{ -1, -2 },
  			{ 1, -2 },
  			{ -1, 2 },
  			{ 1, 2 },
  			{ 2, -1 },
  			{ 2, 1 } };
  	
  	Queue<ArrayList<Integer>> q = new LinkedList<>();
  	ArrayList<Integer> fromArrayList = new ArrayList<>();
  	fromArrayList.add(from[0]);
  	fromArrayList.add(from[1]);
  	
  	q.add(fromArrayList);
  	
  	int[][] visited = new int[n][m];
  	
  	visited[from[0]-1][from[1]-1]=1;
  	
  	while(q.size() > 0) {
  		ArrayList<Integer> current = q.poll();
  		if (current.get(0) == to[0] && current.get(1) == to[1]) {
  			return visited[current.get(0)-1][current.get(1)-1];
  		}
  		
  		for (int[] move : moves) {
    		ArrayList<Integer> newMove = new ArrayList<>();
    		newMove.add( move[0] + current.get(0) );
    		newMove.add( move[1] + current.get(1) );
    		if (newMove.get(0) < 1 || newMove.get(0) > n || newMove.get(1) < 1 || newMove.get(1) > m || visited[newMove.get(0)-1][newMove.get(1)-1] > 0) {
    			continue;
    		}
    		visited[newMove.get(0)-1][newMove.get(1)-1] = visited[current.get(0)-1][current.get(1)-1] + 1;
    		q.add(newMove);
    	}
  		
  		
  	}
  	
  	return -1;
  }
}
