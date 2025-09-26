public class lc1248 {
  private static int numberOfSubarrays(int[] nums, int k) {
    return subarray(nums, k) - subarray(nums, k - 1);
  }

  public static int subarray(int[] nums, int target) {
    int l = nums.length;
    int lp = 0, rp = 0;
    int ans = 0;
    int count = 0;
    while (rp < l) {
      count += nums[rp] % 2 == 1 ? 1 : 0;
      while (lp < rp && count > target)
        count -= nums[lp++] % 2 == 1 ? 1 : 0;
      ans += count <= target ?rp - lp + 1:0;
      rp++;
    }
    return ans;
  }

  public static void main(String[] args) {
    int[] nums = { 1, 1, 1, 1, 1 };
    int k = 1;
    System.out.println(numberOfSubarrays(nums, k));
  }
}
