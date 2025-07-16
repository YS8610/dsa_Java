public class lc3375 {
  public int minOperations(int[] nums, int k) {
    boolean[] map = new boolean[101];
    int small = nums[0];
    int big = nums[0];
    for (int n : nums) {
      map[n] = true;
      small = Math.min(small, n);
      big = Math.max(big, n);
    }
    if (k > small)
      return -1;
    int ans = 0;
    for (boolean m : map)
      ans += m ? 1 : 0;
    return k == small ? ans - 1 : ans;
  }
}
