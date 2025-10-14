import java.util.PriorityQueue;

public class lc407 {
  public int trapRainWater(int[][] heightMap) {
    int lr = heightMap.length;
    int lc = heightMap[0].length;
    int ans = 0;
    int tmpMaxH = -1;
    PriorityQueue<int[]> pq = new PriorityQueue<>((m1, m2) -> Integer.compare(m1[0], m2[0]));
    int[] tmp;
    int[][] udlr = new int[4][2];
    boolean[][] visited = new boolean[lr][lc];
    // adding top and bottom horizontal row
    for (int c = 0; c < lc; c++) {
      pq.add(new int[] { heightMap[0][c], 0, c });
      visited[0][c] = true;
      pq.add(new int[] { heightMap[lr - 1][c], lr - 1, c });
      visited[lr-1][c] = true;
    }
    // adding leftmost and rightmost vertical col
    for (int r = 0; r < lr; r++) {
      pq.add(new int[] { heightMap[r][0], r, 0 });
      visited[r][0] = true;
      pq.add(new int[] { heightMap[r][lc - 1], r, lc - 1 });
      visited[r][lc-1] = true;
    }
    while (!pq.isEmpty()) {
      tmp = pq.poll();
      tmpMaxH = Math.max(tmpMaxH, tmp[0]);
      ans += Math.max(0, tmpMaxH - tmp[0]);
      // up
      udlr[0][0] = tmp[1] - 1;
      udlr[0][1] = tmp[2];
      // down
      udlr[1][0] = tmp[1] + 1;
      udlr[1][1] = tmp[2];
      // left
      udlr[2][0] = tmp[1];
      udlr[2][1] = tmp[2] - 1;
      // right
      udlr[3][0] = tmp[1];
      udlr[3][1] = tmp[2] + 1;
      for (int i = 0; i < 4; i++) {
        if (udlr[i][0] < 0 ||
            udlr[i][0] >= lr ||
            udlr[i][1] < 0 ||
            udlr[i][1] >= lc ||
            visited[udlr[i][0]][udlr[i][1]])
          continue;
        pq.add(new int[] { heightMap[udlr[i][0]][udlr[i][1]], udlr[i][0], udlr[i][1] });
        visited[udlr[i][0]][udlr[i][1]] = true;
      }
    }
    return ans;
  }
}
