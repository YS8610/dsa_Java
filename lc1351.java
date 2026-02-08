
public class lc1351 {

  static public int countNegatives(int[][] grid) {
    int lr = grid.length;
    int lc = grid[0].length;
    int ans = 0;
    for (int i = lr - 1, pos = 0; i >= 0; i--) {
      for (int j = pos; j < lc; j++) {
        if (grid[i][j] >= 0)
          continue;
        pos = j;
        ans += lc - pos;
        break;
      }
    }
    return ans;
  }

  public static void main(String[] args) {
    int[][] grid = { { 5, 1, 0 }, { -5, -5, -5 } };
    System.out.println(countNegatives(grid));

  }
}
