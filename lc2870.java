import java.util.HashMap;
import java.util.Map;

public class lc2870 {

  private static int minOperations(int[] nums) {
    Map<Integer, Integer> map = new HashMap<>();
    int maxNo = 0;
    int ans = 0;
    for (int num : nums) {
      if (map.containsKey(num)) map.put(num, map.get(num) + 1); else map.put(
        num,
        1
      );
    }
    for (int k : map.keySet()) {
      if (map.get(k) == 1) return -1;
      maxNo = Math.max(maxNo, map.get(k));
    }
    maxNo = Math.max(maxNo, 4);
    int[] dp = new int[maxNo + 1];
    dp[0] = 0;
    dp[1] = -1;
    dp[2] = 1;
    dp[3] = 1;
    dp[4] = 2;
    for (int i = 5; i <= maxNo; i++) {
      dp[i] = Math.min(dp[i - 2], dp[i - 3]) + 1;
    }
    for (int k : map.keySet()) {
      ans += dp[map.get(k)];
    }
    return ans;
  }

  public static void main(String[] args) {
    int[] nums = {2,3,3,2,2,4,2,3,4};
    System.out.println(minOperations(nums));
  }
}
