import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.Set;

public class lc684 {

  private static int[] findRedundantConnection1(int[][] edges) {
    int n = edges.length;
    List<Set<Integer>> map = new ArrayList<>(n);
    int tmp;
    for (int i = 0; i < n; i++) map.add(new HashSet<>());
    for (int[] e : edges) {
      map.get(e[0] - 1).add(e[1] - 1);
      map.get(e[1] - 1).add(e[0] - 1);
    }
    int[] branch = new int[n];
    Queue<Integer> q = new LinkedList<>();
    for (int i = 0; i < n; i++) {
      branch[i] = map.get(i).size();
      if (branch[i] == 1) q.add(i);
    }
    while (!q.isEmpty()) {
      for (int i = 0, m = q.size(); i < m; i++) {
        tmp = q.remove();
        branch[tmp]--;
        for (int a : map.get(tmp)) {
          branch[a]--;
          if (branch[a] == 1) q.add(a);
        }
      }
    }
    for (int i = edges.length - 1; i >= 0; i--) {
      if (
        branch[edges[i][0] - 1] == 2 && branch[edges[i][1] - 1] == 2
      ) return edges[i];
    }
    return new int[2];
  }
  // #dsu
  private static int[] findRedundantConnection(int[][] edges){
    int l = edges.length;
    int[] map = new int[l+1];
    Arrays.fill(map, -1);
    for (int[] e :edges){
      if (find(map,e[0])==find(map,e[1]))
        return e;
      union(map, e);
    }
    return null;
  }

  private static void union(int[] map, int[] e){
    int p0 = find(map, e[0]);
    int p1 = find(map, e[1]);
    // cycle detected
    if (p0 == p1 && p0 >= 0) return;
    // both are parent
    if (map[p0] <0 && map[p1] <0){
      // same rank or p0 higher rank
      if (map[p0] == map[p1] || map[p0] < map[p1]){
        map[p0] = map[p0] + map[p1];
        map[p1] = p0;
        return;
      }
      // p1 higher rank
      map[p1] = map[p0] + map[p1];
      map[p0] = p1;
      return;
    }
    map[e[1]] = p0;
  }

  private static int find(int[] map, int node){
    if (map[node] < 0) return node;
    return find(map, map[node]);
  }

  public static void main(String[] args) {
    int[][] edges = {{1,5},{2,4},{3,4},{1,3},{3,5}};
    System.out.println(Arrays.toString(findRedundantConnection1(edges)));
    System.out.println(Arrays.toString(findRedundantConnection(edges)));
  }
}
