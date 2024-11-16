public class lc2684 {

  private static int dfs(
    int[][] grid,
    int r,
    int c,
    int[][] memo,
    int n,
    int prev
  ) {
    if (r >= grid.length || r < 0) return n;
    if (c >= grid[0].length) return n;
    if (grid[r][c] <= prev) return n;
    if (memo[r][c] != 0) return memo[r][c];
    n++;
    int tl = dfs(grid, r - 1, c + 1, memo, n, grid[r][c]);
    int l = dfs(grid, r, c + 1, memo, n, grid[r][c]);
    int bl = dfs(grid, r + 1, c + 1, memo, n, grid[r][c]);
    memo[r][c] = Math.max(tl, Math.max(l, bl));
    return memo[r][c];
  }

  private static int maxMoves(int[][] grid) {
    int lr = grid[0].length;
    int lc = grid.length;
    int[][] memo = new int[lc][lr];
    int ans = 0;
    for (int r = 0; r < lc; r++) {
      ans = Math.max(ans, dfs(grid, r, 0, memo, 0, 0));
    }
    return ans - 1;
  }

  public static void main(String[] args) {
    int[][] grid = {
      {2,4,3,5},
      {5,4,9,3},
      {3,4,2,11},
      {10,9,13,15}
    };
    System.out.println(maxMoves(grid));
  }
}
