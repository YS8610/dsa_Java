public class lc974 {
  private static int subarraysDivByK(int[] nums, int k) {
    int l = nums.length;
    int[] dp = new int[l];
    int ans = 0;
    dp[0] = nums[0];
    for (int i =1; i<l;i++) dp[i] = dp[i-1] + nums[i];
    for (int i =0;i<l;i++){
      for (int j = 0;i+j<l;j++){
        if (i == 0){
          if (dp[j] % k == 0) ans++;
        }
        else{
          if ((dp[i+j] - dp[i-1])%k==0) ans++;
        }
      }
    }
    return ans;
  }

  public static void main(String[] args) {
    int[] nums = {4,5,0,-2,-3,1};
    int k = 5;
    System.out.println(subarraysDivByK(nums, k));
  }
}
