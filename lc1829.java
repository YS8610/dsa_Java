import java.util.Arrays;

public class lc1829 {

  private static int[] getMaximumXor(int[] nums, int maximumBit) {
    int l = nums.length;
    int[] dp = new int[l];
    int[] masks = new int[maximumBit];
    int tmp = 1;
    int sum = 0;
    int[] ans = new int[l];
    for (int i = 0; i < maximumBit; i++) {
      masks[i] = tmp;
      sum += tmp;
      tmp <<= 1;
    }
    dp[0] = nums[0];
    for (int i = 1; i < l; i++) dp[i] = dp[i - 1] ^ nums[i];
    tmp = Math.max(sum, nums[l - 1]);
    for (int i = 0; i < l; i++) {
      ans[i] = dp[l - 1 - i] ^ tmp;
    }
    return ans;
  }

  public static void main(String[] args) {
    int[] nums = {0,1,1,3};
    int maximumBit = 2;
    System.out.println(Arrays.toString(getMaximumXor(nums, maximumBit)));
  }
}
