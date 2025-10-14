import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class lc3349 {
  private static boolean subarray(List<Integer> nums, int i, int k) {
    int l = nums.size();
    if (l < i + k)
      return false;
    int tmp = i + k - 1;
    for (; i < tmp; i++) {
      if (nums.get(i + 1) <= nums.get(i))
        return false;
    }
    return true;
  }

  private static boolean hasIncreasingSubarrays(List<Integer> nums, int k) {
    if (k == 1)
      return true;
    Set<Integer> memo = new HashSet<>();
    int l = nums.size();
    for (int i = 0, n = l - k; i <= n; i++)
      if (subarray(nums, i, k))
        memo.add(i);
    for (int n : memo)
      if (memo.contains(n + k))
        return true;
    return false;
  }

  public boolean hasIncreasingSubarrays1(List<Integer> nums, int k) {
    Map<Integer, Integer> map = new HashMap<>();
    int l = nums.size();
    int lp = 0, rp = 0;
    int target = k * 2;
    int start, end;
    while (lp < l) {
      rp = lp + 1;
      // move rp
      while (rp < l && nums.get(rp) > nums.get(rp - 1))
        rp++;
      map.put(lp, rp);
      lp = rp;
    }
    for (Map.Entry<Integer, Integer> entry : map.entrySet()) {
      start = entry.getKey();
      end = entry.getValue();
      if (end - start < k)
        continue;
      if (end - start >= target)
        return true;
      if (map.containsKey(end) && map.get(end) - end >= k)
        return true;
    }
    return false;
  }

  public static void main(String[] args) {
    int[] nums = { 5, 8, -2, -1 };
    List<Integer> l = new ArrayList<>();
    for (int n : nums)
      l.add(n);
    int k = 2;
    System.out.println(hasIncreasingSubarrays(l, k));
  }

}
