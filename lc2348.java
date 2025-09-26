class lc2348 {
  public long zeroFilledSubarray(int[] nums) {
    long ans = 0;
    int l = nums.length;
    int i = 0, j = 0;
    while (i < l) {
      if (nums[i] != 0) {
        i++;
        continue;
      }
      j = i;
      while (j < l && nums[j] == 0) {
        ans += j - i + 1;
        j++;
      }
      i = j;
    }
    return ans;
  }
}
