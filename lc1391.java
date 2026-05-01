public class lc1391 {
  static public boolean hasValidPath(int[][] grid) {
    int lr = grid.length;
    int lc = grid[0].length;
    if (lr == 1 && lc == 1)
      return true;
    boolean[][] visited = new boolean[lr][lc];
    int st = grid[0][0];
    visited[0][0] = true;
    if (st == 1)
      return dfs(grid, visited, 0, -1, -2) || dfs(grid, visited, 0, 1, 2);
    if (st == 2)
      return dfs(grid, visited, -1, 0, -1) || dfs(grid, visited, 1, 0, 1);
    if (st == 3)
      return dfs(grid, visited, 0, -1, -2) || dfs(grid, visited, 1, 0, 1);
    if (st == 4)
      return dfs(grid, visited, 1, 0, 1) || dfs(grid, visited, 0, 1, 2);
    if (st == 5)
      return dfs(grid, visited, 0, -1, -2) || dfs(grid, visited, -1, 0, -1);
    // st == 6
    return dfs(grid, visited, -1, 0, -1) || dfs(grid, visited, 0, 1, 2);
  }

  // up=-1, down = 1, left= -2, right = 2
  static public boolean dfs(int[][] grid, boolean[][] visited, int r, int c, int dir) {
    int lr = grid.length;
    int lc = grid[0].length;
    if (r < 0 || r >= lr || c < 0 || c >= lc)
      return false;
    if (visited[r][c])
      return false;
    int st = grid[r][c];
    // up
    if (dir == -1 && (st == 1 || st == 5 || st == 6))
      return false;
    // down
    if (dir == 1 && (st == 1 || st == 3 || st == 4))
      return false;
    // left
    if (dir == -2 && (st == 2 || st == 3 || st == 5))
      return false;
    // right
    if (dir == 2 && (st == 2 || st == 4 || st == 6))
      return false;
    if (r == lr - 1 && c == lc - 1)
      return true;
    visited[r][c] = true;
    if (st == 1)
      return dfs(grid, visited, r, c - 1, -2) || dfs(grid, visited, r, c + 1, 2);
    if (st == 2)
      return dfs(grid, visited, r - 1, c, -1) || dfs(grid, visited, r + 1, c, 1);
    if (st == 3)
      return dfs(grid, visited, r, c - 1, -2) || dfs(grid, visited, r + 1, c, 1);
    if (st == 4)
      return dfs(grid, visited, r + 1, c, 1) || dfs(grid, visited, r, c + 1, 2);
    if (st == 5)
      return dfs(grid, visited, r, c - 1, -2) || dfs(grid, visited, r - 1, c, -1);
    // st == 6
    return dfs(grid, visited, r - 1, c, -1) || dfs(grid, visited, r, c + 1, 2);
  }

  public static void main(String[] args) {
    int[][] grid = { { 4, 1, 3 }, { 6, 1, 2 } };
    System.out.println(hasValidPath(grid));
  }
}
