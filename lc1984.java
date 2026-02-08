import java.util.Arrays;

public class lc1984 {
  public int minimumDifference(int[] nums, int k) {
    if (k == 1)
      return 0;
    int l = nums.length;
    int ans = Integer.MAX_VALUE;
    Arrays.sort(nums);
    for (int i = k - 1; i < l; i++)
      ans = Math.min(ans, nums[i] - nums[i - k + 1]);
    return ans;
  }
}
