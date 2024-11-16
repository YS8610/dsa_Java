import java.util.HashMap;
import java.util.Map;

public class lc343 {

  private static int dfs(int n, Map<Integer, Integer> memo) {
    int ans = 0;
    if (n == 0) return 1;
    if (memo.containsKey(n)) return memo.get(n);
    for (int i = 1; i <= n; i++) ans = Math.max(ans, dfs(n - i, memo) * i);
    memo.put(n, ans);
    return ans;
  }

  private static int integerBreak(int n) {
    if (n == 2) return 1;
    if (n == 3) return 2;
    return dfs(n, new HashMap<>());
  }

  public static void main(String[] args) {
    int n = 10;
    System.out.println(integerBreak(n));
  }
}
