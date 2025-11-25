import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.LinkedList;
import java.util.List;
import java.util.Map;
import java.util.Queue;

public class lc3243 {
  public int[] shortestDistanceAfterQueries(int n, int[][] queries) {
    Map<Integer, List<Integer>> map = new HashMap<>();
    for (int i = 0, m = n - 1; i < m; i++) {
      map.computeIfAbsent(i, _ -> new ArrayList<>());
      map.get(i).add(i + 1);
    }
    int l = queries.length;
    int[] ans = new int[l];
    Arrays.fill(ans, n - 1);
    Queue<Integer> q = new LinkedList<>();
    int tmp;
    int turn = 0;
    boolean[] visited = new boolean[n];
    out: for (int j = 0; j < l; j++) {
      map.get(queries[j][0]).add(queries[j][1]);
      q.clear();
      q.add(0);
      turn = 0;
      Arrays.fill(visited, false);
      while (!q.isEmpty()) {
        for (int i = 0, m = q.size(); i < m; i++) {
          tmp = q.poll();
          if (visited[tmp])
            continue;
          visited[tmp] = true;
          for (int road : map.get(tmp)) {
            q.add(road);
            if (road == n - 1) {
              ans[j] = turn + 1;
              continue out;
            }
          }
        }
        turn++;
      }
    }
    return ans;
  }
}
