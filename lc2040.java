import java.util.Arrays;

public class lc2040 {

  private static int[] getAverages(int[] nums, int k) {
    int n = nums.length;
    int[] preSum = new int[n];
    preSum[0] = nums[0];
    int[] ans = new int[n];
    for (int i = 1; i < n; i++) preSum[i] = preSum[i - 1] + nums[i];
    int countofE = 2 * k + 1;
    for (int i = 0; i < n; i++) {
      if (i < k || i >= n - k) ans[i] = -1; else {
        int lp = i - k;
        int rp = i + k;
        if (lp >= 0 && rp < n) {
          ans[i] = sumRange(preSum, lp, rp) / countofE;
        }
      }
    }
    return ans;
  }

  private static int sumRange(int[] preSum, int start, int end) {
    if (start > end) return 0;
    return preSum[end] - ((start - 1) >= 0 ? preSum[start - 1] : 0);
  }

  private static int[] getAverages1(int[] nums, int k) {
    int n = nums.length;
    long[] preSum = new long[n];
    preSum[0] = nums[0];
    for (int i = 1; i < n; i++) preSum[i] = preSum[i - 1] + nums[i];
    int[] ans = new int[n];
    Arrays.fill(ans, -1);
    int countofE = 2 * k + 1;
    for (int i = k; i < n - k; i++) {
      int lp = i - k - 1;
      int rp = i + k;
      ans[i] = (int) ( (preSum[rp] - (lp < 0 ? 0 : preSum[lp]))/countofE ) ;
    }
    return ans;
  }

  public static void main(String[] args) {
    int[] nums = { 7, 4, 3, 9, 1, 8, 5, 2, 6 };
    // int[] nums = new int[80001];
    // Arrays.fill(nums, 10000);

    int k = 1;
    System.out.println(Arrays.toString(getAverages1(nums, k)));
    System.out.println(Arrays.toString(getAverages(nums, k)));
  }
}
