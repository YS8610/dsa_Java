class lc930 {
  private static int numSubarraysWithSum(int[] nums, int goal) {
    return subarray(nums, goal) - subarray(nums, goal - 1);
  }

  static public int subarray(int[] nums, int target) {
    int l = nums.length;
    int lp = 0, rp = 0;
    int ans = 0;
    int sum = 0;
    while (rp < l) {
      sum += nums[rp];
      while (lp < rp && sum > target)
        sum -= nums[lp++];
      ans += sum <= target ? rp - lp + 1 : 0;
      rp++;
    }
    return ans;
  }

  public static void main(String[] args) {
    int[] nums = { 1, 0, 1 };
    int goal = 2;
    System.out.println(numSubarraysWithSum(nums, goal));
  }
}