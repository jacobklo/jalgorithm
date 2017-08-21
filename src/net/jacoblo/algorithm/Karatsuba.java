package net.jacoblo.algorithm;

import java.math.BigInteger;

public class Karatsuba {
	public static void main(String[] args) {
		BigInteger a = new BigInteger("3141592653589793238462643383279502884197169399375105820974944592");
		BigInteger b = new BigInteger("2718281828459045235360287471352662497757247093699959574966967627");
		
		BigInteger c = new BigInteger("111111");
		BigInteger d = new BigInteger("111111");
		
		System.out.println(a.multiply(b));
		// System.out.println(multiply(c.toString(),d.toString()));
	}
	
	public static BigInteger multiply (String a, String b) {
		if (a.length() < 4 || b.length() < 4) {
			BigInteger aa  = new BigInteger(a);
			BigInteger bb  = new BigInteger(b);
			return aa.multiply(bb);
		}
		int bmx = a.length() /2;
		int bmy = b.length() /2;
		
		String x1string = a.substring(0, bmx);
		String x0string = a.substring(bmx, a.length());
		String y1string = b.substring(0, bmy);
		String y0string = b.substring(bmy, b.length());
		
		BigInteger x1  = new BigInteger(x1string);
		BigInteger x0  = new BigInteger(x0string);
		BigInteger y1  = new BigInteger(y1string);
		BigInteger y0  = new BigInteger(y0string);
		
		BigInteger z2 = multiply(x1string,y1string);
		BigInteger z0 = multiply(x0string,y0string);
		
		BigInteger x1x0 = x1.add(x0);
		BigInteger y1y0 = y1.add(y0);
		
		String x1x0String = x1x0.toString();
		String y1y0String = y1y0.toString();
		
		BigInteger z1 = multiply(x1x0String, y1y0String);
		z1 = z1.subtract(z2);
		z1 = z1.subtract(z0);
		
		
		BigInteger digits = new BigInteger(Integer.toString(bmx));
		BigInteger digits2 = new BigInteger(Integer.toString(bmx));
		
		digits = digits.multiply(digits);
		
		BigInteger result = z0;
		result = result.add(multiply(z2.toString(),digits.toString()));
		result = result.add(multiply(z1.toString(), digits2.toString()));
		
		return result;
	}
}
