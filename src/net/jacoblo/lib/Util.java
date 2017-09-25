package net.jacoblo.lib;

public class Util {
	public static <T extends Number> T max(T... inputs) {
		double result = inputs[0].doubleValue();
		T current = inputs[0];
		for (T i : inputs) {
			if (result < i.doubleValue()) {
				result = i.doubleValue();
				current = i;
			}
		}
		return current;
	}
}
