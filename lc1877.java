import java.util.Arrays;

public class lc1877 {
  public int minPairSum(int[] nums) {
    int l = nums.length;
    Arrays.sort(nums);
    int lp = 0, rp = l - 1;
    int ans = 0;
    while (lp < rp)
      ans = Math.max(ans, nums[lp++] + nums[rp--]);
    return ans;
  }
}
