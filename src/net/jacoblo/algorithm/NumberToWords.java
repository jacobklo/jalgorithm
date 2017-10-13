package net.jacoblo.algorithm;

public class NumberToWords {
  public static void main(String[] main) {
    int number = 99;
    String result = numberToWords( number);
    System.out.println(result);
  }
  
  public enum ScalesOfNumbers {
    HUNDRED("Hundred", 3),
    THOUSAND("Thousand", 4),
    MILLION("Million", 7),
    BILLION("Billion", 10),
    TRILLION("Trillion", 13),
    QUADRILLION("Quadrillion", 16);
    
    
    public final String name;
    public final int digit;
    
    private ScalesOfNumbers(String n, int d) {
      this.name = n;
      this.digit = d;
    }
  }
  
  public enum NumberName {
    ZERO("zero"),
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
      if (v < 11 || v > 19) return null;
      return TeenName.values()[v-11];
    }
  }
  
  public static String numberToWords(int number) {
    if ( number < 0 ) return "";
    String numberString = Integer.toString(number);
    String result = "";
    
    for (int i = 0 , j = numberString.length(); i < numberString.length() && j > 0; i++,j--) {
      int nextLions = ((int)(j / 3)) * 3;
      
      System.out.println(nextLions);
    }
    
    return "";
  }
  
  public static String numberToWordsHundreds(int number) {
    
    String numberString = Integer.toString(number);
    
    if (number < 1000) {
      String result = "";
      if (number > 99) {
        char curChar = numberString.charAt(numberString.length() - 3);
        result += NumberName.values()[Character.getNumericValue(curChar)].name + " " + ScalesOfNumbers.HUNDRED.name;
      
        if (number % 100 != 0) {
          result += " and";
        }
      }
      
      if (number > 9 && numberString.charAt(numberString.length()-2) != '1') {
        char curChar = numberString.charAt(numberString.length() - 2);
        result += " ";
        result +=  TenthName.values()[Character.getNumericValue(curChar)].name;
      }
      else if (number > 9 && numberString.charAt(numberString.length()-2) == '1') {
        result += " ";
        int digitNumber = 10 + Character.getNumericValue(numberString.charAt(numberString.length()-1));
        result += TeenName.getValue(digitNumber).name;
        return result;
      }     
      if (number > 0 && (number < 10 || numberString.charAt(numberString.length()-2) != '1')) {
        char curChar = numberString.charAt(numberString.length() - 1);
        result += " ";
        result +=  NumberName.values()[Character.getNumericValue(curChar)].name;
      }
      return result;
    }
    
    return "";
  }
  
}
