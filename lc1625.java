import java.util.HashSet;
import java.util.Set;

public class lc1625 {
  public String findLexSmallestString(String s, int a, int b) {
    Set<String> visited = new HashSet<>();
    return dfs(s, s, visited, a, b);
  }

  public String dfs(String s, String ans, Set<String> visited, int a, int b) {
    if (visited.contains(s))
      return s;
    int l = s.length();
    visited.add(s);
    char[] tmp = s.toCharArray();
    char[] tmp2 = new char[l];
    for (int i = 1; i < l; i += 2)
      tmp[i] = (char) (((int) (tmp[i] - '0') + a) % 10 + '0');
    String opa = String.valueOf(tmp);
    for (int i = 0; i < l; i++)
      tmp2[(i + b) % l] = s.charAt(i);
    String opb = String.valueOf(tmp2);
    String left = dfs(opa, ans, visited, a, b);
    String right = dfs(opb, ans, visited, a, b);
    if (ans.compareTo(s) > 0)
      ans = s;
    if (ans.compareTo(left) > 0)
      ans = left;
    if (ans.compareTo(right) > 0)
      ans = right;
    return ans;
  }
}
