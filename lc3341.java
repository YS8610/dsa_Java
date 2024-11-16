import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class lc3341 {
  private static long dfs(int[][] moveTime, int r, int c, int sum, Set<List<Integer>> visited, Map<List<Integer>,Long>memo){
    if (r < 0 || r >= moveTime.length) return Long.MAX_VALUE;
    if (c < 0 || c >= moveTime[0].length) return Long.MAX_VALUE;
    if (r == moveTime.length-1 && c == moveTime[0].length-1)
      return sum>=moveTime[r][c]?sum+1:moveTime[r][c]+1;
    if (visited.contains(List.of(r,c))) return Long.MAX_VALUE;
    // if (memo.containsKey(List.of(r,c))) 
    //   return memo.get(List.of(r,c));
    sum = sum>=moveTime[r][c]?sum:moveTime[r][c];
    sum++;
    if (r==0 && c==0) sum = 0;
    visited.add(List.of(r,c));
    long right = dfs(moveTime, r, c+1, sum, new HashSet<>(visited), memo);
    long down = dfs(moveTime, r+1, c, sum, new HashSet<>(visited), memo);
    long up = dfs(moveTime, r-1, c, sum, new HashSet<>(visited), memo);
    long left = dfs(moveTime, r, c-1, sum, new HashSet<>(visited), memo);
    long ans = Math.min(right, down);
    ans = Math.min(ans, up);
    ans = Math.min(ans, left);
    if (ans != Long.MAX_VALUE) memo.put(List.of(r,c), ans);
    return ans;
  }

  private static int minTimeToReach1(int[][] moveTime) {
    return (int)dfs(moveTime, 0, 0, 0, new HashSet<>(), new HashMap<>());
  }

  private static int minTimeToReach(int[][] moveTime){
    int lc = moveTime.length;
    int lr = moveTime[0].length;
    int[][] dp = new int[lc][lr];
    dp[0][0] = 0;
    for (int i = 1; i<lr;i++)
      dp[0][i] = Math.max(dp[0][i-1], moveTime[0][i])+1; 
    for (int i=1; i<lc;i++)
      dp[i][0] = Math.max(dp[i-1][0], moveTime[i][0])+1;
    for (int r=1;r<lc;r++){
      for (int c=1;c<lr;c++){
        dp[r][c] = Math.max(Math.min(dp[r-1][c], dp[r][c-1]), moveTime[r][c])+1;
      }
    }
    return dp[lc-1][lr-1];
  }

  public static void main(String[] args) {
    int[][] moveTime = {
      {94,79,62,27,69,84},
      {6,32,11,82,42,30}
    };
    System.out.println(minTimeToReach1(moveTime));
  }
}
