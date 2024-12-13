import java.util.Arrays;

public class lc714 {

  private static int maxp(
    int[] prices,
    int fee,
    int i,
    boolean canbuy,
    int[][] memo
  ) {
    if (i >= prices.length) return 0;
    if (canbuy && memo[i][0] != Integer.MIN_VALUE) return memo[i][0];
    if (!canbuy && memo[i][1] != Integer.MIN_VALUE) return memo[i][1];
    int res = 0;
    // buy phase
    if (canbuy) {
      int buy = maxp(prices, fee, i + 1, false, memo) - prices[i];
      int nobuy = maxp(prices, fee, i + 1, true, memo);
      res = Math.max(buy, nobuy);
    }
    // sell phase
    else {
      int sell = maxp(prices, fee, i + 1, true, memo) + prices[i] - fee;
      int nosell = maxp(prices, fee, i + 1, false, memo);
      res = Math.max(sell, nosell);
    }
    if (canbuy) memo[i][0] = res; else memo[i][1] = res;
    return res;
  }

  public int maxProfit(int[] prices, int fee) {
    int[][] memo = new int[prices.length][2];
    for (int[] m : memo) Arrays.fill(m, Integer.MIN_VALUE);
    return maxp(prices, fee, 0, true, memo);
  }
}
