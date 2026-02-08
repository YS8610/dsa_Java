import java.util.Arrays;

public class lc3381 {
  static public long maxSubarraySum(int[] nums, int k) {
    int l = nums.length;
    long[] map = new long[k];
    long[] prefix = new long[l + 1];
    for (int i = 0; i < l; i++)
      prefix[i + 1] = prefix[i] + nums[i];
    long ans = Long.MIN_VALUE;
    Arrays.fill(map, Long.MAX_VALUE / 2);
    map[0] = 0;
    for (int i = 1, mod = 0; i <= l; i++) {
      mod = i % k;
      ans = Math.max(ans, prefix[i] - map[mod]);
      map[mod] = Math.min(map[mod], prefix[i]);
    }
    return ans;
  }

  public static void main(String[] args) {
    int[] nums = { -1, -2, -3, -4, -5 };
    int k = 4;
    System.out.println(maxSubarraySum(nums, k));
  }
}
