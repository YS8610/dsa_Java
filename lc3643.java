public class lc3643 {
  public int[][] reverseSubmatrix(int[][] grid, int x, int y, int k) {
    int lp, rp;
    for (int c = y, m = y + k, tmp = 0; c < m; c++) {
      lp = x;
      rp = x + k - 1;
      while (lp < rp) {
        tmp = grid[lp][c];
        grid[lp][c] = grid[rp][c];
        grid[rp][c] = tmp;
        lp++;
        rp--;
      }
    }
    return grid;
  }
}
