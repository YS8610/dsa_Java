public class lc1652 {

  public int[] decrypt(int[] code, int k) {
    int l = code.length;
    int[] ans = new int[l];
    if (k == 0) return ans;
    int[] dp = new int[l];
    int diff = 0;
    if (k > 0) {
      dp[0] = code[0];
      for (int i = 1; i < l; i++) dp[i] = dp[i - 1] + code[i];
      for (int i = 0; i < l; i++) {
        diff = l - (i + k + 1);
        if (diff >= 0) ans[i] = dp[i + k] - dp[i]; else ans[i] =
          dp[l - 1] - dp[i] + dp[-diff - 1];
      }
      return ans;
    }
    dp[l - 1] = code[l - 1];
    for (int i = l - 2; i >= 0; i--) dp[i] = dp[i + 1] + code[i];
    for (int i = l - 1; i >= 0; i--) {
      diff = i + k;
      if (diff >= 0) ans[i] = dp[diff] - dp[i]; else ans[i] =
        dp[0] - dp[i] + dp[l + diff];
    }
    return ans;
  }
}
