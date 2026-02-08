public class lc3379 {
  public int[] constructTransformedArray(int[] nums) {
    int l = nums.length;
    if (l == 1)
      return nums;
    int[] ans = new int[l];
    for (int i = 0; i < l; i++)
      ans[i] = nums[i];
    for (int i = 0, tmp = 0; i < l; i++) {
      if (nums[i] == 0)
        ans[i] = nums[i];
      else if (nums[i] > 0)
        ans[i] = nums[(i + nums[i]) % l];
      else {
        tmp = nums[i] % l;
        tmp += i;
        tmp = tmp >= 0 ? tmp : tmp + l;
        ans[i] = nums[tmp];
      }
    }
    return ans;
  }
}
