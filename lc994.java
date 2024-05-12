import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;

public class lc994 {

  private static int orangesRotting(int[][] grid) {
    int rlen = grid[0].length;
    int clen = grid.length;
    List<int[]> rotten = new ArrayList<>();
    int freshQty = 0;
    int timeElapsed = 0;
    Queue<int[]> q = new LinkedList<>();
    for (int r = 0; r < clen; r++) {
      for (int c = 0; c < rlen; c++) {
        if (grid[r][c] == 2) rotten.add(new int[] { r, c });
        if (grid[r][c] == 1) freshQty++;
      }
    }
    if (freshQty == 0) return 0;
    q.addAll(rotten);
    int[] temp;
    while (!q.isEmpty()) {
      for (int i = 0, n = q.size(); i < n; i++) {
        temp = q.poll();
        if (
          temp[0] < 0 ||
          temp[1] < 0 ||
          temp[0] >= clen ||
          temp[1] >= rlen ||
          grid[temp[0]][temp[1]] == 0 ||
          grid[temp[0]][temp[1]] == 3
        ) {
          continue;
        }

        // up
        q.add(new int[] { temp[0] - 1, temp[1] });
        // down
        q.add(new int[] { temp[0] + 1, temp[1] });
        // left
        q.add(new int[] { temp[0], temp[1] - 1 });
        // right
        q.add(new int[] { temp[0], temp[1] + 1 });
        if (grid[temp[0]][temp[1]] == 1) {
          freshQty--;
        }
        grid[temp[0]][temp[1]] = 3;
      }
      timeElapsed++;
      if (freshQty == 0) return timeElapsed - 1;
    }
    return -1;
  }

  public static void main(String[] args) {
    int[][] grid = { { 2, 1, 1 }, { 1, 1, 0 }, { 0, 1, 1 } };
    System.out.println(orangesRotting(grid));
  }
}
