import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class lc3350 {
  public int maxIncreasingSubarrays(List<Integer> nums) {
    Map<Integer, Integer> map = new HashMap<>();
    int l = nums.size();
    int lp = 0, rp = 0;
    int start, end;
    int ans = 1;
    while (lp < l) {
      rp = lp + 1;
      // move rp
      while (rp < l && nums.get(rp) > nums.get(rp - 1))
        rp++;
      if (rp - lp > 1)
        map.put(lp, rp);
      lp = rp;
    }
    for (Map.Entry<Integer, Integer> entry : map.entrySet()) {
      start = entry.getKey();
      end = entry.getValue();
      ans = Math.max((end - start) / 2, ans);
      if (map.containsKey(end))
        ans = Math.max(ans, Math.min(end - start, map.get(end) - end));
    }
    return ans;
  }
}
