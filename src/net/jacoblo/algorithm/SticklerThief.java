package net.jacoblo.algorithm;

import net.jacoblo.lib.Util;

public class SticklerThief {
	public static void main(String[] args) {
		int[] test = {5, 5, 10, 100, 10, 5};
		int result = SticklerThiefDP(test);
		System.out.println(result);
	}
	
	public static int SticklerThiefDP(int[] houses) {
		if (houses == null || houses.length <= 0) return 0;
		
		int[] loots = new int[houses.length+1];
		loots[0] = 0;
		
		if (houses.length >= 1) {
			loots[1] = houses[0];
		}
		
		for (int i = 2 ; i <= houses.length ; i++) {
			loots[i] = Util.<Integer>max( loots[i-1], loots[i-2] + houses[i-1]);
		}
		
		return loots[houses.length];
	}
}
