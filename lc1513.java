public class lc1513 {
  public int numSub(String s) {
    int ans = 0;
    int MOD = 1000000007;
    int l = s.length();
    for (int i = 0, tmp = 0; i < l; i++) {
      if (s.charAt(i) == '0') {
        tmp = 0;
        continue;
      }
      ans += ++tmp;
      ans %= MOD;
    }
    return ans;
  }
}
