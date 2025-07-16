import java.util.Arrays;

public class lc2966 {
  public int[][] divideArray(int[] nums, int k) {
    int l = nums.length;
    Arrays.sort(nums);
    int[][] ans = new int[l / 3][3];
    for (int i = 1, j = 0; i < l; i += 3, j++) {
      if (nums[i + 1] - nums[i - 1] > k)
        return new int[0][0];
      ans[j][0] = nums[i - 1];
      ans[j][1] = nums[i];
      ans[j][2] = nums[i + 1];
    }
    return ans;
  }
}
