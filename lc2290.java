import java.util.Arrays;
import java.util.PriorityQueue;

public class lc2290 {
  public int minimumObstacles(int[][] grid) {
    int lr = grid.length;
    int lc = grid[0].length;
    int[][] times = new int[lr][lc];
    for (int[] t:times) Arrays.fill(t,Integer.MAX_VALUE);
    PriorityQueue<int[]> pq = new PriorityQueue<>(
      (m1,m2) -> Integer.compare(m1[2], m2[2])
    );
    pq.add(new int[]{0, 0, 0});
    int[] tmp;
    int r, c, t;
    while (!pq.isEmpty()){
      tmp = pq.poll();
      r = tmp[0];
      c = tmp[1];
      if ( r < 0 || c < 0 || r >= lr || c >= lc)
        continue;
      t = tmp[2] + grid[r][c];
      if (times[r][c] <= t)
        continue;
      times[r][c] = t;
      if ( r+1 >= 0 && r+1 < lr && times[r+1][c] > t+grid[r+1][c])
        pq.add(new int[]{r+1, c, t});
      if ( r-1 >= 0 && r-1 < lr && times[r-1][c] > t+grid[r-1][c])
        pq.add(new int[]{r-1, c, t});
      if ( c+1 >= 0 && c+1 < lc && times[r][c+1] > t+grid[r][c+1])
        pq.add(new int[]{r, c+1, t});
      if ( c-1 >= 0 && c-1 < lc && times[r][c-1] > t+grid[r][c-1])
        pq.add(new int[]{r, c-1, t});
    }
    return times[lr-1][lc-1];
  }
}
