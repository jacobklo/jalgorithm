
/**
 * http://practice.geeksforgeeks.org/problems/number-to-words/0
 * Medium
 * Given number into words. For example, if “1234” is given as input, output should be “one thousand two hundred and thirty four”

Input:

The first line of input contains an integer T denoting the number of test cases.
The first line of each test case is N.

Output:

Print the number into words (in small letter).

Constraints:

1 ≤ T ≤ 100
1 ≤ N ≤ 9999

Example:

Input:
2
2
142

Output:
two
one hundred and forty two
 */
package jacoblo.algorithm;

public class NumberToWords {
  public static void main(String[] main) {
    int number = 300;
    String result = numberToWords( number);
    System.out.println(result);
  }
  
  public enum ScalesOfNumbers {
    HUNDRED("hundred", 3),
    THOUSAND("thousand", 4),
    MILLION("million", 7),
    BILLION("billion", 10),
    TRILLION("trillion", 13),
    QUADRILLION("quadrillion", 16);
    
    
    public final String name;
    public final int digit;
    
    private ScalesOfNumbers(String n, int d) {
      this.name = n;
      this.digit = d;
    }
    
    public static ScalesOfNumbers getValue(int digit) {
    	ScalesOfNumbers[] s = ScalesOfNumbers.values();
    	for (int i = 0 ; i < s.length ; i++) {
    		if (s[i].digit == digit) {
    			return s[i];
    		}
    	}
			return null;
    }
  }
  
  public enum NumberName {
  	NONE(""),
    ONE("one"),
    TWO("two"),
    THREE("three"),
    FOUR("four"),
    FIVE("five"),
    SIX("six"),
    SEVEN("seven"),
    EIGHT("eight"),
    NINE("nine");
    
    public final String name;
    
    private NumberName(String n) {
      this.name= n;
    }
    
    public static NumberName getValue(int val) {
    	if (val < 1 || val > 9) return NONE;
    	return NumberName.values()[val];
    }
  }
  
  public enum TenthName {
    N0(""),
    N1(""),
    TWENTY("twenty"),
    THIRTY("thirty"),
    FORTY("forty"),
    FIFTY("fifty"),
    SIXTY("sixty"),
    SEVENTY("seventy"),
    EIGHTY("eighty"),
    NINETY("ninety");
    
    public final String name;
    
    private TenthName(String n) {
      this.name= n;
    }
  }
  
  public enum TeenName {
  	NONE(""),
  	TEN("ten"),
    ELEVEN("eleven"),
    TWELVE("twelve"),
    THIRTEEN("thirteen"),
    FORTEEN("forteen"),
    FIFTEEN("fifteen"),
    SIXTEEN("sixteen"),
    SEVENTEEN("seventeen"),
    EIGHTEEN("eighteen"),
    NINETEEN("nineteen");
    
    public final String name;
    
    private TeenName(String n) {
      this.name= n;
    }
    
    public static TeenName getValue(int v) {
      if (v < 10 || v > 19) return NONE;
      return TeenName.values()[v-9];
    }
  }
  
  public static String numberToWords(int number) {
    if ( number < 0 ) return "";
    String numberString = Integer.toString(number);
    
    String[] ss = separateString(numberString);

    String result = "";
    for (int i = ss.length - 1; i >= 0 ; i-- ) {
    	if (result.length() > 0) {
    		result += " ";
    	}
    	result += numberToWordsHundreds(ss[i], i != 0);
    	if (i > 0) {
    		result += " " + ScalesOfNumbers.getValue(i*3+1).name;
    	}
    }
    
    return result;
  }
  
  public static String numberToWordsHundreds(String numberString, boolean noAnd) {
    if (numberString == null || numberString.length() <= 0 || numberString.length() > 3) return "";
  	
    String hundredString = "", tenthString = "", singleString = "";
    
    if (numberString.length() >= 3 && numberString.charAt(numberString.length()-3) != '0') {
    	hundredString += NumberName.getValue(Character.getNumericValue(numberString.charAt(numberString.length()-3))).name;
    	hundredString += " " + ScalesOfNumbers.HUNDRED.name;
    }
    if (numberString.length() >= 2 && numberString.charAt(numberString.length()-2) == '1') {
    	int num = Integer.parseInt(numberString.substring(numberString.length() - 2, numberString.length() ));
    	tenthString += TeenName.getValue(num).name;
    }
    else {
    	if (numberString.length() >= 2 && numberString.charAt(numberString.length()-2) != '0') {
    		tenthString += TenthName.values()[Character.getNumericValue(numberString.charAt(numberString.length()-2))].name;
    	}
    	if (numberString.length() >= 1 && numberString.charAt(numberString.length() - 1) != '0') {
    		singleString += NumberName.getValue(Character.getNumericValue(numberString.charAt(numberString.length()-1))).name;
    	}
    }
    
    String result = "";
    result += hundredString;
    if (result.length() > 0 && !noAnd && ( tenthString.length() > 0 || singleString.length() > 0)) {
    	result += " and";
    }
    if (result.length() > 0 && tenthString.length() > 0) {
    	result += " ";
    }
    result += tenthString;
    if (result.length() > 0) {
    	result += " ";
    }
    result += singleString;
    return result;
  }
  
  
  private static String[] separateString(String numberString) {
  	if (numberString == null || numberString.length() <= 0 ) return new String[0];
  	
  	if (numberString.length() <= 3) {
  		String[] s = new String[1];
  		s[0] = numberString;
  		return s;
  	}
  	String[] s = new String[numberString.length() / 3 + 1];
		int count = numberString.length();
		
  	for (int i = numberString.length(), j = 0; i >= 0 ; i=i-3,j++ ) {
  		if (count < 3) {
  			s[j] = numberString.substring(i-count, i);
  		}
  		else {
  			s[j] = numberString.substring(i-3, i);
  			count = count - 3;
  		}
  	}
  	
  	return s;
  }
}
