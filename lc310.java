import java.util.ArrayList;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.Set;

public class lc310 {

  private static int dfs(int n, List<Set<Integer>> map, int count, int[] visited) {
    int ans = 0;
    boolean allVisited = true;
    Set<Integer> l = map.get(n);
    visited[n] = 1;
    count++;
    for (int i : l) {
      if (visited[i] == 1) continue;
      allVisited = false;
      ans = Math.max(ans, dfs(i, map, count, visited));
    }
    if (allVisited) return count;
    return ans;
  }

  private static List<Integer> findMinHeightTrees(int n, int[][] edges) {
    List<Set<Integer>> map = new ArrayList<>(n);
    int[] a = new int[n];
    List<Integer> ans = new ArrayList<>();
    int low = n;
    for (int i = 0; i < n; i++) map.add(new HashSet<>());
    for (int[] edge : edges) {
      map.get(edge[0]).add(edge[1]);
      map.get(edge[1]).add(edge[0]);
    }
    for (int i = 0; i < n; i++) {
      if (map.get(i).size() == 1){
        a[i] = n;
        continue;
      }
      a[i] = dfs(i, map, 0, new int[n]);
      low = Math.min(low, a[i]);
    }
    for (int i = 0; i < n; i++) if (a[i] == low) ans.add(i);
    return ans;
  }

  private static List<Integer> findMinHeightTrees1(int n, int[][] edges) {
    List<Set<Integer>> map = new ArrayList<>(n);
    int[] branch = new int[n];
    Set<Integer> ans = new HashSet<>(n);
    int tmp;
    for (int i=0;i<n;i++) ans.add(i);
    for (int i=0;i<n;i++) map.add(new HashSet<>());
    for (int[] edge:edges) {
      map.get(edge[0]).add(edge[1]);
      map.get(edge[1]).add(edge[0]);
    }
    Queue<Integer> q = new LinkedList<>();
    for (int i=0;i<n;i++) {
      branch[i] = map.get(i).size();
      if (branch[i] == 1) q.add(i);
    }
    while (ans.size()>2){
      for(int i=0,m=q.size();i<m;i++){
        tmp = q.remove();
        branch[tmp]--;
        for (int a : map.get(tmp)) {
          branch[a]--;
          if (branch[a] == 1) q.add(a);
        }
        if (branch[tmp]==0) ans.remove(tmp);
      }
    }
    return new ArrayList<>(ans);
  }

  public static void main(String[] args) {
    int n = 6;
    int[][] edges = {{3,0},{3,1},{3,2},{3,4},{5,4}};
    System.out.println(findMinHeightTrees(n, edges));
    System.out.println(findMinHeightTrees1(n, edges));
  }
}
