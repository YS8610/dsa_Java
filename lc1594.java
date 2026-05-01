public class lc1594 {
  public int maxProductPath(int[][] grid) {
    int lr = grid.length;
    int lc = grid[0].length;
    final int MOD = 1_000_000_007;
    long[][] dpmax = new long[lr][lc];
    long[][] dpmin = new long[lr][lc];
    dpmax[0][0] = grid[0][0];
    dpmin[0][0] = grid[0][0];
    for (int c = 1; c < lc; c++) {
      dpmax[0][c] = dpmax[0][c - 1] * grid[0][c];
      dpmin[0][c] = dpmin[0][c - 1] * grid[0][c];
    }
    for (int r = 1; r < lr; r++) {
      dpmax[r][0] = dpmax[r - 1][0] * grid[r][0];
      dpmin[r][0] = dpmin[r - 1][0] * grid[r][0];
    }
    long max, min;
    for (int r = 1; r < lr; r++) {
      for (int c = 1; c < lc; c++) {
        max = dpmax[r - 1][c] * grid[r][c];
        min = dpmax[r - 1][c] * grid[r][c];
        long m1 = dpmax[r - 1][c] * grid[r][c];
        long m2 = dpmax[r][c - 1] * grid[r][c];
        long m3 = dpmin[r - 1][c] * grid[r][c];
        long m4 = dpmin[r][c - 1] * grid[r][c];
        max = Math.max(max, m1);
        max = Math.max(max, m2);
        max = Math.max(max, m3);
        max = Math.max(max, m4);
        min = Math.min(min, m1);
        min = Math.min(min, m2);
        min = Math.min(min, m3);
        min = Math.min(min, m4);
        dpmin[r][c] = min;
        dpmax[r][c] = max;
      }
    }
    long ans = Math.max(dpmax[lr - 1][lc - 1], dpmin[lr - 1][lc - 1]);
    if (ans < 0)
      return -1;
    return (int) (ans % MOD);
  }
}
