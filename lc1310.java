import java.util.Arrays;

public class lc1310 {
  private static int[] xorQueries(int[] arr, int[][] queries) {
    int l = arr.length;
    int l1 = queries.length;
    int[] ans = new int[l1];
    int[] dp = new int[l];
    dp[0] = arr[0];
    for (int i =1; i<l;i++){
      dp[i] = dp[i-1]^arr[i];
    }
    System.out.println(Arrays.toString(dp));
    for (int i=0;i<l1;i++){
      if (queries[i][0] == 0){
        ans[i] = dp[queries[i][1]];
        continue;
      }
      if (queries[i][0] == queries[i][1]){
        ans[i] = arr[queries[i][0]];
        continue;
      }
      ans[i] = dp[queries[i][1]] ^ dp[queries[i][0] - 1];
    }
    return ans;
  }

  public static void main(String[] args) {
    int[] arr = {1,3,4,8};
    int[][] queries = {{0,1},{1,2},{0,3},{3,3}};
    System.out.println(Arrays.toString(xorQueries(arr, queries)));
  }
}
