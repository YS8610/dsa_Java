public class lc1437 {
  public boolean kLengthApart(int[] nums, int k) {
    if (k == 0)
      return true;
    int l = nums.length;
    for (int i = 0, c0 = 0, c1 = 0; i < l; i++) {
      if (nums[i] == 1) {
        c1++;
        if (c0 < k && c1 >= 2)
          return false;
        c0 = 0;
        continue;
      }
      c0++;
    }
    return true;
  }
}
