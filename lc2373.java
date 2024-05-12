import java.util.Arrays;

public class lc2373 {

  private static int[][] largestLocal(int[][] grid) {
    int lr = grid.length;
    int lc = grid[0].length;
    int[][] ans = new int[lr - 2][lc - 2];
    for (int r = 0; r < lr - 2; r++) {
      for (int c = 0; c < lc - 2; c++) {
        int max = grid[r][c];
        for (int rr = r; rr < r + 3; rr++) {
          for (int cc = c; cc < c + 3; cc++) {
            max = Math.max(max, grid[rr][cc]);
          }
        }
        ans[r][c] = max;
      }
    }
    return ans;
  }

  public static void main(String[] args) {
    int[][] grid = {
      { 9, 9, 8, 1 },
      { 5, 6, 2, 6 },
      { 8, 2, 6, 4 },
      { 6, 2, 2, 2 },
    };
    System.out.println(Arrays.deepToString(largestLocal(grid)));
  }
}
