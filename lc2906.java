public class lc2906 {
  public int[][] constructProductMatrix(int[][] grid) {
    final int MOD = 12345;
    int lr = grid.length;
    int lc = grid[0].length;
    int[][] ans = new int[lr][lc];
    long suffix = 1;
    for (int r = lr - 1; r >= 0; r--) {
      for (int c = lc - 1; c >= 0; c--) {
        ans[r][c] = (int) suffix;
        suffix = (suffix * grid[r][c]) % MOD;
      }
    }
    suffix = 1;
    for (int r = 0; r < lr; r++) {
      for (int c = 0; c < lc; c++) {
        ans[r][c] = (int) (((long) ans[r][c] * suffix) % MOD);
        suffix = (suffix * grid[r][c]) % MOD;
      }
    }
    return ans;
  }
}
