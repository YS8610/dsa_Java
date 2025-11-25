import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class lc2597 {
  static int ans = 0;

  private static void dfs(int[] nums, int k, int i, Map<Integer, Integer> sl) {
    if (i >= nums.length)
      return;
    if (sl.isEmpty()) {
      sl.put(nums[i], 1);
      ans++;
    } else {
      if (!sl.containsKey(nums[i] + k) && !sl.containsKey(nums[i] - k)) {
        ans++;
        if (sl.containsKey(nums[i]))
          sl.put(nums[i], sl.get(nums[i]) + 1);
        else
          sl.put(nums[i], 1);
      } else
        return;
    }
    dfs(nums, k, i + 1, sl);
    sl.put(nums[i], sl.get(nums[i]) - 1);
    if (sl.get(nums[i]) == 0)
      sl.remove(nums[i]);
    dfs(nums, k, i + 1, sl);
  }

  private static int beautifulSubsets(int[] nums, int k) {
    Arrays.sort(nums);
    dfs(nums, k, 0, new HashMap<>());
    return ans;
  }

  public static void main(String[] args) {
    int[] nums = { 2, 4, 6 };
    int k = 2;
    System.out.println(beautifulSubsets(nums, k));
  }
}
