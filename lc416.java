import java.util.Arrays;

public class lc416 {

  private static boolean dfs(int[] nums, int i, int target, int[][] memo) {
    if (target == 0) return true;
    if (target < 0) return false;
    if (i >= nums.length) return false;
    if (memo[i][target] != 0) return memo[i][target] == 1 ? true : false;
    boolean ans =
      dfs(nums, i + 1, target, memo) ||
      dfs(nums, i + 1, target - nums[i], memo);
    memo[i][target] = ans ? 1 : -1;
    return ans;
  }

  public boolean canPartition(int[] nums) {
    int sum = 0;
    for (int n : nums) sum += n;
    if ((sum & 1) == 1) return false;
    int mid = sum / 2;
    Arrays.sort(nums);
    if (nums[nums.length - 1] > mid) return false;
    return dfs(nums, 0, mid, new int[nums.length][mid + 1]);
  }
}
