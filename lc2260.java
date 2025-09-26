import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class lc2260 {
  public int minimumCardPickup(int[] cards) {
    int l = cards.length;
    Map<Integer, List<Integer>> map = new HashMap<>();
    int ans = l + 1;
    for (int i = 0; i < l; i++) {
      if (!map.containsKey(cards[i])) {
        List<Integer> list = new ArrayList<>();
        list.add(i);
        map.put(cards[i], list);
        continue;
      }
      map.get(cards[i]).add(i);
    }
    for (Map.Entry<Integer, List<Integer>> entry : map.entrySet()) {
      l = entry.getValue().size();
      if (l == 1)
        continue;
      for (int i = 0, n = l - 1; i < n; i++)
        ans = Math.min(ans, entry.getValue().get(i + 1) - entry.getValue().get(i) + 1);
    }
    return ans == cards.length + 1 ? -1 : ans;
  }
}
