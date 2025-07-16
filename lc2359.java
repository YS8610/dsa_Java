import java.util.Deque;
import java.util.ArrayDeque;
import java.util.Arrays;

public class lc2359 {
  public int closestMeetingNode(int[] edges, int node1, int node2) {
    int l = edges.length;
    int[] d1 = new int[l];
    int[] d2 = new int[l];
    Arrays.fill(d1, Integer.MAX_VALUE);
    Arrays.fill(d2, Integer.MAX_VALUE);
    bfs(edges, node1, d1);
    bfs(edges, node2, d2);
    int ans = -1;
    for (int i = 0, tmp = Integer.MAX_VALUE; i < l; i++) {
      if (tmp > Math.max(d1[i], d2[i])) {
        ans = i;
        tmp = Math.max(d1[i], d2[i]);
      }
    }
    return ans;
  }

  private static void bfs(int[] edges, int node, int[] d) {
    int l = edges.length;
    Deque<Integer> q = new ArrayDeque<>();
    boolean[] visited = new boolean[l];
    int dis = 0;
    int top;
    q.add(node);
    while (!q.isEmpty()) {
      for (int i = 0, n = q.size(); i < n; i++) {
        top = q.poll();
        if (top == -1)
          continue;
        if (visited[top])
          continue;
        visited[top] = true;
        q.add(edges[top]);
        d[top] = dis;
      }
      dis++;
    }
  }
}
