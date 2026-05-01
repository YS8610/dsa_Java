public class lc3212 {
  public int numberOfSubmatrices(char[][] grid) {
    int lr = grid.length;
    int lc = grid[0].length;
    int[][][] prefix = new int[lr][lc][2];
    prefix[0][0][0] = grid[0][0] == 'X' ? 1 : 0;
    prefix[0][0][1] = grid[0][0] == 'Y' ? 1 : 0;
    for (int c = 1; c < lc; c++) {
      prefix[0][c][0] = prefix[0][c - 1][0] + (grid[0][c] == 'X' ? 1 : 0);
      prefix[0][c][1] = prefix[0][c - 1][1] + (grid[0][c] == 'Y' ? 1 : 0);
    }
    for (int r = 1; r < lr; r++) {
      prefix[r][0][0] = prefix[r - 1][0][0] + (grid[r][0] == 'X' ? 1 : 0);
      prefix[r][0][1] = prefix[r - 1][0][1] + (grid[r][0] == 'Y' ? 1 : 0);
    }
    int ans = 0;
    for (int r = 1; r < lr; r++) {
      for (int c = 1; c < lc; c++) {
        prefix[r][c][0] = prefix[r - 1][c][0] + prefix[r][c - 1][0] - prefix[r - 1][c - 1][0]
            + (grid[r][c] == 'X' ? 1 : 0);
        prefix[r][c][1] = prefix[r - 1][c][1] + prefix[r][c - 1][1] - prefix[r - 1][c - 1][1]
            + (grid[r][c] == 'Y' ? 1 : 0);
      }
    }
    // System.out.println(Arrays.deepToString(prefix));
    for (int r = 0; r < lr; r++) {
      for (int c = 0; c < lc; c++) {
        if (prefix[r][c][0] == 0 || prefix[r][c][0] != prefix[r][c][1])
          continue;
        ans++;
      }
    }
    return ans;
  }
}
