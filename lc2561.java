import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class lc2561 {
  public long minCost(int[] basket1, int[] basket2) {
    Set<Integer> set = new HashSet<>();
    Map<Integer, Integer> map1 = new HashMap<>();
    Map<Integer, Integer> map2 = new HashMap<>();
    int l = basket1.length;
    long ans = 0;
    int tmp;
    int min = basket1[0];
    List<Integer> list = new ArrayList<>();
    for (int i = 0; i < l; i++) {
      set.add(basket1[i]);
      set.add(basket2[i]);
      map1.computeIfPresent(basket1[i], (k, v) -> v + 1);
      map1.computeIfAbsent(basket1[i], (k) -> 1);
      map2.computeIfPresent(basket2[i], (k, v) -> v + 1);
      map2.computeIfAbsent(basket2[i], (k) -> 1);
      min = Math.min(min, basket1[i]);
      min = Math.min(min, basket2[i]);
    }
    for (int s : set) {
      tmp = map1.getOrDefault(s, 0) + map2.getOrDefault(s, 0);
      if (tmp % 2 == 1)
        return -1;
      if (map1.getOrDefault(s, 0) == map2.getOrDefault(s, 0))
        continue;
      tmp = Math.abs(map1.getOrDefault(s, 0) - map2.getOrDefault(s, 0));
      for (int i = 0, n = tmp / 2; i < n; i++)
        list.add(s);
    }
    tmp = list.size();
    Collections.sort(list);
    if (tmp % 2 == 0) {
      for (int i = 0, n = tmp / 2, m = min * 2; i < n; i++)
        ans += Math.min(m, list.get(i));
    } else {
      for (int i = 0, n = tmp / 2 + 1, m = min * 2; i < n; i++)
        ans += Math.min(m, list.get(i));
    }
    return ans;
  }
}
