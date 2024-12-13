import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class lc784 {

  private static void dfs(char[] s, int i, List<String> ans) {
    if (i >= s.length) {
      ans.add(String.valueOf(s));
      return;
    }
    if (Character.isDigit(s[i])) {
      dfs(s, i + 1, ans);
      return;
    }
    dfs(s, i + 1, ans);
    char[] copy = Arrays.copyOf(s, s.length);
    if (Character.isUpperCase(s[i])) {
      copy[i] = (char) (copy[i] + 'a' - 'A');
      dfs(copy, i + 1, ans);
    } 
    else {
      copy[i] = (char) (copy[i] - 'a' + 'A');
      dfs(copy, i + 1, ans);
    }
  }

  public List<String> letterCasePermutation(String s) {
    List<String> ans = new ArrayList<>();
    dfs(s.toCharArray(), 0, ans);
    return ans;
  }
}
