import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class lc2554 {
	private static int dfs(boolean[] visit, int n, int i, int sum, Map<List<Integer>, Integer> memo){
		if (i > n || i > sum) return 0;
		List<Integer> tmp = List.of(i, sum);
		if (memo.containsKey(tmp)) return memo.get(tmp);
		int ans =0;
		if (visit[i])
			ans = dfs(visit, n, i+1, sum, memo);
		else{
			ans = Math.max(dfs(visit, n, i+1, sum-i, memo)+1, dfs(visit, n, i+1, sum, memo));
			visit[i] = true;
		}
		memo.put(tmp, ans);
		return ans;
	}
	
	private static int maxCount1(int[] banned, int n, int maxSum){
		boolean[] visit = new boolean[10001];
		for (int b : banned)
			visit[b] = true;
		Map<List<Integer>, Integer> memo = new HashMap<>();
		return dfs(visit, n, 1, maxSum, memo);
	}

  public int maxCount(int[] banned, int n, int maxSum) {
    boolean[] v = new boolean[10001];
    for (int b : banned) v[b] = true;
    int ans = 0;
    for (int i = 1; i <= n; i++) {
      if (v[i]) continue;
      if (i <= maxSum) {
        ans++;
        maxSum -= i;
        continue;
      }
      break;
    }
    return ans;
  }
}
