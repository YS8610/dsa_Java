public class lc2401 {

  public int longestNiceSubarray(int[] nums) {
    int[] map = new int[32];
    int[] mask = new int[31];
    for (int i = 0, tmp = 1; i < 31; i++, tmp <<= 1) mask[i] = tmp;
    int lp = 0;
    int rp = 0;
    int l = nums.length;
    int ans = 1;
    boolean nice;
    while (rp < l) {
      nice = true;
      for (int i = 0; i < 31 && mask[i] <= nums[rp]; i++) if (
        (mask[i] & nums[rp]) > 0
      ) map[i]++;
      for (int i = 0; i < 31 && nice; i++) if (map[i] > 1) nice = false;
      if (nice) {
        ans = Math.max(rp - lp + 1, ans);
        rp++;
        continue;
      }
      while (lp < rp) {
        nice = true;
        for (int i = 0; i < 31 && mask[i] <= nums[lp]; i++) if (
          (mask[i] & nums[lp]) > 0
        ) map[i]--;
        lp++;
        for (int i = 0; i < 31 && nice; i++) if (map[i] > 1) nice = false;
        if (nice) break;
      }
      rp++;
    }
    return ans;
  }
}
