import java.util.Arrays;

public class lc174 {
  // tabulation
  public int calculateMinimumHP(int[][] dungeon) {
    int lr = dungeon.length;
    int lc = dungeon[0].length;
    int[][] dp = new int[lr][lc];
    dp[lr - 1][lc - 1] = Math.min(dungeon[lr - 1][lc - 1], 0);
    for (int r = lr - 2; r >= 0; r--)
      dp[r][lc - 1] = Math.min(0, dp[r + 1][lc - 1] + dungeon[r][lc - 1]);
    for (int c = lc - 2; c >= 0; c--)
      dp[lr - 1][c] = Math.min(0, dp[lr - 1][c + 1] + dungeon[lr - 1][c]);
    for (int r = lr - 2; r >= 0; r--)
      for (int c = lc - 2; c >= 0; c--)
        dp[r][c] = Math.min(0, Math.max(dp[r + 1][c], dp[r][c + 1]) + dungeon[r][c]);
    return Math.abs(dp[0][0]) + 1;
  }

  // recursive memoization
  public int calculateMinimumHP1(int[][] dungeon) {
    int lr = dungeon.length;
    int lc = dungeon[0].length;
    int[][] memo = new int[lr][lc];
    for (int[] m : memo)
      Arrays.fill(m, Integer.MIN_VALUE);
    memo[lr - 1][lc - 1] = dungeon[lr - 1][lc - 1];
    return Math.abs(solve(dungeon, memo, 0, 0)) + 1;
  }

  public int solve(int[][] dungeon, int[][] memo, int r, int c) {
    int lr = dungeon.length;
    int lc = dungeon[0].length;
    if (r == lr - 1 && c == lc - 1)
      return Math.min(0, dungeon[lr - 1][lc - 1]);
    if (memo[r][c] != Integer.MIN_VALUE)
      return memo[r][c];
    int right, down, ans = Math.min(0, dungeon[r][c]);
    if (c + 1 < lc && r + 1 < lr) {
      right = solve(dungeon, memo, r, c + 1);
      down = solve(dungeon, memo, r + 1, c);
      ans = Math.min(0, Math.max(right, down) + dungeon[r][c]);
    } else if (c + 1 < lc) {
      right = solve(dungeon, memo, r, c + 1);
      ans = Math.min(0, right + dungeon[r][c]);
    } else {
      down = solve(dungeon, memo, r + 1, c);
      ans = Math.min(0, down + dungeon[r][c]);
    }
    memo[r][c] = ans;
    return ans;
  }
}
