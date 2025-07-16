import java.util.Arrays;

public class lc2099 {
  public int[] maxSubsequence(int[] nums, int k) {
    int[] ans = new int[k];
    int l = nums.length;
    int[][] pos = new int[l][2];
    for (int i = 0; i < l; i++) {
      pos[i][0] = nums[i];
      pos[i][1] = i;
    }
    Arrays.sort(pos, (m1, m2) -> Integer.compare(m2[0], m1[0]));
    Arrays.sort(pos, 0, k, (m1, m2) -> Integer.compare(m1[1], m2[1]));
    for (int i = 0; i < k; i++)
      ans[i] = pos[i][0];
    return ans;
  }
}
