public class lc2110 {
  public long getDescentPeriods(int[] prices) {
    int l = prices.length;
    long ans = 0;
    for (int i = 0, tmp = 0; i < l; i++) {
      if (i == 0) {
        tmp = 1;
        ans++;
        continue;
      }
      tmp = prices[i - 1] - prices[i] == 1 ? tmp + 1 : 1;
      ans += tmp;
    }
    return ans;
  }
}
