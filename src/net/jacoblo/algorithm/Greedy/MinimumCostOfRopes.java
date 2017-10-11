
/**
 * http://practice.geeksforgeeks.org/problems/minimum-cost-of-ropes/0
 * Medium
 * Connect n ropes with minimum cost
There are given n ropes of different lengths, we need to connect these ropes into one rope. The cost to connect two ropes is equal to sum of their lengths. We need to connect the ropes with minimum cost.

For example if we are given 4 ropes of lengths 4, 3, 2 and 6. We can connect the ropes in following ways.
1) First connect ropes of lengths 2 and 3. Now we have three ropes of lengths 4, 6 and 5.
2) Now connect ropes of lengths 4 and 5. Now we have two ropes of lengths 6 and 9.
3) Finally connect the two ropes and all ropes have connected.

Total cost for connecting all ropes is 5 + 9 + 15 = 29. This is the optimized cost for connecting ropes. Other ways of connecting ropes would always have same or more cost. For example, if we connect 4 and 6 first (we get three strings of 3, 2 and 10), then connect 10 and 3 (we get two strings of 13 and 2). Finally we connect 13 and 2. Total cost in this way is 10 + 13 + 15 = 38.


 */
package net.jacoblo.algorithm.Greedy;

import java.util.PriorityQueue;

public class MinimumCostOfRopes {
	public static void main(String[] args) {
		int[] arr = {468, 335, 1, 170, 225, 479, 359, 463, 465, 206,
				146, 282, 328, 462, 492, 496, 443, 328, 437, 392,
				105, 403, 154, 293, 383, 422, 217, 219, 396, 448,
				227, 272, 39, 370, 413, 168, 300, 36, 395, 204, 312, 323};
		int result = minimumCostOfRopes(arr);
		System.out.println(result);
	}
	
	public static int minimumCostOfRopes(int[] arr ) {
		if (arr == null || arr.length <= 0) return 0;
		
		PriorityQueue<Integer> pq = new PriorityQueue<>();
		for (int el : arr) {
			pq.add(el);
		}
		int sum = 0;
		
		for (int i = 0 ; i < arr.length - 1; i++ ) {
			int r1 = pq.poll();
			int r2 = pq.poll();
			int newRope = r1 + r2;
			sum += newRope;
			pq.add(newRope);
		}
		
		return sum;
	}
}
