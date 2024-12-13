import java.util.LinkedList;
import java.util.Queue;

public class lc909 {

  public int snakesAndLadders(int[][] board) {
    int l = board.length;
    int[] map = new int[l * l + 1];
    int count = l * l;
    for (int r = 0; r < l; r++) {
      if (l % 2 == 0) {
        if ((r & 1) == 0) {
          for (int c = 0; c < l; c++, count--) {
            if (board[r][c] == -1) continue;
            map[count] = board[r][c];
          }
          continue;
        }
        for (int c = l - 1; c >= 0; c--, count--) {
          if (board[r][c] == -1) continue;
          map[count] = board[r][c];
        }
      } else {
        if ((r & 1) == 0) {
          for (int c = l - 1; c >= 0; c--, count--) {
            if (board[r][c] == -1) continue;
            map[count] = board[r][c];
          }
          continue;
        }
        for (int c = 0; c < l; c++, count--) {
          if (board[r][c] == -1) continue;
          map[count] = board[r][c];
        }
      }
    }
    boolean[] visited = new boolean[l * l + 1];
    Queue<Integer> q = new LinkedList<>();
    q.add(1);
    int cur = 1;
    int ans = 0;
    int end = l * l;
    while (!q.isEmpty()) {
      for (int i = 0, n = q.size(); i < n; i++) {
        cur = q.poll();
        if (cur >= end) return ans;
        for (int j = 1, m = Math.min(6, end - cur); j <= m; j++) {
          if (visited[cur + j]) continue;
          if (map[cur + j] != 0) {
            visited[cur + j] = true;
            q.add(map[cur + j]);
            // visited[map[cur+j]] = true;
            if (map[cur + j] >= end) return ans + 1;
            continue;
          }
          q.add(cur + j);
          visited[cur + j] = true;
          if (cur + j >= end) return ans + 1;
        }
      }
      ans++;
    }
    return -1;
  }
}
