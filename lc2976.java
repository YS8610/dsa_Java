import java.util.Arrays;
import java.util.PriorityQueue;

public class lc2976 {
  static public long minimumCost(String source, String target, char[] original, char[] changed, int[] cost) {
    int l = source.length();
    boolean[][] adj = new boolean[26][26];
    int[][] weight = new int[26][26];
    int[][] tcost = new int[26][26];
    for (int[] t : tcost)
      Arrays.fill(t, Integer.MAX_VALUE);
    boolean[] visited = new boolean[26];
    PriorityQueue<int[]> q = new PriorityQueue<>((m1, m2) -> Integer.compare(m1[1], m2[1]));
    for (int i = 0, u = 0, v = 0, n = changed.length; i < n; i++) {
      u = original[i] - 'a';
      v = changed[i] - 'a';
      adj[u][v] = true;
      weight[u][v] = weight[u][v] == 0 ? cost[i] : Math.min(cost[i], weight[u][v]);
    }
    int[] top;
    int amt;
    for (int i = 0; i < 26; i++) {
      Arrays.fill(visited, false);
      q.clear();
      // character, cost
      q.add(new int[] { i, 0 });
      tcost[i][i] = 0;
      while (!q.isEmpty()) {
        top = q.poll();
        if (visited[top[0]])
          continue;
        visited[top[0]] = true;
        for (int j = 0; j < 26; j++) {
          if (!adj[top[0]][j])
            continue;
          amt = weight[top[0]][j] + top[1];
          if (tcost[i][j] > amt) {
            tcost[i][j] = amt;
            q.add(new int[] { j, amt });
          }
        }
      }
    }
    // System.out.println(Arrays.deepToString(tcost));
    long ans = 0l;
    for (int i = 0; i < l; i++) {
      if (source.charAt(i) == target.charAt(i))
        continue;
      if (tcost[source.charAt(i) - 'a'][target.charAt(i) - 'a'] == Integer.MAX_VALUE)
        return -1;
      ans += tcost[source.charAt(i) - 'a'][target.charAt(i) - 'a'];
    }
    return ans;
  }

  public static void main(String[] args) {
    String source = "abcd", target = "acbe";
    char[] original = { 'a', 'b', 'c', 'c', 'e', 'd' }, changed = { 'b', 'c', 'b', 'e', 'b', 'e' };
    int[] cost = { 2, 5, 5, 1, 2, 20 };
    System.out.println(minimumCost(source, target, original, changed, cost));
  }
}
