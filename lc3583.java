public class lc3583 {
  static public int specialTriplets(int[] nums) {
    int l = nums.length;
    int MOD = 1000000007;
    int size = 100000 / 2 + 1;
    int[] frontmap = new int[size];
    int[] backmap = new int[size];
    if ((nums[0] & 1) == 0)
      frontmap[nums[0] / 2]++;
    for (int i = 2; i < l; i++)
      if ((nums[i] & 1) == 0)
        backmap[nums[i] / 2]++;
    int ans = 0;
    for (int i = 1, n = l - 1; i < n; i++) {
      if (nums[i] < size && frontmap[nums[i]] > 0 && backmap[nums[i]] > 0) {
        ans += (1l * frontmap[nums[i]] * backmap[nums[i]]) % MOD;
        ans %= MOD;
      }
      if ((nums[i] & 1) == 0)
        frontmap[nums[i] / 2]++;
      if ((nums[i + 1] & 1) == 0)
        backmap[nums[i + 1] / 2]--;
    }
    return ans;
  }

  public static void main(String[] args) {
    int[] nums = { 60302, 334, 56288, 24774, 12387, 24774 };
    System.out.println(specialTriplets(nums));
  }
}
