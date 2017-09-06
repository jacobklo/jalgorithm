package net.jacoblo.app;

import net.jacoblo.dataStructure.Hashtable;

public class HashtableMain {
	public static void main(String[] args) {
		Hashtable<Integer,Integer> hashs = new Hashtable<>();
//		hashs.put(1, 1);
//		hashs.put(3, 3);
//		hashs.put(6, 6);
//		hashs.put(17, 17);
//		hashs.put(18, 18);
//		hashs.remove(6);
		for (int i = 0 , j = 0; i < 10 ; i++, j=j+10) {
			hashs.put(j,j);
		}
		System.out.println(hashs);
	}
}
