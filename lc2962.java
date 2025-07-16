public class lc2962 {
  private static long countSubarrays(int[] nums, int k) {
    int max = 0;
    int len = nums.length;
    int n = 0, rp = 0;
    int lp = 1;
    long ans = 0;
    for (int i : nums)
      max = Math.max(max, i);
    // create the first window
    while (rp < len) {
      if (nums[rp] == max)
        n++;
      if (n >= k)
        break;
      rp++;
    }
    if (rp < len)
      ans += len - rp;
    else
      return 0;
    while (lp < len) {
      if (nums[lp - 1] != max)
        ans += len - rp;
      else {
        rp++;
        while (rp < len) {
          if (nums[rp] == max)
            break;
          rp++;
        }
        if (rp >= len)
          return ans;
        ans += len - rp;
      }
      lp++;
    }
    return ans;
  }

  public long countSubarrays1(int[] nums, int k) {
    int l = nums.length;
    int big = nums[0];
    for (int n : nums)
      big = Math.max(big, n);
    int count = 0;
    long ans = 0;
    for (int i = 0, j = 0; i < l; i++) {
      if (i != 0)
        count -= nums[i - 1] == big ? 1 : 0;
      while (j < l && count < k) {
        count += nums[j] == big ? 1 : 0;
        j++;
      }
      ans += count >= k ? l - j + 1 : 0;
    }
    return ans;
  }

  public static void main(String[] args) {
    int[] nums = { 1, 3, 2, 3, 8, 3, 5, 7, 8, 6, 3, 6, 8, 3 };
    // int[] nums = {1,3,2,3,8,3,5,7,8,6};
    int k = 2;
    System.out.println(countSubarrays(nums, k));
  }
}
