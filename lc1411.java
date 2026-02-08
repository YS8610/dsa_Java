public class lc1411 {
  public int numOfWays(int n) {
    int MOD = 1000000007;
    long n2 = 6;
    long n3 = 6;
    long t2, t3;
    for (int i = 0, m = n - 1; i < m; i++) {
      t2 = (3 * n2 + 2 * n3) % MOD;
      t3 = (2 * n2 + 2 * n3) % MOD;
      n2 = t2;
      n3 = t3;
    }
    return (int) (n2 + n3) % MOD;
  }
}
