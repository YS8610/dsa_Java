import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.Optional;
import java.util.TreeMap;

public class lc2054 {
  private static int maxTwoEvents(int[][] events) {
    Map<Integer, Integer> map = new HashMap<>();
    int singleMax = events[0][2];
    for (int[] e : events) {
      singleMax = Math.max(singleMax, e[2]);
      if (map.containsKey(e[0])) {
        if (map.get(e[0]) < e[2])
          map.put(e[0], e[2]);
        continue;
      }
      map.put(e[0], e[2]);
    }
    int[][] prefixedmax = new int[map.size()][2];
    int count = 0;
    for (Map.Entry<Integer, Integer> entry : map.entrySet()) {
      prefixedmax[count][0] = entry.getKey();
      prefixedmax[count++][1] = entry.getValue();
    }
    Arrays.sort(prefixedmax, (m1, m2) -> Integer.compare(m1[0], m2[0]));
    TreeMap<Integer, Integer> treemap = new TreeMap<>();
    treemap.put(prefixedmax[prefixedmax.length - 1][0], prefixedmax[prefixedmax.length - 1][1]);
    int max = prefixedmax[prefixedmax.length - 1][1];
    for (int i = prefixedmax.length - 2; i >= 0; i--) {
      max = Math.max(max, prefixedmax[i][1]);
      treemap.put(prefixedmax[i][0], max);
    }
    int ans = 0;
    Optional<Map.Entry<Integer, Integer>> tmp;
    int sum = 0;
    for (int[] e : events) {
      tmp = Optional.ofNullable(treemap.higherEntry(e[1]));
      sum = (tmp.isPresent() ? tmp.get().getValue() : 0) + e[2];
      ans = Math.max(ans, sum);
    }
    return Math.max(ans, singleMax);
  }

  public int maxTwoEvents1(int[][] events) {
    int l = events.length;
    Arrays.sort(events, (m1, m2) -> {
      if (m1[0] == m2[0])
        return Integer.compare(m1[2], m2[2]);
      return Integer.compare(m1[0], m2[0]);
    });
    int ans = 0;
    int[] prefix = new int[l];
    int latest = events[l - 1][0];
    prefix[l - 1] = events[l - 1][2];
    for (int i = l - 2; i >= 0; i--)
      prefix[i] = Math.max(events[i][2], prefix[i + 1]);
    for (int i = 0, pos = 0; i < l; i++) {
      if (events[i][1] >= latest) {
        ans = Math.max(ans, events[i][2]);
        continue;
      }
      pos = bs(events, events[i][1]);
      ans = Math.max(ans, prefix[pos] + events[i][2]);
    }
    return ans;
  }

  static private int bs(int[][] events, int key) {
    int l = events.length;
    int lp = 0;
    int rp = l - 1;
    int mp;
    while (lp < rp) {
      mp = (lp + rp) / 2;
      if (events[mp][0] <= key)
        lp = mp + 1;
      else
        rp = mp;
    }
    return lp;
  }

  public static void main(String[] args) {
    int[][] events = { { 1, 5, 3 }, { 1, 5, 1 }, { 6, 6, 5 } };
    System.out.println(maxTwoEvents(events));
  }
}
