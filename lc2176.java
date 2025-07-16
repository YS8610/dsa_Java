public class lc2176 {
  public int countPairs(int[] nums, int k) {
    int l = nums.length;
    int ans = 0;
    for (int i = 0; i < l; i++)
      for (int j = i + 1; j < l; j++)
        ans += (nums[i] == nums[j] && i * j % k == 0) ? 1 : 0;
    return ans;
  }
}
