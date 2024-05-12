import java.util.Arrays;

public class lc2448 {

  private static long minCost(int[] nums, int[] cost) {
    long minCost = 0;
    for (int i = 0, n = nums.length; i < n; i++) {
      int diff = Math.abs(nums[0] - nums[i]);
      minCost += Long.valueOf(diff) * Long.valueOf(cost[i]);
    }
    for (int i = 1, n = nums.length; i < n; i++) {
      long totalCost = 0;
      for (int j = 0; j < n; j++) {
        int diff = Math.abs(nums[i] - nums[j]);
        totalCost += Long.valueOf(diff) * Long.valueOf(cost[j]);
      }
      minCost = Math.min(minCost, totalCost);
    }
    return minCost;
  }

  private static long minCost1(int[] nums, int[] cost) {
    long minCost = 0;
    int n = nums.length;
    long[][] memo = new long[n][n];
    int[][] combined = new int[n][2];
    for (int i = 0; i < n; i++) {
      combined[i][0] = nums[i];
      combined[i][1] = cost[i];
    }
    Arrays.sort(combined, (m1, m2) -> Integer.compare(m1[0], m2[0]));
    // intitalization of first row
    for (int col = 0; col < n; col++) {
      long diff = Math.abs(combined[0][0] - combined[col][0]);
      memo[0][col] = diff * (long) combined[0][1];
    }
    minCost = memo[0][n - 1];
    // start filling up other rows
    for (int r = 1; r < n; r++) {
      for (int c = 0; c < n; c++) {
        long diff = Math.abs(combined[r][0] - combined[c][0]);
        memo[r][c] = diff * combined[r][1] + memo[r - 1][c];
      }
    }
    for(int i=0; i<n;i++) minCost = Math.min(minCost, memo[n-1][i]);
    return minCost;
  }

  public static void main(String[] args) {
    int[] nums = { 1, 3, 5, 2 }, cost = { 2, 3, 1, 14 };
    System.out.println(minCost(nums, cost));
    System.out.println(minCost1(nums, cost));
  }
}
