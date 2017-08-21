package net.jacoblo.algorithm;

import java.math.BigInteger;

public class Karatsuba {
	public static void main(String[] args) {
		BigInteger a = new BigInteger("3141592653589793238462643383279502884197169399375105820974944592");
		BigInteger b = new BigInteger("2718281828459045235360287471352662497757247093699959574966967627");
		
		BigInteger c = new BigInteger("123456123312345");
		BigInteger d = new BigInteger("678900123312345");
		
		System.out.println(c.multiply(b));
		System.out.println(multiply(c.toString(),b.toString()));
	}
	
	public static BigInteger multiply(BigInteger a, BigInteger b) {
	  return multiply(a.toString(), b.toString());
	}
	
	public static BigInteger multiply (String a, String b) {
		if (a.length() < 4 || b.length() < 4) {
			BigInteger aa  = new BigInteger(a);
			BigInteger bb  = new BigInteger(b);
			return aa.multiply(bb);
		}
		
		String x1string;
		String x0string;
		String y1string;
		String y0string;
		// Divide 2 integer based on smallest number
		if (a.length() < b.length()) {
		  x1string = a.substring(0, a.length() /2);
		  x0string = a.substring(a.length() /2, a.length());
		  y1string = b.substring(0, b.length() - x0string.length());
		  y0string = b.substring(b.length() - x0string.length(), b.length());
		}
		else {
		  y1string = b.substring(0, b.length() /2);
      y0string = b.substring(b.length() /2 , b.length());
		  x1string = a.substring(0, a.length() - y0string.length());
      x0string = a.substring(a.length()  - y0string.length(), a.length());
		}

		BigInteger x1  = new BigInteger(x1string);
		BigInteger x0  = new BigInteger(x0string);
		BigInteger y1  = new BigInteger(y1string);
		BigInteger y0  = new BigInteger(y0string);
		
		// Calculate z2, z1, z0
		BigInteger z2 = multiply(x1,y1);
		BigInteger z0 = multiply(x0,y0);
		
		BigInteger x1x0 = x1.add(x0);
		BigInteger y1y0 = y1.add(y0);
		
		BigInteger z1 = multiply(x1x0, y1y0);
		z1 = z1.subtract(z2);
		z1 = z1.subtract(z0);
		
		// calculate bases
		BigInteger bm = new BigInteger(calcBase(x0string.length()));
		BigInteger bmSquare = new BigInteger(calcBase(x0string.length()*2));
		
//		String print = "[ a : " + a + " b : " + b + " ] x1string : " + x1string + " x0string : " + 
//		    x0string + " y1string : " + y1string + " y0string : " + y0string +
//		    "[ z2 : " + z2 + " z0 : " + z0 + " z1 : " + z1 + "] bm : " + bm + " bmSquare : " + bmSquare;
//    System.out.println(print);
//    
    BigInteger zero = new BigInteger("0");
    if (z1.equals(zero) && z0.equals(zero)) {
      return new BigInteger(shiftDigits(z2.toString(),bmSquare.toString().length()-1));
    }
    
		BigInteger result = z0;
		result = result.add(multiply(z2,bmSquare));
		result = result.add(multiply(z1,bm));
		
		return result;
	}

	public static String shiftDigits(String a, int digits) {
	  String result = a.toString();
	  for (int i = 0 ; i < digits ; i++) {
	    result += "0";
	  }
	  return result;
	}
	
	public static String calcBase(int digits) {
	  return shiftDigits("1",digits);
	}
}
