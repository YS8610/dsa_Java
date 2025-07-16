import java.util.Arrays;

public class lc2294 {
  public int partitionArray(int[] nums, int k) {
    int ans = 1;
    int l = nums.length;
    Arrays.sort(nums);
    for (int i = 0, tmp = nums[0]; i < l; i++) {
      if (nums[i] - tmp > k) {
        ans++;
        tmp = nums[i];
      }
    }
    return ans;
  }
}
