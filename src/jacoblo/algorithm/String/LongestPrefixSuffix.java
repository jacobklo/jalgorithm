package jacoblo.algorithm.String;

import java.util.LinkedList;
import java.util.Queue;

public class LongestPrefixSuffix {
	public static void main(String[] args) {
		String in = "yuywyuwyujyuywyy";
		String output = longestPrefixSuffix(in);
		System.out.println(output);
	}
	
	public static String longestPrefixSuffix(String inputString) {
		if (inputString == null || inputString.length() <= 1) return "";
		
		int currentRetryIndex = 1;
		
		Queue<Character> result = new LinkedList<>();
		
		int inputIndex = 0;
		
		for ( int i = currentRetryIndex ; i < inputString.length(); i++ ) {
			if (inputString.charAt(i) == inputString.charAt(inputIndex)) {
				result.add(inputString.charAt(i));
				inputIndex++;
			}
			else {
				result.clear();
				inputIndex = 0;
				currentRetryIndex++;
				i = currentRetryIndex - 1;
			}
		}
		
		String resultString = "";
		while(result.size() > 0) {
			resultString += result.poll();
		}
		
		return resultString;
	}
}
