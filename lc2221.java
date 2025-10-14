import java.util.Arrays;

public class lc2221 {
  public int triangularSum(int[] nums) {
    int l = nums.length;
    if (l == 1)
      return nums[0];
    int[] cur = new int[l];
    int[] prev = Arrays.copyOf(nums, l);
    for (int i = l; i > 0; i--) {
      for (int j = 0, n = i - 1; j < n; j++)
        cur[j] = (prev[j] + prev[j + 1]) % 10;
      prev = cur;
    }
    return cur[0];
  }
}
