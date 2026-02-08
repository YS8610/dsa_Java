public class lc840 {

  static public int numMagicSquaresInside(int[][] grid) {
    int lr = grid.length;
    int lc = grid[0].length;
    int ans = 0;
    for (int r = 1, n = lr - 1; r < n; r++)
      for (int c = 1, m = lc - 1; c < m; c++)
        ans += (!unique(grid, r, c) || !total(grid, r, c)) ? 0 : 1;
    return ans;
  }

  private static boolean total(int[][] grid, int r, int c) {
    int lr = grid.length;
    int lc = grid[0].length;
    if (r - 1 < 0 || c - 1 < 0 || c + 1 >= lc || r + 1 >= lr)
      return false;
    // check for row sum
    if (grid[r - 1][c - 1] + grid[r - 1][c] + grid[r - 1][c + 1] != 15)
      return false;
    if (grid[r][c - 1] + grid[r][c] + grid[r][c + 1] != 15)
      return false;
    if (grid[r + 1][c - 1] + grid[r + 1][c] + grid[r + 1][c + 1] != 15)
      return false;
    // check for col sum
    if (grid[r - 1][c - 1] + grid[r][c - 1] + grid[r + 1][c - 1] != 15)
      return false;
    if (grid[r - 1][c] + grid[r][c] + grid[r + 1][c] != 15)
      return false;
    if (grid[r - 1][c + 1] + grid[r][c + 1] + grid[r + 1][c + 1] != 15)
      return false;
    // check for diagonal sum
    if (grid[r - 1][c - 1] + grid[r][c] + grid[r + 1][c + 1] != 15)
      return false;
    if (grid[r - 1][c + 1] + grid[r][c] + grid[r + 1][c - 1] != 15)
      return false;
    return true;
  }

  private static boolean unique(int[][] grid, int r, int c) {
    int lr = grid.length;
    int lc = grid[0].length;
    int bit = 0;
    if (r - 1 < 0 || c - 1 < 0 || c + 1 >= lc || r + 1 >= lr)
      return false;
    bit |= 1 << grid[r][c];
    bit |= 1 << grid[r + 1][c];
    bit |= 1 << grid[r][c + 1];
    bit |= 1 << grid[r - 1][c];
    bit |= 1 << grid[r][c - 1];
    bit |= 1 << grid[r + 1][c + 1];
    bit |= 1 << grid[r - 1][c - 1];
    bit |= 1 << grid[r + 1][c - 1];
    bit |= 1 << grid[r - 1][c + 1];
    if (Integer.bitCount(bit) != 9)
      return false;
    bit >>= 10;
    if (Integer.bitCount(bit) != 0)
      return false;
    return true;
  }

  public static void main(String[] args) {
    int[][] grid = { { 5, 5, 5 }, { 5, 5, 5 }, { 5, 5, 5 } };
    System.out.println(numMagicSquaresInside(grid));
  }
}
