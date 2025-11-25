public class lc121 {
  private static int maxProfit(int[] prices) {
    int ans = 0;
    int len = prices.length;
    if (len==1) return 0;
    int min = prices[0];
    for ( int i = 1; i<len;i++ ){
      min = Math.min(min,prices[i] );
      ans = ans < prices[i] - min? prices[i] - min : ans;
    }
    return ans;
  }

  public static void main(String[] args) {
    int[] prices = {7,1,5,3,6,4};
    // int[] prices = {1};

    System.out.println( maxProfit(prices));

  }
}
