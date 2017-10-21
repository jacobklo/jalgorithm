package net.jacoblo.algorithm.String;

public class StringFormationFromSubstring {
	public static void main(String[] args) {
		String[] in = { "aa", "nnnnsdfdnfdfdfn", "abcdabcd", "aaaaabaaaa", "abcabcabc" };
		boolean[] checks = { true, false, true, false, true };
		for (int i = 0 ; i < in.length ; i++ ) {
			System.out.println(canFormBySubstring(in[i]) == checks[i] ? "correct" : "INCORRECT");
		}
		
	}
	
	public static boolean canFormBySubstring(String input) {
		if ( input == null || input.length() <= 0 ) return false;
		
		for (int i = 2 ; input.length() / i >= 1 && i <= input.length() ; i++ ) {
			String current = input.substring(0, input.length() / i);
			
			boolean trueSoFar = true;
			if (input.length() % current.length() != 0) {
				trueSoFar = false;
				continue;
			}
			for (int j = 1 ; current.length()*(j+1) <= input.length() ; j++ ) {
				String subString = input.substring(current.length()*j, current.length()*(j+1));
				if (!current.equals(subString)) {
					trueSoFar = false;
					continue;
				}
			}
			if (trueSoFar) {
				return true;
			}
			
			
		}
		
		return false;
	}

}
