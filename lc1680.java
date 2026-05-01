class lc1680 {
  final int MOD = 1_000_000_007;

  public int concatenatedBinary(int n) {
    long ans = 0;
    int len = 0;
    for (int i = 1; i <= n; i++) {
      len += (i & (i - 1)) == 0 ? 1 : 0;
      ans = (ans << len) % MOD;
      ans = (ans + i) % MOD;
    }
    return (int) ans;
  }
}