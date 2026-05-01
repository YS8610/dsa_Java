import java.util.HashSet;
import java.util.PriorityQueue;
import java.util.Set;

public class lc1878 {
  public int[] getBiggestThree(int[][] grid) {
    PriorityQueue<Integer> pq = new PriorityQueue<>();
    Set<Integer> set = new HashSet<>();
    int lr = grid.length;
    int lc = grid[0].length;
    for (int r = 0; r < lr; r++) {
      for (int c = 0, tmp = 0, len = 0; c < lc; c++) {
        tmp = 1;
        len = 0;
        while (tmp > 0) {
          tmp = solve(grid, r, c, len++);
          if (tmp <= 0)
            break;
          if (set.contains(tmp))
            continue;
          set.add(tmp);
          pq.add(tmp);
          while (pq.size() > 3)
            pq.poll();
        }
      }
    }
    int[] ans = new int[pq.size()];
    for (int i = pq.size() - 1; i >= 0; i--)
      ans[i] = pq.poll();
    return ans;
  }

  private int solve(int[][] grid, int r, int c, int length) {
    int lr = grid.length;
    int lc = grid[0].length;
    if (length == 0)
      return grid[r][c];
    int left = c - length;
    int right = c + length;
    int up = r - length;
    int down = r + length;
    if (left < 0 || up < 0 || right >= lc || down >= lr)
      return -1;
    int sum = 0;
    for (int i = 0; i < length; i++) {
      if (i == 0) {
        sum += grid[r - length][c];
        continue;
      }
      sum += grid[r - length + i][c + i] + grid[r - length + i][c - i];
    }
    sum += grid[r][c + length] + grid[r][c - length];
    for (int i = 0; i < length; i++) {
      if (i == 0) {
        sum += grid[r + length][c];
        continue;
      }
      sum += grid[r + length - i][c + i] + grid[r + length - i][c - i];
    }
    return sum;
  }
}
