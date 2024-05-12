public class lc1289 {

  private static int minFallingPathSum(int[][] grid) {
    int row = grid.length;
    int ans;
    if (row == 1) return grid[0][0];
    int[][] dp = new int[row][row];
    for (int i = 0; i < row; i++) dp[row - 1][i] = grid[row - 1][i];
    for (int r = row - 2; r >= 0; r--) {
      for (int c = 0; c < row; c++) {
        ans = Integer.MAX_VALUE;
        for (int nc = 0; nc < row; nc++) {
          if (nc == c) continue;
          ans = Math.min(ans, dp[r + 1][nc]);
        }
        dp[r][c] = ans + grid[r][c];
      }
    }
    ans = dp[0][0];
    for (int i = 0; i < row; i++) ans = Math.min(ans, dp[0][i]);
    return ans;
  }

  public static void main(String[] args) {
    int[][] grid = {{1,2,3},{4,5,6},{7,8,9}};
    System.out.println(minFallingPathSum(grid));
  }
}
