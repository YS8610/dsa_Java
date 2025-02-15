class lc3105 {

  private static int longestMonotonicSubarray(int[] nums) {
    int l = nums.length;
    int ans = 0;
    int lp = 0;
    int rp = 0;
    while (lp < l) {
      rp = 1;
      while (lp + rp < l) {
        // increasing
        if (nums[lp + rp - 1] < nums[lp + rp])
          rp++;
        else
          break;
      }
      ans = Math.max(ans, rp);
      lp += rp;
    }
    lp = 0;
    while (lp < l) {
      rp = 1;
      while (lp + rp < l) {
        // decreasing
        if (nums[lp + rp - 1] > nums[lp + rp])
          rp++;
        else
          break;
      }
      ans = Math.max(ans, rp);
      lp += rp;
    }
    return ans;
  }

  public static void main(String[] args) {
    int[] nums = { 1, 4, 3, 3, 2 };
    System.out.println(longestMonotonicSubarray(nums));
  }
}
