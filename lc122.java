public class lc122 {
  
  private static int maxProfit(int[] prices) {
    int ans = 0;
    int n = prices.length;
    for(int i =1; i<n; i++){
      int profit = prices[i]-prices[i-1];
      if (profit>0) ans += profit;
    }
    return ans;
  }

  public static void main(String[] args) {
    int[] prices = {2,1,2,0,1};
    System.out.println( maxProfit(prices) );
  }
}
