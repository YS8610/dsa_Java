import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class lc2872 {
  static public int maxKDivisibleComponents(int n, int[][] edges, int[] values, int k) {
    if (n == 1)
      return 1;
    boolean visited[] = new boolean[n];
    Map<Integer, List<Integer>> adj = new HashMap<>();
    for (int[] e : edges) {
      if (adj.containsKey(e[0]))
        adj.get(e[0]).add(e[1]);
      else
        adj.put(e[0], new ArrayList<>(Arrays.asList(e[1])));
      if (adj.containsKey(e[1]))
        adj.get(e[1]).add(e[0]);
      else
        adj.put(e[1], new ArrayList<>(Arrays.asList(e[0])));
    }
    int ans[] = new int[1];
    int res = dfs(adj, visited, values, ans, k, 0);
    return ans[0] + (res % k == 0 ? 1 : 0);
  }

  static private int dfs(Map<Integer, List<Integer>> adj, boolean visited[], int[] val, int[] ans, int k, int root) {
    visited[root] = true;
    List<Integer> neighbour = adj.get(root);
    int size = neighbour.size();
    int tmp;
    int res = 0;
    for (int n : neighbour) {
      if (visited[n]) {
        size--;
        continue;
      }
      tmp = dfs(adj, visited, val, ans, k, n) % k;
      if (tmp == 0)
        ans[0]++;
      else
        res += tmp;
    }
    if (size == 0)
      return val[root];
    return (res + val[root]) % k;
  }

  public static void main(String[] args) {
    int n = 7;
    int[][] edges = { { 0, 1 }, { 0, 2 }, { 1, 3 }, { 1, 4 }, { 2, 5 }, { 2, 6 } };
    int[] values = { 3, 0, 6, 1, 5, 2, 1 };
    int k = 3;
    System.out.println(maxKDivisibleComponents(n, edges, values, k));
  }
}
