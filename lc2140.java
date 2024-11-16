public class lc2140 {
  private static long mostPoints(int[][] questions) {
    int l = questions.length;
    long[] dp = new long[l];
    long maxdp = 0;
    if (l==1) return questions[0][0];
    if (l==2) return Math.max(questions[0][0], questions[1][0]);
    dp[l-1] = questions[l-1][0];
    maxdp = questions[l-1][0];
    for (int i =l-2, tmp =0;i>=0;i--){
      dp[i] = questions[i][0];
      tmp = i + questions[i][1]+1;
      if (tmp < l) dp[i] += maxdp;
      maxdp = Math.max(maxdp, dp[i]);
    }
    return maxdp;
  }

  public static void main(String[] args) {
    int[][] questions = {{26,36},{2,35},{48,40},{69,22}};

    System.out.println( mostPoints(questions) );
  }
}
