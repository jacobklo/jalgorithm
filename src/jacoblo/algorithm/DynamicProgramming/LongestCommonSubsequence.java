package jacoblo.algorithm.DynamicProgramming;

import jacoblo.lib.Util;

public class LongestCommonSubsequence {
	public static void main(String[] args) {
		String s1 = "ABCDGH";
		String s2 = "AEDFHR";
		String s3 = "AGGTAB";
		String s4 = "GXTXAYB";
    String s5 = "A";
    String s6 = "AAAAAB";
		
//  int result = LongestCommonSubsequenceNaiveDP(s1,s2,s1.length(), s2.length());
  int result1 = LongestCommonSubsequenceDP2(s1,s2 );
  int r1 = LongestCommonSubsequenceDP(s1,s2 );
  
  System.out.println(result1 + " " + r1);
  
//int result = LongestCommonSubsequenceNaiveDP(s1,s2,s1.length(), s2.length());
int result2 = LongestCommonSubsequenceDP2(s3,s4 );
int r2 = LongestCommonSubsequenceDP(s3,s4 );
System.out.println(result2 + " " + r2);

//  int result = LongestCommonSubsequenceNaiveDP(s1,s2,s1.length(), s2.length());
  int result3 = LongestCommonSubsequenceDP2(s5,s6 );
  int r3 = LongestCommonSubsequenceDP(s5,s6 );
  System.out.println(result3 + " " + r3);
//		A B C D G H _
//		A E _ D F H R
		
//		A G G T _ A _ B
//		_ G X T X A _ B
		
		
	}
	
	public static int LongestCommonSubsequenceDP2(String s1, String s2 ) {
	  if (s1 == null || s2 == null || s1.length() <= 0 || s2.length() <= 0 ) return 0;
	  
	  int[][] calc = new int[s1.length()+1][s2.length()+1];
	  
	  for (int i = 1 ; i < calc.length ; i++ ) {
      for ( int j = 1 ; j < calc[i].length ; j++ ) {
        
        int bothHasLetter = calc[i-1][j-1];
        if ( s1.charAt(i-1) != s2.charAt(j-1) ) {
          bothHasLetter++;
        }
        
        int s1LetterEmpty = calc[i-1][j] + 1;
        
        int s2LetterEmpty = calc[i][j-1] + 1;
        
        calc[i][j] = Util.<Integer>min(bothHasLetter, s1LetterEmpty, s2LetterEmpty);
      }
    }
	  
	  return calc[s1.length()][s2.length()];
	}
	
	public static int LongestCommonSubsequenceNaiveDP(String s1, String s2, int currentIndex1, int currentIndex2) {
		if (s1 == null || s2 == null)	return 0;
		
		if (currentIndex1 == 0 || currentIndex2 == 0) {
			return 0;
		}
		
		// case 1 : the last index n of s1 and s2 match, hence, this is optimal
		int LCSmatch = LongestCommonSubsequenceNaiveDP(s1,s2, currentIndex1-1, currentIndex2-1);
		if (s1.charAt(currentIndex1-1) == s2.charAt(currentIndex2-1)) {
			LCSmatch = LCSmatch + 1;
		}
		// case 2 : the last index n of s1 should be empty, to make this optimal
		int LCSempty1 = LongestCommonSubsequenceNaiveDP(s1,s2, currentIndex1-1, currentIndex2) ;
		// case 3 : the last index n of s2 should be empty, to make this optimal
		int LCSempty2 = LongestCommonSubsequenceNaiveDP(s1,s2, currentIndex1, currentIndex2-1) ;
		
		return Util.<Integer>max(LCSmatch, LCSempty1, LCSempty2);
	}
	
	public static int LongestCommonSubsequenceDP(String s1, String s2) {
		if (s1 == null || s2 == null)	return 0;
		
		int[][] LCS = new int[s1.length()+1][s2.length()+1];
		for ( int i = 0; i < LCS.length ; i++) {
			for (int j = 0; j < LCS[i].length ; j++) {
				LCS[i][j] = 0;
			}
		}
		
		for ( int i = 1; i <= s1.length() ; i++) {
			for (int j = 1; j <= s2.length() ; j++) {
				int LCSmatch = LCS[i-1][j-1];
				if (s1.charAt(i-1) == s2.charAt(j-1)) {
					LCSmatch += 1;
				}
				int LCSEmpty1 = LCS[i-1][j];
				int LCSEmpty2 = LCS[i][j-1];
				
				LCS[i][j] = Util.<Integer>max(LCSmatch, LCSEmpty1, LCSEmpty2);
			}
		}
		
		return LCS[s1.length()][s2.length()];
	}
	
}
