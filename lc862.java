public class lc862 {
  private static int shortestSubarray(int[] nums, int k) {
    int l = nums.length;
    int[] dp = new int[l];
    int ans = l+1;
    if (nums[0] <0) dp[0] = -1;
    else dp[0] = nums[0];
    for (int i =1;i<l;i++){
      if (nums[i] <0){
        if (nums[i-1] >=0) dp[i] = nums[i];
        else dp[i] = dp[i-1]+ nums[i];
        continue;
      }
      dp[i] = (dp[i-1] >=0?dp[i-1]:0) + nums[i];
    }

    if (nums[0] >=0){
      for (int i =0; i<l && nums[i] >=0;i++){
        if (dp[i] >= k) {
          ans = Math.min(ans, i+1);
          if (ans==1) return 1;
        }
      }
    }
    for (int i=0, lp =0;i<l;i++){
      if (dp[i]==-1) lp=i;
      if (dp[i] >= k) ans = Math.min(ans, i-lp==0?1:i-lp);
    }
    return ans == l+1?-1:ans;
  }

  public static void main(String[] args) {
    int[] nums = {3,-1,2,5,6,9,-5,-6,1,-1,2};
    int k = 3;
    System.out.println(shortestSubarray(nums, k));
  }
}
