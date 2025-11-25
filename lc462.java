import java.util.Arrays;

public class lc462 {
  public int minMoves2(int[] nums) {
    int l = nums.length;
    Arrays.sort(nums);
    int tmp = nums[l / 2];
    int ans = 0;
    for (int n : nums)
      ans += Math.abs(tmp - n);
    // odd length
    if ((l & 1) > 0)
      return ans;
    // even length
    int ans1 = 0;
    tmp = nums[l / 2 - 1];
    for (int n : nums)
      ans1 += Math.abs(tmp - n);
    return Math.min(ans, ans1);
  }
}
