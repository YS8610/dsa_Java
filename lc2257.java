public class lc2257 {

  private static void dfs(
    boolean[][] map,
    char[][] gw,
    int r,
    int c,
    int h,
    int v
  ) {
    if (r < 0 || c < 0 || r >= map.length || c >= map[0].length) return;
    if (gw[r][c] == 'g' || gw[r][c] == 'w') return;
    map[r][c] = true;
    dfs(map, gw, r + h, c + v, h, v);
  }

  public int countUnguarded(int m, int n, int[][] guards, int[][] walls) {
    boolean[][] map = new boolean[m][n];
    char[][] gw = new char[m][n];
    int ans = 0;
    for (int[] g : guards) gw[g[0]][g[1]] = 'g';
    for (int[] w : walls) gw[w[0]][w[1]] = 'w';
    for (int r = 0; r < m; r++) {
      for (int c = 0; c < n; c++) {
        if (gw[r][c] == 'g') {
          dfs(map, gw, r + 1, c, 1, 0);
          dfs(map, gw, r - 1, c, -1, 0);
          dfs(map, gw, r, c + 1, 0, 1);
          dfs(map, gw, r, c - 1, 0, -1);
        }
      }
    }
    for (int r = 0; r < m; r++) for (int c = 0; c < n; c++) if (
      !map[r][c]
    ) ans++;
    return ans - guards.length - walls.length;
  }
}
