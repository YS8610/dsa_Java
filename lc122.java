import java.util.Arrays;

public class lc122 {
    private static int maxp(int[] prices, int i, boolean canbuy, int[][] memo){
    if (i >= prices.length) return 0;
    if (canbuy && memo[i][0]!=Integer.MIN_VALUE) return memo[i][0];
    if (!canbuy && memo[i][1] !=Integer.MIN_VALUE) return memo[i][1];
    int res=0;
    // buy phase
    if (canbuy){
      int buy = maxp(prices, i+1, false, memo)-prices[i];
      int nobuy = maxp(prices, i+1, true, memo);
      res =Math.max(buy,nobuy);
    }
    // sell phase
    else{
      int sell = maxp(prices, i+1, true, memo) + prices[i];
      int nosell = maxp(prices, i+1, false, memo);
      res= Math.max(sell, nosell);
    }
    if (canbuy) memo[i][0] = res;
    else memo[i][1] =res;
    return res;
  }


  public int maxProfit1(int[] prices) {
    int[][] memo = new int[prices.length][2];
    for(int[] m:memo) Arrays.fill(m, Integer.MIN_VALUE);
    return maxp(prices, 0, true, memo);
  }


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
