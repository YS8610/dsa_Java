import java.util.Arrays;

public class lc3567 {
  public int[][] minAbsDiff(int[][] grid, int k) {
    int lr = grid.length;
    int lc = grid[0].length;
    int[][] ans = new int[lr - k + 1][lc - k + 1];
    for (int r = 0, n = lr - k; r <= n; r++)
      for (int c = 0, m = lc - k; c <= m; c++)
        ans[r][c] = solve(grid, k, r, c);
    return ans;
  }

  public int solve(int[][] grid, int k, int row, int col) {
    if (k == 1)
      return 0;
    int[] list = new int[k * k];
    for (int r = row, n = row + k, ind = 0; r < n; r++)
      for (int c = col, m = col + k; c < m; c++)
        list[ind++] = grid[r][c];
    Arrays.sort(list);
    int ans = -1;
    for (int i = 0, n = k * k - 1, diff = 0; i < n; i++) {
      diff = list[i + 1] - list[i];
      if (diff == 0)
        continue;
      if (ans == -1)
        ans = diff;
      else
        ans = Math.min(ans, diff);
    }
    return ans == -1 ? 0 : ans;
  }
}
