import java.util.ArrayList;
import java.util.List;

public class lc131 {

  private static boolean isPalindome(int lp, int rp, String s) {
    while (lp < rp) {
      if (s.charAt(lp) != s.charAt(rp)) return false;
      lp++;
      rp--;
    }
    return true;
  }

  private static void dfs(String s, int i, List<String> sl, List<List<String>> ans) {
    if (i >= s.length()) {
      ans.add(new ArrayList<>(sl));
      return;
    }
    for (int j = 0, n = s.length(); i + j < n; j++) {
      if (isPalindome(i, i + j, s)) {
        sl.add(s.substring(i, i + j + 1));
        dfs(s, i + j + 1, new ArrayList<>(sl), ans);
        sl.remove(sl.size() - 1);
      }
    }
  }

  private static List<List<String>> partition(String s) {
    List<List<String>> ans = new ArrayList<>();
    dfs(s, 0, new ArrayList<>(), ans);
    return ans;
  }

  public static void main(String[] args) {
    String s = "aab";
    System.out.println(partition(s));
  }
}
