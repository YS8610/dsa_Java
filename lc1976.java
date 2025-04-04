import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class lc1976 {
  private static final int MOD = 1000000007;

  private static int countPaths(int n, int[][] roads) {
    Map<Integer, Integer> map = new HashMap<>();
    boolean[] visit = new boolean[n];
    map.put(-1, Integer.MAX_VALUE);
    Map<Integer, List<Integer>> adj = new HashMap<>();
    int[][] cost = new int[n][n];
    for (int[] r : roads) {
      if (adj.containsKey(r[0]))
        adj.get(r[0]).add(r[1]);
      else
        adj.put(r[0], new ArrayList<>(Arrays.asList(r[1])));
      if (adj.containsKey(r[1]))
        adj.get(r[1]).add(r[0]);
      else
        adj.put(r[1], new ArrayList<>(Arrays.asList(r[0])));
      cost[r[0]][r[1]] = r[2];
      cost[r[1]][r[0]] = r[2];
    }
    dfs(map, adj, cost, visit, n - 1, 0, 0);
    return map.get(map.get(-1));
  }

  private static void dfs(Map<Integer, Integer> map, Map<Integer, List<Integer>> adj, int[][] cost, boolean[] visit,
      int target, int node, int t) {
    if (visit[node])
      return;
    if (t > map.get(-1))
      return;
    if (node == target && t <= map.get(-1)) {
      map.computeIfPresent(t, (k, v) -> (v==MOD?0:v) + 1);
      map.computeIfAbsent(t, (k) -> 1);
      if (t < map.get(-1))
        map.put(-1, t);
      return;
    }
    visit[node] = true;
    for (int a : adj.get(node)) {
      dfs(map, adj, cost, Arrays.copyOf(visit, visit.length), target, a, t + cost[node][a]);
    }
  }

  public static void main(String[] args) {
    int n = 7;
    int[][] roads = { { 0, 6, 7 }, { 0, 1, 2 }, { 1, 2, 3 }, { 1, 3, 3 }, { 6, 3, 3 }, { 3, 5, 1 }, { 6, 5, 1 },
        { 2, 5, 1 }, { 0, 4, 5 }, { 4, 6, 2 } };
    System.out.println(countPaths(n, roads));
  }
}
