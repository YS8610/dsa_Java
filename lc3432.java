public class lc3432 {
  public int countPartitions(int[] nums) {
    int l = nums.length;
    int sum = 0;
    for (int n : nums)
      sum += n;
    int ans = 0;
    for (int i = 0, subsum = 0; i < l - 1; i++) {
      subsum += nums[i];
      ans += Math.abs(2 * subsum - sum) % 2 == 0 ? 1 : 0;
    }
    return ans;
  }
}
