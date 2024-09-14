import java.util.Arrays;

public class lc1894 {

  private static int chalkReplacer(int[] chalk, int k) {
    int l = chalk.length;
    long[] dp = new long[l];
    for (int i = 0; i < l; i++) {
      if (i == 0) {
        dp[0] = chalk[0];
        continue;
      }
      dp[i] = dp[i - 1] + chalk[i];
    }
    long remainder = k % dp[l - 1];
    if (remainder == 0) return 0;
    int pos = Arrays.binarySearch(dp, remainder);
    return pos > 0 ? pos + 1 : -pos - 1;
  }

  public static void main(String[] args) {
    int[] chalk = { 5, 1, 5 };
    int k = 22;
    System.out.println(chalkReplacer(chalk, k));
  }
}
