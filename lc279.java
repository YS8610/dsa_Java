// import java.util.Arrays;

public class lc279 {
  private static int numSquares(int n) {
    int max = (int)Math.sqrt(n);
    int[] nums = new int[max];
    int result;
    for(int i=0;i<max;i++) nums[i] = (i+1)*(i+1);
    int[][] dp = new int[max][n+1];
    for (int c=0;c<=n;c++) dp[0][c]=c;
    for (int r=1;r<max;r++ ){
      for(int c=1;c<=n;c++){
        result = c - nums[r];
        if (result<0) dp[r][c] = dp[r-1][c];
        else dp[r][c] = Math.min(dp[r-1][c], dp[r][result]+1);
      }
    }
    return dp[max-1][n];
  }

  public static void main(String[] args) {
    int n = 12;
    System.out.println( numSquares(n) );
  }
}
