package net.jacoblo.algorithm;

import java.util.ArrayList;

public class Prime {
	public static void main(String[] args) {
		ArrayList<Integer> primes = new ArrayList<>();
		primes.add(1);
		while (primes.get(primes.size() - 1) < 100) {
			primes.add(nextPrime(primes.get(primes.size() - 1)));
		}
		System.out.println(primes);
	}
	
  public static boolean isPrime(int number) {
  	for (int factor = 2 ; factor < number; factor++) {
  		if (number % factor == 0) {
  			return false;
  		}
  	}
  	return true;
  }
  
  public static int nextPrime(int current) {
  	int newCurrent = current + 1;
  	while(!isPrime(newCurrent)) {
  		newCurrent += 1;
  	}
  	return newCurrent;
  }
}
