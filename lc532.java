import java.util.HashMap;
import java.util.Map;

public class lc532 {
  public int findPairs(int[] nums, int k) {
    int big = Integer.MIN_VALUE;
    Map<Integer, Integer> map = new HashMap<>();
    int ans = 0;
    for (int n : nums) {
      big = Math.max(big, n);
      map.computeIfPresent(n, (key, v) -> v + 1);
      map.computeIfAbsent(n, (key) -> 1);
    }
    if (k == 0) {
      for (Map.Entry<Integer, Integer> entry : map.entrySet())
        ans += entry.getValue() >= 2 ? 1 : 0;
      return ans;
    }
    for (Map.Entry<Integer, Integer> entry : map.entrySet()) {
      if (entry.getKey() + k > big)
        continue;
      ans += map.containsKey(entry.getKey() + k) ? 1 : 0;
    }
    return ans;
  }
}
