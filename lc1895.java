public class lc1895 {
  static public int largestMagicSquare(int[][] grid) {
    int lr = grid.length;
    int lc = grid[0].length;
    int[][] hsum = new int[lr][lc];
    int[][] vsum = new int[lr][lc];
    for (int r = 0; r < lr; r++) {
      hsum[r][0] = grid[r][0];
      for (int c = 1; c < lc; c++)
        hsum[r][c] = grid[r][c] + hsum[r][c - 1];
    }
    for (int c = 0; c < lc; c++) {
      vsum[0][c] = grid[0][c];
      for (int r = 1; r < lr; r++)
        vsum[r][c] = grid[r][c] + vsum[r - 1][c];
    }
    for (int i = Math.min(lr, lc); i > 1; i--)
      if (can(i, grid, hsum, vsum))
        return i;
    return 1;
  }

  private static boolean can(int length, int[][] grid, int[][] hsum, int[][] vsum) {
    int lr = grid.length;
    int lc = grid[0].length;
    for (int r = 0, n = lr - length; r <= n; r++)
      for (int c = 0, m = lc - length; c <= m; c++)
        if (magic(r, c, length, grid, hsum, vsum))
          return true;
    return false;
  }

  private static boolean magic(int r, int c, int length, int[][] grid, int[][] hsum, int[][] vsum) {
    int lr = grid.length;
    int lc = grid[0].length;
    if (r + length - 1 >= lr || c + length - 1 >= lc)
      return false;
    // 1st row
    int initialSum = val(r, c + length - 1, hsum) - val(r, c - 1, hsum);
    // checking every row
    for (int row = r + 1, n = r + length; row < n; row++)
      if (initialSum != val(row, c + length - 1, hsum) - val(row, c - 1, hsum))
        return false;
    // checking every col
    for (int col = c, n = c + length; col < n; col++) {
      // int sum = val(r + length - 1, col, vsum) - val(r-1, col, vsum);
      if (initialSum != val(r + length - 1, col, vsum) - val(r - 1, col, vsum))
        return false;
    }
    // checking diagonal
    int dia = 0;
    for (int i = 0; i < length; i++)
      dia += grid[r + i][c + i];
    if (initialSum != dia)
      return false;
    dia = 0;
    for (int i = 0; i < length; i++)
      dia += grid[r + i][c + length - 1 - i];
    if (initialSum != dia)
      return false;
    return true;
  }

  private static int val(int r, int c, int[][] grid) {
    int lr = grid.length;
    int lc = grid[0].length;
    if (r < 0 || c < 0 || r >= lr || c >= lc)
      return 0;
    return grid[r][c];
  }

  public static void main(String[] args) {
    int[][] grid = {
        { 17, 24, 1, 8, 15, 2, 8, 6, 10, 6 },
        { 23, 5, 7, 14, 16, 4, 2, 1, 4, 3 },
        { 4, 6, 13, 20, 22, 5, 4, 6, 2, 3 },
        { 10, 12, 19, 21, 3, 3, 10, 9, 6, 4 },
        { 11, 18, 25, 2, 9, 9, 6, 4, 1, 5 } };
    System.out.println(largestMagicSquare(grid));
  }
}
