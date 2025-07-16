import java.util.HashMap;
import java.util.Map;

public class lc781 {
  public int numRabbits(int[] answers) {
    Map<Integer, Integer> map = new HashMap<>();
    int ans = 0;
    for (int a : answers) {
      map.computeIfPresent(a, (k, v) -> v + 1);
      map.computeIfAbsent(a, k -> 1);
    }
    int key, val;
    for (Map.Entry<Integer, Integer> entry : map.entrySet()) {
      key = entry.getKey();
      val = entry.getValue();
      if (val == 0) {
        ans++;
        continue;
      }
      ans += (val / (key + 1)) * (key + 1);
      ans += val % (key + 1) != 0 ? key + 1 : 0;
    }
    return ans;
  }
}
