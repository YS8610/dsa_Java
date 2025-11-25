import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class lc3347 {
  public int maxFrequency(int[] nums, int k, int numOperations) {
    Map<Integer, Integer> map = new HashMap<>();
    for (int n : nums)
      map.put(n, map.getOrDefault(n, 0) + 1);
    int l = map.size();
    if (l == 1)
      return map.get(nums[0]);
    int[] nn = new int[l];
    int j = 0;
    for (Map.Entry<Integer, Integer> entry : map.entrySet())
      nn[j++] = entry.getKey();
    Arrays.sort(nn);
    int lp = 0, rp = 0;
    int sum = 0;
    int ans = 0;
    // single k size window
    for (int i = 0; i < l; i++) {
      while (lp < i && nn[lp] < nn[i] - k) {
        sum -= map.get(nn[lp]);
        lp++;
      }
      while (rp < l && nn[rp] <= nn[i] + k) {
        sum += map.get(nn[rp]);
        rp++;
      }
      ans = Math.max(ans, Math.min(sum - map.get(nn[i]), numOperations) + map.get(nn[i]));
    }
    if (numOperations == 1)
      return ans;
    // double k size window
    long k2 = k * 2L;
    lp = 0;
    sum = map.get(nn[lp]);
    for (int i = 1; i < l; i++) {
      sum += map.get(nn[i]);
      while (lp < i && nn[lp] < nn[i] - k2) {
        sum -= map.get(nn[lp]);
        lp++;
      }
      ans = Math.max(ans, Math.min(sum, numOperations));
    }
    return ans;
  }
}
