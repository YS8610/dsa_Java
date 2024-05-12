import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class lc746 {
  private static int minCostClimbingStairsT(int[] cost){
    int n = cost.length;
    if (n==1) return 0;
    if (n==2) return Math.min(cost[0], cost[1]);
    int[] ans = new int[n];
    ans[n-1] = cost[n-1];
    ans[n-2] = cost[n-2];
    for (int i = n-3; i>=0;i--){
      ans[i] = Math.min(ans[i+1], ans[i+2]) + cost[i];
    }
    return Math.min(ans[0], ans[1]);
  }
  
  private static Map<List<Integer>,Integer> memo = new HashMap<>();

  private static int minCostClimbingStairsR(int[] cost){
    if (cost.length == 0) return 0;
    if (cost.length == 1) return 0;
    if (cost.length == 2) return Math.min(cost[0], cost[1]);
    List<Integer> cost1 = new ArrayList<>( Arrays.stream(cost).boxed().toList() );
    if (memo.containsKey(cost1)) return memo.get(cost1);

    int n = cost.length;

    int s1 = minCostClimbingStairsR( Arrays.copyOfRange(cost, 1, n) ) + cost[0];
    int s2 = minCostClimbingStairsR( Arrays.copyOfRange(cost, 2, n) ) + cost[1];
    
    int ans = Math.min(s1, s2);
    memo.put(cost1, ans);
    return ans;
    }

  private static int minCostClimbingStairs(int[] cost){
    int n = cost.length;
    int[] cost0 = new int[n+1];
    cost0[0] = 0;
    int m=1;
    for (int c : cost){
        cost0[m] = c;
        m++;
    }
    return minCostClimbingStairsR(cost0);
    }


  public static void main(String[] args) {
    int[] cost = {1,100,1,1,1,100,1,1,100,1};
    System.out.println( minCostClimbingStairsT(cost) );
  }
}
