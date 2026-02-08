import java.util.Arrays;

public class lc3634 {
  public int minRemoval(int[] nums, int k) {
    int l = nums.length;
    if (l == 1)
      return 0;
    int ans = 0;
    Arrays.sort(nums);
    int lp = 0, rp = 0;
    while (lp < l && rp < l) {
      // move rp
      while (rp < l && can(nums[lp], nums[rp], k)) {
        if (can(nums[lp], nums[rp], k))
          ans = Math.max(ans, rp - lp + 1);
        rp++;
      }
      // move lp
      lp++;
    }
    return l - ans;
  }

  private boolean can(int left, int right, int k) {
    if (left == right)
      return true;
    // boolean tmp = 1l * left * k <= (long)right;
    // System.out.println(left + " " + right + " " + tmp);
    return 1l * left * k >= (long) right;
  }
}
