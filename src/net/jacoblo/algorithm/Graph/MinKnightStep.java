
/**
 * http://practice.geeksforgeeks.org/problems/knight-walk/0
 * Medium
 * Given a chess board of order NxM and source points (s1,s2) and destination points (d1,d2), Your task to find min number of moves required by the Knight to go to the destination cell. 

Input:
The first line of input contains an integer T denoting the no of test cases. Then T test cases follow. Each test case contains two lines. The first line of each test case contains two space separated integers N and M. Then in the next line are four space separated values s1, s2 and d1, d2.

Output:
For each test case in a new line print the min no of moves required by the knight to go to the destination from the source. If no such move is possible print -1.

Constraints:
1<=T<=100
1<=N,M<=25

Example:
Input:
2
4 7
2 6 2 4
7 13
2 8 3 4
Output:
2
3
 */
package net.jacoblo.algorithm.Graph;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.Queue;

public class MinKnightStep {
  public static void main(String[] args) {
  	int n = 7, m = 13;
  	int from[] = { 2, 8 };
  	int to[] = { 3, 4 };
  	
  	
  	
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
  			return visited[current.get(0)-1][current.get(1)-1]-1;
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
