public class lc2654 {
  public int minOperations(int[] nums) {
    int l = nums.length;
    int c1 = 0;
    for (int n : nums)
      c1 += n == 1 ? 1 : 0;
    if (c1 > 0)
      return l - c1;
    int small = l + 1;
    for (int i = 0, tmp = 0, n = l - 1; i < n; i++) {
      tmp = gcb(nums[i], nums[i + 1]);
      if (tmp == 1)
        return l;
      for (int j = i + 2; j < l; j++) {
        tmp = gcb(tmp, nums[j]);
        if (tmp == 1) {
          small = Math.min(small, j - i + 1);
          if (small == 2)
            return l;
        }
      }
    }
    return small == l + 1 ? -1 : l - 2 + small;
  }

  public int gcb(int a, int b) {
    if (a == 0)
      return b;
    return gcb(b % a, a);
  }
}
