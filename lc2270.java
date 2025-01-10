class lc2270{
  private static int waysToSplitArray(int[] nums) {
    int l = nums.length;
    long[] dp = new long[l];
    int ans = 0;
    dp[0] = nums[0];
    for (int i =1; i<l;i++)
      dp[i] = dp[i-1] + nums[i];
    for (int i =0, n=l-1; i<n;i++)
      if (dp[i] >= dp[l-1] - dp[i])
        ans++;
    return ans;
  }

  public static void main(String[] args){
    int[] nums = {2,3,1,0};
    System.out.println(waysToSplitArray(nums));
  }
}
