public class lc1004 {
  public int longestOnes(int[] nums, int k) {
    int l = nums.length;
    int lp = 0, rp = 0;
    int ans = 0;
    int zero = 0;
    while (lp < l) {
      // move rp
      while (rp < l && zero <= k) {
        zero += nums[rp] == 0 ? 1 : 0;
        if (zero <= k)
          ans = Math.max(ans, rp - lp + 1);
        rp++;
      }
      // move lp
      zero -= nums[lp] == 0 ? 1 : 0;
      lp++;
    }
    return ans;
  }
}
