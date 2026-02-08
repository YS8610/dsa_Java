import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.PriorityQueue;

class lc3650 {
  static public int minCost(int n, int[][] edges) {
    List<int[]>[] adj = new ArrayList[n];
    for (int i = 0; i < n; i++)
      adj[i] = new ArrayList<>();
    for (int[] e : edges) {
      adj[e[0]].add(new int[] { e[1], e[2] });
      adj[e[1]].add(new int[] { e[0], e[2] * 2 });
    }
    PriorityQueue<int[]> q = new PriorityQueue<>((m1, m2) -> Integer.compare(m1[0], m2[0]));
    int[] costs = new int[n];
    Arrays.fill(costs, Integer.MAX_VALUE);
    costs[0] = 0;
    boolean[] visited = new boolean[n];
    if (adj[0].isEmpty())
      return -1;
    // cost, node
    q.add(new int[] { 0, 0 });
    int[] top;
    int tmp;
    while (!q.isEmpty()) {
      top = q.poll();
      if (top[1] == n - 1)
        return top[0];
      if (visited[top[1]])
        continue;
      visited[top[1]] = true;
      for (int[] e : adj[top[1]]) {
        tmp = top[0] + e[1];
        if (tmp >= costs[e[0]])
          continue;
        costs[e[0]] = tmp;
        q.add(new int[] { tmp, e[0] });
      }
    }
    return -1;
  }

  public static void main(String[] args) {
    int n = 4;
    int[][] edges = { { 0, 1, 3 }, { 3, 1, 1 }, { 2, 3, 4 }, { 0, 2, 2 } };
    System.out.println(minCost(n, edges));
  }

}
