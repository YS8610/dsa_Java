public class lc3652 {
  public long maxProfit(int[] prices, int[] strategy, int k) {
    int l = prices.length;
    long[] prefix = new long[l + 1];
    long[] prefixT = new long[l + 1];
    long ans = 0;
    for (int i = 0; i < l; i++) {
      prefix[i + 1] = prefix[i] + prices[i];
      prefixT[i + 1] = prefixT[i] + prices[i] * strategy[i];
    }
    ans = prefixT[l];
    long tmp;
    for (int i = 0, n = l - k, win = k / 2; i <= n; i++) {
      tmp = prefixT[l] - prefixT[i + k] + prefixT[i];
      tmp += prefix[i + k] - prefix[i + win];
      ans = Math.max(tmp, ans);
    }
    return ans;
  }
}
