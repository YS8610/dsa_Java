import java.util.HashMap;
import java.util.Map;

public class lc560 {
  private static int subarraySum(int[] nums, int k) {
    int n = nums.length;
    int[] dp = new int[n];
    dp[0] = nums[0];
    for (int i = 1; i < n; i++)
      dp[i] = dp[i - 1] + nums[i];
    int ans = 0;
    int rp;
    for (int i = 0; i < n; i++) {
      rp = n - 1;
      while (i <= rp) {
        if (i == 0) {
          if (dp[rp] == k)
            ans++;
        } else {
          if (dp[rp] - dp[i - 1] == k)
            ans++;
        }
        rp--;
      }
    }
    return ans;
  }

  public int subarraySum1(int[] nums, int k) {
    int l = nums.length;
    Map<Integer, Integer> map = new HashMap<>();
    map.put(0, 1);
    int ans = 0;
    for (int i = 0, tmp = 0; i < l; i++) {
      tmp += nums[i];
      ans += map.getOrDefault(tmp - k, 0);
      map.computeIfPresent(tmp, (key, v) -> v + 1);
      map.computeIfAbsent(tmp, (key) -> 1);
    }
    return ans;
  }

  public static void main(String[] args) {
    int[] nums = { 1, 2, 3 };
    int k = 3;
    System.out.println(subarraySum(nums, k));
  }
}
