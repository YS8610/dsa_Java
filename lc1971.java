import java.util.ArrayList;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.List;
import java.util.Queue;
import java.util.Set;

public class lc1971 {

  private static boolean validPath(
    int n,
    int[][] edges,
    int source,
    int destination
  ) {
    List<Set<Integer>> map = new ArrayList<>(n);
    Set<Integer> visited = new HashSet<>();
    Queue<Integer> q = new LinkedList<>();
    int tmp;
    for (int i = 0; i < n; i++) map.add(new HashSet<>());
    for (int[] e : edges) {
      map.get(e[0]).add(e[1]);
      map.get(e[1]).add(e[0]);
    }
    q.add(source);
    while (!q.isEmpty()) {
      tmp = q.remove();
      if (tmp == destination) return true;
      if (visited.contains(tmp)) continue;
      visited.add(tmp);
      if (map.get(tmp).size() == 0) return false;
      q.addAll(map.get(tmp));
    }
    return false;
  }

  public static void main(String[] args) {
    int n = 3, source = 0, destination = 2;
    int[][] edges = { { 0, 1 }, { 1, 2 }, { 2, 0 } };
    System.out.println(validPath(n, edges, source, destination));
  }
}
