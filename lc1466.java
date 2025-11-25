import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class lc1466 {
  static public int minReorder(int n, int[][] connections) {
    Map<Integer, List<int[]>> adj = new HashMap<>();
    boolean[] visited = new boolean[n];
    int[] ans = new int[1];
    List<int[]> tmp;
    for (int[] c : connections) {
      tmp = adj.getOrDefault(c[0], new ArrayList<>());
      tmp.add(new int[] { c[1], 1 });
      adj.put(c[0], tmp);
      tmp = adj.getOrDefault(c[1], new ArrayList<>());
      tmp.add(new int[] { c[0], -1 });
      adj.put(c[1], tmp);
    }
    dfs(adj, ans, visited, 0);
    return ans[0];
  }

  static public void dfs(Map<Integer, List<int[]>> adj, int[] ans, boolean[] visited, int root) {
    if (visited[root])
      return;
    visited[root] = true;
    List<int[]> tmp = adj.getOrDefault(root, new ArrayList<>());
    for (int[] t : tmp) {
      ans[0] += t[1] == 1 && !visited[t[0]] ? 1 : 0;
      dfs(adj, ans, visited, t[0]);
    }
  }

  public static void main(String[] args){
    int n = 6;
    int[][] connections = {{0,1},{1,3},{2,3},{4,0},{4,5}};
    System.out.println(minReorder(n, connections));
  }
}