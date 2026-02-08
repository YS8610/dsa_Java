public class lc2435 {
  static public int numberOfPaths(int[][] grid, int k) {
    int MOD = 1000000007;
    int lr = grid.length;
    int lc = grid[0].length;
    int[][][] dp = new int[lr][lc][k];
    dp[0][0][grid[0][0] % k]++;
    grid[0][0] %= k;
    // first row
    for (int c = 1, tmp = grid[0][0]; c < lc; c++) {
      tmp = (tmp + grid[0][c]) % k;
      dp[0][c][tmp]++;
    }
    // first col
    for (int r = 1, tmp = grid[0][0]; r < lr; r++) {
      tmp = (tmp + grid[r][0]) % k;
      dp[r][0][tmp]++;
    }
    for (int r = 1; r < lr; r++) {
      for (int c = 1; c < lc; c++) {
        // top
        for (int i = 0, count = 0; i < k; i++) {
          if (dp[r - 1][c][i] == 0)
            continue;
          count = dp[r - 1][c][i];
          dp[r][c][(i + grid[r][c]) % k] += (count % MOD);
        }
        // left
        for (int i = 0, count = 0; i < k; i++) {
          if (dp[r][c - 1][i] == 0)
            continue;
          count = dp[r][c - 1][i];
          dp[r][c][(i + grid[r][c]) % k] += (count % MOD);
        }
      }
    }
    return dp[lr - 1][lc - 1][0] % MOD;
  }

  public static void main(String[] args) {
    int[][] grid = { { 5, 2, 4 }, { 3, 0, 5 }, { 0, 7, 2 } };
    int k = 3;
    System.out.println(numberOfPaths(grid, k));
  }
}
