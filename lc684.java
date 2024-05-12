import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.Set;

public class lc684 {

  private static int[] findRedundantConnection(int[][] edges) {
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

  public static void main(String[] args) {
    int[][] edges = {{1,2},{2,3},{3,4},{1,4},{1,5}};
    System.out.println(Arrays.toString(findRedundantConnection(edges)));
  }
}
