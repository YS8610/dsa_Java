public class lc1248 {
  private static int numberOfSubarrays(int[] nums, int k) {
    int ans = 0;
    int len = nums.length;
    int[] dp = new int[len];
    dp[0] = nums[0] & 1;
    for (int i =1; i<len;i++){
      dp[i] = dp[i-1] + (nums[i] & 1);
    }
    

    return ans;
  }

  public static void main(String[] args) {
    int[] nums = {1,1,2,1,1};
    int k = 3;
    System.out.println(numberOfSubarrays(nums, k));
  }
}
