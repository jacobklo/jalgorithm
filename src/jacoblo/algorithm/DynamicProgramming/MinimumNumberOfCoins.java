package jacoblo.algorithm.DynamicProgramming;

public class MinimumNumberOfCoins {
  public static void main(String[] args) {
    int[] coins = {9 ,6, 5, 1};
    int value = 11;
    int result = MinNumberOfCoins(coins, value);
    System.out.println(result);
  }
  
  public static int MinNumberOfCoins(int[] coins, int value) {
    if (coins == null || coins.length <= 0 ) return 0;
    
    int[] change = new int[value + 1];
    change[0] = 0;
    
    for (int i = 1 ; i < change.length ; i++ ) {
      change[i] = Integer.MAX_VALUE;
    }
    
    for (int i = 1 ; i <= value ; i++) {
      for (int j = 0 ; j < coins.length ; j++) {
        if ( coins[j] <= i) {
          int remainValue = change[i - coins[j]];
          int withoutThisCoin = change[i];
          
          if (remainValue != Integer.MAX_VALUE && remainValue + 1 < withoutThisCoin) {
            change[i] = remainValue + 1;
          }
        }
      }
    }
    return change[value];
  }
}
