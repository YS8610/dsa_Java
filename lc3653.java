class lc3653 {
  public int xorAfterQueries(int[] nums, int[][] queries) {
    int MOD = 1_000_000_007;
    int l = nums.length;
    long tmp;
    for (int[] q : queries) {
      for (int i = q[0]; i <= q[1] && i < l; i += q[2]) {
        tmp = 1l * nums[i] * q[3] % MOD;
        nums[i] = (int) tmp;
      }
    }
    int ans = 0;
    for (int i = 0; i < l; i++)
      ans ^= nums[i];
    return ans;
  }
}