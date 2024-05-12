import java.util.Arrays;

public class lc238 {

  private static int[] productExceptSelf(int[] nums) {
    int len = nums.length;
    int[] forward = new int[len];
    int[] backward = new int[len];
    int[] ans = new int[len];
    forward[0] = nums[0];
    backward[len - 1] = nums[len - 1];
    for (int i = 1; i < len; i++) {
      forward[i] = forward[i - 1] * nums[i];
      backward[len - 1 - i] = backward[len - 1 - (i - 1)] * nums[len - 1 - i];
    }
    for (int i = 0; i < len; i++) {
      if (i == 0) {
        ans[0] = backward[1];
        continue;
      }
      if (i == len - 1) {
        ans[len - 1] = forward[len - 2];
        continue;
      }
      ans[i] = forward[i - 1] * backward[i + 1];
    }
    return ans;
  }

  public static void main(String[] args) {
    int[] nums = { 1, 2, 3, 4 };
    System.out.println(Arrays.toString(productExceptSelf(nums)));
  }
}
