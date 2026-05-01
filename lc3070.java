public class lc3070 {
  public int countSubmatrices(int[][] grid, int k) {
    int lr = grid.length;
    int lc = grid[0].length;
    int ans = 0;
    int[][] prefix = new int[lr][lc];
    prefix[0][0] = grid[0][0];
    for (int c = 1; c < lc; c++)
      prefix[0][c] = prefix[0][c - 1] + grid[0][c];
    for (int r = 1; r < lr; r++)
      prefix[r][0] = prefix[r - 1][0] + grid[r][0];
    for (int r = 1; r < lr; r++)
      for (int c = 1; c < lc; c++)
        prefix[r][c] = prefix[r - 1][c] + prefix[r][c - 1] - prefix[r - 1][c - 1] + grid[r][c];
    for (int r = 0; r < lr; r++)
      for (int c = 0; c < lc; c++)
        ans += prefix[r][c] <= k ? 1 : 0;
    return ans;
  }
}
