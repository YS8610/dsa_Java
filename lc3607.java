import java.util.ArrayDeque;
import java.util.Arrays;
import java.util.Deque;
import java.util.HashMap;
import java.util.Map;

public class lc3607 {
  public int[] processQueries(int c, int[][] connections, int[][] queries) {
    int[] par = new int[c + 1];
    boolean[] closed = new boolean[c + 1];
    Arrays.fill(par, -1);
    int p1, p2;
    for (int[] conn : connections) {
      p1 = findp(par, conn[0]);
      p2 = findp(par, conn[1]);
      if (p1 == p2)
        continue;
      par[p1] += par[p2];
      par[p2] = p1;
    }
    // path compression
    for (int i = 1; i <= c; i++) {
      if (par[i] < 0)
        continue;
      par[i] = findp(par, i);
    }
    Map<Integer, Deque<Integer>> map = new HashMap<>();
    for (int i = 1; i <= c; i++) {
      if (par[i] >= 0)
        continue;
      map.put(i, new ArrayDeque<>());
      // map.get(i).add(i);
    }
    for (int i = 1; i <= c; i++) {
      if (par[i] < 0) {
        map.get(i).add(i);
        continue;
      }
      map.get(par[i]).add(i);
    }
    // System.out.println(Arrays.toString(par));
    // System.out.println(map.toString());
    int len = 0;
    for (int[] q : queries)
      len += q[0] == 1 ? 1 : 0;
    int[] ans = new int[len];
    int pos = 0;
    for (int[] q : queries) {
      if (q[0] == 2) {
        closed[q[1]] = true;
        continue;
      }
      if (!closed[q[1]]) {
        ans[pos++] = q[1];
        continue;
      }
      p1 = par[q[1]] < 0 ? q[1] : par[q[1]];
      while (!map.get(p1).isEmpty() && closed[map.get(p1).peekFirst()])
        map.get(p1).pollFirst();
      ans[pos++] = map.get(p1).isEmpty() ? -1 : map.get(p1).peekFirst();
    }
    return ans;
  }

  public int findp(int[] par, int i) {
    if (par[i] < 0)
      return i;
    return findp(par, par[i]);
  }
}
