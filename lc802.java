import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class lc802 {

  private static List<Integer> eventualSafeNodes(int[][] graph) {
    Set<Integer> ans = new HashSet<>();
    int n = graph.length;
    outloop:for (int i = 0; i < n; i++) {
      if (ans.contains(i)) continue;
      for (int j : graph[i]) {
        if (ans.contains(j)) continue;
        if (!helper(j, graph, new HashSet<>())) continue outloop;
      }
      ans.add(i);
    }
    int temp = 0;
    do {
      temp = ans.size();
      outerloop1:for (int i = 0; i < n; i++) {
        if (ans.contains(i)) continue;
        for (int j : graph[i]) {
          if (!ans.contains(j)) continue outerloop1;
        }
        ans.add(i);
      }
    } while (temp != ans.size());
    List<Integer> sorted = new ArrayList<>(ans);
    sorted.sort((m1,m2) -> m1.compareTo(m2));
    return sorted;
  }

  private static boolean helper( int index, int[][] graph, HashSet<Integer> visited) {
    if (graph[index].length == 0) return true;
    if (visited.contains(index)) return false;
    visited.add(index);
    for (int i : graph[index]) {
      if (!helper(i, graph, visited)) return false;
    }
    return true;
  }

  public static void main(String[] args) {
    int[][] graph = {
      { 4, 9 },
      { 3, 5, 7 },
      { 0, 3, 4, 5, 6, 8 },
      { 7, 8, 9 },
      { 5, 6, 7, 8 },
      { 6, 7, 8, 9 },
      { 7, 9 },
      { 8, 9 },
      { 9 },
      {},
    };
    System.out.println(eventualSafeNodes(graph).toString());
  }
}
