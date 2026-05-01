public class lc3546 {
  public boolean canPartitionGrid(int[][] grid) {
    int lr = grid.length;
    int lc = grid[0].length;
    long[][] prefix = new long[lr][lc];
    prefix[0][0] = grid[0][0];
    for (int c = 1; c < lc; c++)
      prefix[0][c] = prefix[0][c - 1] + grid[0][c];
    for (int r = 1; r < lr; r++)
      prefix[r][0] = prefix[r - 1][0] + grid[r][0];
    for (int r = 1; r < lr; r++)
      for (int c = 1; c < lc; c++)
        prefix[r][c] = grid[r][c] + prefix[r - 1][c] + prefix[r][c - 1] - prefix[r - 1][c - 1];
    // System.out.println(Arrays.deepToString(prefix));
    for (int r = 0, n = lr - 1; r < n; r++)
      if (prefix[r][lc - 1] * 2 == prefix[lr - 1][lc - 1])
        return true;
    for (int c = 0; c < lc; c++)
      if (prefix[lr - 1][c] * 2 == prefix[lr - 1][lc - 1])
        return true;
    return false;
  }
}
