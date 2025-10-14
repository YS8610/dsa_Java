public class lc1254 {
  static public int closedIsland(int[][] grid) {
    int lr = grid[0].length;
    int lc = grid.length;
    int ans = 0;
    for (int r = 0; r < lc; r++) {
      for (int c = 0; c < lr; c++) {
        if (grid[r][c] >= 1)
          continue;
        ans += dfs(grid, r, c) ? 1 : 0;
      }
    }
    return ans;
  }

  static public boolean dfs(int[][] grid, int r, int c) {
    int lr = grid[0].length;
    int lc = grid.length;
    if (r >= lc || c >= lr || r < 0 || c < 0)
      return false;
    if (grid[r][c] >= 1)
      return true;
    grid[r][c] = 2;
    boolean up = dfs(grid, r - 1, c);
    boolean down = dfs(grid, r + 1, c);
    boolean left = dfs(grid, r, c - 1);
    boolean right = dfs(grid, r , c + 1);
    return up && down && left && right;
  }

  static public void main(String[] args) {
    int[][] grid = {
        { 0, 0, 1, 1, 0, 1, 0, 0, 1, 0 }, 
        { 1, 1, 0, 1, 1, 0, 1, 1, 1, 0 }, 
        { 1, 0, 1, 1, 1, 0, 0, 1, 1, 0 },
        { 0, 1, 1, 0, 0, 0, 0, 1, 0, 1 }, 
        { 0, 0, 0, 0, 0, 0, 1, 1, 1, 0 }, 
        { 0, 1, 0, 1, 0, 1, 0, 1, 1, 1 },
        { 1, 0, 1, 0, 1, 1, 0, 0, 0, 1 }, 
        { 1, 1, 1, 1, 1, 1, 0, 0, 0, 0 }, 
        { 1, 1, 1, 0, 0, 1, 0, 1, 0, 1 },
        { 1, 1, 1, 0, 1, 1, 0, 1, 1, 0 }
    };
  System.out.println(closedIsland(grid));
  }
}
