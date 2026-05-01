public class lc396 {

  private static int maxRotateFunction(int[] nums) {
    int tmp = 0;
    int ans = 0;
    int l = nums.length;
    int sum = 0;
    for (int i = 0; i < l; i++) {
      tmp += nums[i] * i;
      sum += nums[i];
    }
    ans = tmp;
    for (int i = l - 1, last = l - 1; i > 0; i--) {
      tmp = sum - nums[i] + tmp - nums[i] * last;
      ans = Math.max(ans, tmp);
    }
    return ans;
  }

  public static void main(String[] args) {
    int[] nums = { 100 };
    System.out.println(maxRotateFunction(nums));
  }
}
