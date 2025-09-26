import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class lc1695 {
  static public int maximumUniqueSubarray(int[] nums) {
    int l = nums.length;
    Map<Integer, Integer> map = new HashMap<>();
    Set<Integer> set = new HashSet<>();
    int ans = 0;
    int lp = 0;
    int rp = 0;
    int sum = 0;
    while (lp < l) {
      // move rp
      while (rp < l && set.size() == rp - lp) {
        map.computeIfPresent(nums[rp], (k, v) -> v + 1);
        map.computeIfAbsent(nums[rp], (k) -> 1);
        set.add(nums[rp]);
        sum += nums[rp];
        if (set.size() == rp - lp + 1)
          ans = Math.max(ans, sum);
        rp++;
      }
      // move lp
      map.computeIfPresent(nums[lp], (k, v) -> v - 1);
      if (map.getOrDefault(nums[lp], 0) == 0)
        set.remove(nums[lp]);
      sum -= nums[lp];
      lp++;
    }
    return ans;
  }

  // dynamic sliding window
  public static void main(String[] args){
    int[] nums = {4,2,4,5,6};
    System.out.println(maximumUniqueSubarray(nums));
  }
}
