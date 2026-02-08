public class lc712 {
  public int minimumDeleteSum(String s1, String s2) {
    int l1 = s1.length();
    int l2 = s2.length();
    int[][] dp = new int[l1 + 1][l2 + 1];
    dp[0][0] = 0;
    // filling first row
    for (int col = 1; col <= l2; col++)
      dp[0][col] = s2.charAt(col - 1) + dp[0][col - 1];
    // filling first col
    for (int row = 1; row <= l1; row++)
      dp[row][0] = s1.charAt(row - 1) + dp[row - 1][0];
    // filling up the rest
    for (int r = 1; r <= l1; r++) {
      for (int c = 1; c <= l2; c++) {
        if (s1.charAt(r - 1) != s2.charAt(c - 1)) {
          dp[r][c] = Math.min(dp[r - 1][c] + s1.charAt(r - 1), dp[r][c - 1] + s2.charAt(c - 1));
          continue;
        }
        dp[r][c] = Math.min(dp[r - 1][c - 1], dp[r - 1][c] + s1.charAt(r - 1));
        dp[r][c] = Math.min(dp[r][c], dp[r][c - 1] + s2.charAt(c - 1));
      }
    }
    return dp[l1][l2];
  }
}
