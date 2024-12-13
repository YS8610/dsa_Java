import java.util.Arrays;

public class lc2779 {

  public int maximumBeauty(int[] nums, int k) {
    Arrays.sort(nums);
    int l = nums.length;
    int lp = 0;
    int rp = 0;
    int ans = 1;
    while (lp < l && rp < l) {
      while (rp < l && nums[rp] - nums[lp] <= 2 * k) rp++;
      ans = Math.max(ans, rp - lp);
      if (rp == l - 1) break;
      lp++;
    }
    return ans;
  }
}
