import java.util.HashMap;
import java.util.Map;

public class lc904 {
  public int totalFruit(int[] fruits) {
    Map<Integer, Integer> map = new HashMap<>();
    int lp = 0;
    int rp = 0;
    int l = fruits.length;
    int ans = 0;
    while (lp < l) {
      // move rp
      if (lp == rp || map.size() <= 2) {
        while (rp < l && map.size() <= 2) {
          map.computeIfPresent(fruits[rp], (k, v) -> v + 1);
          map.computeIfAbsent(fruits[rp], (k) -> 1);
          rp++;
          if (map.size() <= 2)
            ans = Math.max(ans, rp - lp);
        }
      }
      // move lp
      map.computeIfPresent(fruits[lp], (k, v) -> v - 1);
      if (map.get(fruits[lp]) == 0)
        map.remove(fruits[lp]);
      lp++;
    }
    return ans;
  }
}
