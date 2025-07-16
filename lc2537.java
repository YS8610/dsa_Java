import java.util.HashMap;
import java.util.Map;

public class lc2537 {
  public long countGood(int[] nums, int k) {
    int l = nums.length;
    long ans = 0;
    Map<Integer, Integer> map = new HashMap<>();
    int rp = 0;
    int good = 0;
    for (int i = 0; i < l; i++) {
      if (i != 0) {
        good -= map.get(nums[i - 1]) - 1;
        map.put(nums[i - 1], map.get(nums[i - 1]) - 1);
      }
      if (rp >= l) {
        ans += good >= k ? 1 : 0;
        continue;
      }
      if (good >= k) {
        ans += l - rp;
        continue;
      } else if (i != 0 && good < k)
        rp++;
      while (good < k && rp < l) {
        map.computeIfPresent(nums[rp], (key, v) -> v + 1);
        map.computeIfAbsent(nums[rp], (key) -> 1);
        if (map.get(nums[rp]) > 1)
          good += map.get(nums[rp]) - 1;
        if (good >= k) {
          ans += l - rp;
          break;
        }
        rp++;
      }
    }
    return ans;
  }
}
