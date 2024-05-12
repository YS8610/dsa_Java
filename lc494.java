import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class lc494 {

  private static int dfs(
    int[] nums,
    int target,
    int i,
    int ans,
    int sum,
    Map<List<Integer>, Integer> dp
  ) {
    if (target == sum && i == nums.length) return ans + 1;
    if (i >= nums.length) return 0;
    if (dp.containsKey(List.of(i, sum))) return dp.get(List.of(i, sum));
    dp.put(
      List.of(i, sum),
      dfs(nums, target, i + 1, ans, sum - nums[i], dp) +
      dfs(nums, target, i + 1, ans, sum + nums[i], dp)
    );
    return dp.get(List.of(i, sum));
  }

  private static int findTargetSumWays(int[] nums, int target) {
    Map<List<Integer>, Integer> dp = new HashMap<>();
    return dfs(nums, target, 0, 0, 0, dp);
  }

  public static void main(String[] args) {
    int[] nums = { 1, 2, 3, 4, 5, 6, 7, 8, 9, 10, 1, 10, 3, 14, 15, 16, 17, 28, 29, 30};
    int target = 16;
    System.out.println(findTargetSumWays(nums, target));
  }
}
