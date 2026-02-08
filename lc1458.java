public class lc1458 {
  public int maxDotProduct(int[] nums1, int[] nums2) {
    int l1 = nums1.length;
    int l2 = nums2.length;
    int[][] dp = new int[l1][l2];
    dp[0][0] = nums1[0] * nums2[0];
    // filling up the first row
    for (int i = 1; i < l2; i++)
      dp[0][i] = Math.max(dp[0][i - 1], nums1[0] * nums2[i]);
    // filling up the first col
    for (int j = 1; j < l1; j++)
      dp[j][0] = Math.max(dp[j - 1][0], nums1[j] * nums2[0]);
    // filling the rest of the cell
    for (int r = 1; r < l1; r++) {
      for (int c = 1, tmp = 0; c < l2; c++) {
        tmp = Math.max(dp[r - 1][c], dp[r][c - 1]);
        dp[r][c] = Math.max(tmp, Math.max(nums1[r] * nums2[c] + dp[r - 1][c - 1], nums1[r] * nums2[c]));
      }
    }
    // System.out.println(Arrays.deepToString(dp));
    return dp[l1 - 1][l2 - 1];
  }
}
