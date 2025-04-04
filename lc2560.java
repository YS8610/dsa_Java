public class lc2560 {
  static public int minCapability(int[] nums, int k) {
    int lo = nums[0];
    int hi = nums[0];
    for (int n : nums) {
      lo = Math.min(n, lo);
      hi = Math.max(n, hi);
    }
    int mid = (hi - lo) / 2 + lo;
    while (hi > lo) {
      if (can(nums, k, mid))
        hi = mid;
      else
        lo++;
      mid = (hi - lo) / 2 + lo;
    }
    if (can(nums, k, lo-1))
      return lo-1;
    return mid;
  }

  private static boolean can(int[] nums, int k, int target) {
    int count = 0;
    for (int i = 0, l = nums.length; i < l; i++) {
      if (nums[i] > target)
        continue;
      count++;
      i++;
    }
    return count >= k;
  }

  public static void main(String[] args) {
    int[] nums = {2,3,5,9};
    int k = 2;
    System.out.println(minCapability(nums, k));
  }
}
