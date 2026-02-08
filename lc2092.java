import java.util.List;
import java.util.Arrays;
import java.util.ArrayList;
import java.util.Map;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Set;

public class lc2092 {
  public List<Integer> findAllPeople(int n, int[][] meetings, int firstPerson) {
    int l = meetings.length;
    Arrays.sort(meetings, (m1, m2) -> Integer.compare(m1[2], m2[2]));
    boolean[] set = new boolean[n];
    set[0] = true;
    set[firstPerson] = true;
    List<int[]> sameTime = new ArrayList<>();
    for (int i = 0; i < l; i++) {
      if (sameTime.isEmpty() || sameTime.get(0)[2] == meetings[i][2]) {
        sameTime.add(meetings[i]);
        continue;
      }
      processSameTime(set, sameTime);
      sameTime.clear();
      sameTime.add(meetings[i]);
    }
    processSameTime(set, sameTime);
    List<Integer> ans = new ArrayList<>();
    for (int i = 0; i < n; i++)
      if (set[i])
        ans.add(i);
    return ans;
  }

  static private void processSameTime(boolean[] set, List<int[]> sameTime) {
    if (sameTime.isEmpty())
      return;
    Map<Integer, Set<Integer>> adj = new HashMap<>();
    Set<Integer> visited = new HashSet<>();
    boolean knowSecret = false;
    for (int[] m : sameTime) {
      adj.computeIfAbsent(m[0], (k) -> new HashSet<>()).add(m[1]);
      adj.computeIfAbsent(m[1], (k) -> new HashSet<>()).add(m[0]);
      if (set[m[0]] || set[m[1]])
        knowSecret = true;
    }
    if (!knowSecret)
      return;
    for (var node : adj.entrySet()) {
      if (!set[node.getKey()])
        continue;
      dfs(set, adj, visited, node.getKey());
    }
  }

  static private void dfs(boolean[] set, Map<Integer, Set<Integer>> adj, Set<Integer> visited, int ppl) {
    if (visited.contains(ppl))
      return;
    visited.add(ppl);
    for (int a : adj.get(ppl)) {
      set[a] = true;
      dfs(set, adj, visited, a);
    }
  }
}
