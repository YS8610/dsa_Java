import java.util.Arrays;

public class lc3693 {
  public int climbStairs(int n, int[] costs) {
    int[] memo = new int[n + 1];
    Arrays.fill(memo, -1);
    return dfs(memo, n, 0, costs);
  }

  public int dfs(int[] memo, int n, int s, int[] costs) {
    if (s == n)
      return 0;
    if (s > n)
      return Integer.MAX_VALUE;
    if (memo[s] != -1)
      return memo[s];
    int s1 = (s + 1 - 1 >= costs.length ? 0 : (costs[s + 1 - 1] + 1)) + dfs(memo, n, s + 1, costs);
    int s2 = (s + 2 - 1 >= costs.length ? 0 : (costs[s + 2 - 1] + 4)) + dfs(memo, n, s + 2, costs);
    int s3 = (s + 3 - 1 >= costs.length ? 0 : (costs[s + 3 - 1] + 9)) + dfs(memo, n, s + 3, costs);
    int ans = Math.min(Math.min(s1, s2), s3);
    memo[s] = ans;
    return ans;
  }
}
