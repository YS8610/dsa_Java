public class lc1143 {
  private static int longestCommonSubsequence(String text1, String text2) {
    int l1 = text1.length();
    int l2 = text2.length();
    int[][] dp = new int[l1][l2];
    dp[0][0] = text1.charAt(0) == text2.charAt(0)? 1 :0;
    for (int r = 1; r < l1; r++) {
      if (text1.charAt(r)==text2.charAt(0)) dp[r][0] = 1;
      else dp[r][0] = dp[r-1][0];
    }
    for (int c = 1; c < l2; c++) {
      if (text1.charAt(0) == text2.charAt(c)) dp[0][c] = 1;
      else dp[0][c] = dp[0][c-1];
    }
    for (int r = 1; r<l1;r++){
      for (int c =1; c<l2 ;c++){
        if (text1.charAt(r) != text2.charAt(c)){
          dp[r][c] = Math.max(dp[r-1][c], dp[r][c-1]);;
          continue;
        }
        dp[r][c] = dp[r-1][c-1] + 1;
      }
    }
    // System.out.println(Arrays.deepToString(dp));
    return dp[l1-1][l2-1];
  }

  public static void main(String[] args) {
    String text1 = "abcde", text2 = "ace";
    System.out.println(longestCommonSubsequence(text1, text2));
  }
}
