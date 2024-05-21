public class lc1219 {

  private static int dfs(int[][] grid, int r, int c, int gold, int[][] visited) {
    if (r < 0 || c < 0 || c >= grid[0].length || r >= grid.length) return gold;
    if (grid[r][c] == 0 || visited[r][c] == -1) return gold;
    gold += grid[r][c];
    visited[r][c] = -1;
    int max = dfs(grid, r + 1, c, gold, visited);
    max = Math.max(max, dfs(grid, r - 1, c, gold, visited));
    max = Math.max(max, dfs(grid, r, c + 1, gold, visited));
    max = Math.max(max, dfs(grid, r, c - 1, gold, visited));
    visited[r][c] = 0;
    return max;
  }

  private static int getMaximumGold(int[][] grid) {
    int lr = grid.length;
    int lc = grid[0].length;
    int ans = 0;
    for (int r = 0; r < lr; r++) {
      for (int c = 0; c < lc; c++) {
        if (grid[r][c] <= 0) continue;
        ans = Math.max(ans, dfs(grid, r, c, 0, new int[lr][lc]));
      }
    }
    return ans;
  }

  public static void main(String[] args) {
    int[][] grid = {
      { 1, 0, 7, 0, 0, 0 },
      { 2, 0, 6, 0, 1, 0 },
      { 3, 5, 6, 7, 4, 2 },
      { 4, 3, 1, 0, 2, 0 },
      { 3, 0, 5, 0, 20, 0 },
    };
    System.out.println(getMaximumGold(grid));
  }
}
