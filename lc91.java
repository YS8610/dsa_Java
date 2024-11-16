import java.util.HashMap;
import java.util.Map;

public class lc91 {

  private static int dfs(String s, int i, Map<Integer, Integer> memo) {
    if (i >= s.length()) return 1;
    if (i == s.length() - 1) return 1;
    if (memo.containsKey(i)) return memo.get(i);
    int tmp = 0;
    if (i <= s.length() - 3 && s.charAt(i + 2) == '0') {
      tmp = dfs(s, i + 1, memo);
      memo.put(i, tmp);
      return tmp;
    }
    if (i <= s.length() - 2 && s.charAt(i + 1) == '0') {
      tmp = dfs(s, i + 2, memo);
      memo.put(i, tmp);
      return tmp;
    }
    if (i <= s.length() - 2 && s.charAt(i) == '2' && s.charAt(i + 1) <= '6') {
      tmp = dfs(s, i + 1, memo) + dfs(s, i + 2, memo);
      memo.put(i, tmp);
      return tmp;
    }
    if (i <= s.length() - 2 && s.charAt(i) == '1') {
      tmp = dfs(s, i + 1, memo) + dfs(s, i + 2, memo);
      memo.put(i, tmp);
      return tmp;
    }
    tmp = dfs(s, i + 1, memo);
    memo.put(i, tmp);
    return tmp;
  }

  private static int numDecodings(String s) {
    if (s.charAt(0) == '0') return 0;
    for (int i = 0, n = s.length() - 1; i < n; i++) if (
      (s.charAt(i + 1) == '0' && s.charAt(i) > '2') ||
      (s.charAt(i + 1) == '0' && s.charAt(i) == '0')
    ) return 0;
    return dfs(s, 0, new HashMap<>());
  }

  public static void main(String[] args) {
    String s = "226";
    System.out.println(numDecodings(s));
  }
}
