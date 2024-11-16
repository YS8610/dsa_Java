public class lc962 {

  private static int maxWidthRamp(int[] nums) {
    int l = nums.length;
    int[] premax = new int[l];
    premax[l - 1] = nums[l - 1];
    for (int i = l - 2; i > 0; i--) premax[i] =
      Math.max(premax[i + 1], nums[i]);
    int lp = 0;
    int rp = lp + 1;
    int ans = 0;
    while (lp < l && rp < l) {
      while (rp < l && premax[rp] >= nums[lp]) rp++;
      ans = Math.max(ans, rp - lp);
      lp++;
      rp++;
    }
    return ans - 1;
  }

  public static void main(String[] args) {
    int[] nums = {9,8,1,0,1,9,4,0,4,1};
    System.out.println(maxWidthRamp(nums));
  }
}
