import java.util.HashMap;
import java.util.Map;

public class lc474 {
  public int findMaxForm(String[] strs, int m, int n) {
    Map<Long, Integer> memo = new HashMap<>();
    return dfs(strs, m, n, 0, memo);
  }

  public int dfs(String[] strs, int zero, int one, int i, Map<Long, Integer> memo) {
    if (i >= strs.length)
      return 0;
    if (zero == 0 && one == 0)
      return 0;
    if (zero < 0 || one < 0)
      return Integer.MIN_VALUE;
    long key = 0 | zero;
    key <<= 7;
    key |= one;
    key <<= 10;
    key |= i;
    if (memo.containsKey(key))
      return memo.get(key);
    int o1 = 0;
    for (int j = 0, n = strs[i].length(); j < n; j++)
      o1 += strs[i].charAt(j) == '1' ? 1 : 0;
    int z0 = strs[i].length() - o1;
    int tmp = (zero - z0 < 0 || one - o1 < 0) ? 0 : 1;
    int include = tmp + dfs(strs, zero - z0, one - o1, i + 1, memo);
    int exclude = dfs(strs, zero, one, i + 1, memo);
    int ans = Math.max(include, exclude);
    memo.put(key, ans);
    return ans;
  }
}
