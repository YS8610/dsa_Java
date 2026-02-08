public class lc1970 {
  static public int latestDayToCross(int lr, int lc, int[][] cells) {
    int[][] land = new int[lr][lc];
    for (int i = 0, tmp = 0; i < cells.length; i++)
      land[cells[i][0] - 1][cells[i][1] - 1] = ++tmp;
    int lp = 0, rp = cells.length - 1;
    int mp;
    while (lp < rp) {
      mp = (rp + lp + 1) / 2;
      if (can(land, mp))
        lp = mp;
      else
        rp = mp - 1;
    }
    return lp;
  }

  public static boolean can(int[][] land, int day) {
    int lr = land.length;
    int lc = land[0].length;
    boolean[][] visited = new boolean[lr][lc];
    for (int c = 0; c < lc; c++) {
      if (visited[0][c] || land[0][c] <= day)
        continue;
      if (dfs(visited, land, day, 0, c))
        return true;
    }
    return false;
  }

  public static boolean dfs(boolean[][] visited, int[][] land, int day, int r, int c) {
    int lr = land.length;
    int lc = land[0].length;
    if (r < 0 || c < 0 || r >= lr || c >= lc)
      return false;
    if (land[r][c] <= day || visited[r][c])
      return false;
    if (r == lr - 1)
      return true;
    visited[r][c] = true;
    return dfs(visited, land, day, r + 1, c) ||
        dfs(visited, land, day, r - 1, c) ||
        dfs(visited, land, day, r, c + 1) ||
        dfs(visited, land, day, r, c - 1);
  }

  public static void main(String[] args) {
    int row = 2, col = 2;
    int[][] cells = {{1,1},{2,1},{1,2},{2,2}};
    System.out.println(latestDayToCross(row, col, cells));
  }
}
