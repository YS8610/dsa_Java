import java.util.Arrays;

public class lc334 {

  private static boolean increasingTriplet(int[] nums) {
    int n1 = Integer.MAX_VALUE;
    int n2 = Integer.MAX_VALUE;
    for (int n : nums){
      if (n<n1){
        n1 = n;
        continue;
      }
      if (n > n2) return true;
      if (n>n1){
        n2 = n;
        continue;
      }
    }
    return false;
  }

  private static boolean increasingTriplet1(int[] nums) {
    int l = nums.length;
    int[][] dp = new int[l][l];
    for (int c = 0; c < l; c++) dp[0][c] = 1;
    for (int r = 1; r < l; r++) {
      for (int c = 0; c < l; c++) {
        if (r == c) {
          dp[r][c] = dp[r][c - 1];
          for (int i = 0; i < c; i++) {
            if (nums[i] < nums[r]) {
              dp[r][c] = Math.max(dp[r][c], dp[i][c - 1] + 1);
            }
          }
          if (dp[r][c]>=3) return true;
          continue;
        }
        if (r > c) dp[r][c] = 1;
        else dp[r][c] = dp[r][c-1];
      }
    }
    System.out.println(Arrays.deepToString(dp));
    return false;
  }

  public static void main(String[] args) {
    int[] nums = { 20,100,10,12,5,13};
    System.out.println(increasingTriplet(nums));
    System.out.println(increasingTriplet1(nums));
  }
}
