import java.util.Arrays;

public class lc611 {
  static public int triangleNumber(int[] nums) {
    int ans = 0;
    int l = nums.length;
    if (l <= 2)
      return 0;
    int pos;
    Arrays.sort(nums);
    for (int i = 0, n = l - 2; i < n; i++) {
      if (nums[i] == 0)
        continue;
      for (int j = i + 1, m = l - 1; j < m; j++) {
        if (nums[j] == 0)
          continue;
        if (nums[j + 1] >= nums[i] + nums[j])
          continue;
        pos = bs(nums, nums[i] + nums[j]);
        ans += pos - j - 1;
      }
    }
    return ans;
  }

  static private int bs(int[] nums, int k) {
    int l = nums.length;
    int lp = 0, rp = l;
    int mp;
    if (k > nums[l - 1])
      return l;
    while (lp < rp) {
      mp = lp + (rp - lp) / 2;
      if (nums[mp] == k)
        rp = mp;
      if (nums[mp] < k)
        lp = mp+1;
      else
        rp = mp;
    }
    return lp;
  }

  public static void main(String[] args) {
    int[] nums = {1,12,25,53,85,96,541};
    System.out.println(triangleNumber(nums));
  }
}
