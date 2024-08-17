public class lc1937 {
  
  private static long maxPoints(int[][] points) {
    int rlen = points[0].length;
    int clen = points.length;
    long ans=0;
    if (clen==1){
      ans = points[0][0];
      for (int i :points[0]) ans = Math.max(ans, i);
      return ans;
    }
    long[][] dp = new long[clen][rlen];
    for (int i=0;i<rlen;i++){
      dp[clen-1][i]=points[clen-1][i];
    }
    long[] l = new long[rlen];
    long[] r = new long[rlen];
    for (int row = clen-2; row>=0;row--){
      l[0] = dp[row+1][0];
      r[rlen-1] = dp[row+1][rlen-1];
      for (int col=1;col<rlen;col++){
        l[col] = Math.max(dp[row+1][col],l[col-1]-1);
      }
      for (int col=rlen-2;col>=0;col--){
        r[col] = Math.max(dp[row+1][col], r[col+1]-1);
      }
      for (int col=0;col<rlen;col++){
        dp[row][col] = points[row][col] + Math.max(l[col],r[col]);
      }
    }
    ans = dp[0][0];
    for (int i=1;i<rlen;i++){
      ans = Math.max(ans, dp[0][i]);
    }
    return ans;
  }

  public static void main(String[] args) {
    // int[][] points = {{1,2,3},{1,5,1},{3,1,1}};
    int[][] points = {{1,5},{3,2},{4,2}};
    System.out.println(maxPoints(points));
    // System.out.println(maxPt(2,new int[]{3,1,1}));
  }
}
