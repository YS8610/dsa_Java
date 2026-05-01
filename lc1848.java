public class lc1848 {
  public int getMinDistance(int[] nums, int target, int start) {
    int l = nums.length;
    int ans = -1;
    for (int i = 0; i < l; i++) {
      if (nums[i] != target)
        continue;
      if (ans == -1)
        ans = Math.abs(i - start);
      else
        ans = Math.min(ans, Math.abs(i - start));
    }
    return ans;
  }
}
