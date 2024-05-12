import java.util.Arrays;

public class lc1235 {
  private static int jobScheduling(int[] startTime, int[] endTime, int[] profit) {
    int len = startTime.length;
    if (len==1) return profit[0];
    int[][] combined = new int[len][3];
    for (int i=0;i<len;i++){
      combined[i][0] = startTime[i];
      combined[i][1] = endTime[i];
      combined[i][2] = profit[i];
    }
    Arrays.sort(combined, (m1,m2) ->{
      if (m1[1]==m2[1]) return Integer.compare(m1[0], m2[0]);
      return Integer.compare(m1[1], m2[1]);
    });
    int[] dp = new int[len];
    for(int i =0;i<len;i++) dp[i] = combined[i][2];
    int lp = 0;
    int ans = dp[0];
    for(int i=1;i<len;i++){
      while (lp<i){
        if (combined[lp][1]>combined[i][0]) {
          lp=0;
          break;
        }
        dp[i] = Math.max( dp[lp]+combined[i][2],dp[i]);
        lp++;
      }
      ans = Math.max(ans,dp[i]); 
      lp=0;
    }
    return ans;
  }

  public static void main(String[] args) {
    int[] startTime = {1,1,1};
    int[] endTime = {2,3,4};
    int[] profit = {5,6,4};
    System.out.println(jobScheduling(startTime, endTime, profit));
  }
}
