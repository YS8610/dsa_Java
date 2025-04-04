import java.util.ArrayList;
import java.util.List;

public class lc1415 {
  private static String getHappyString(int n, int k) {
    List<String> holder = new ArrayList<>(k);
    dfs(holder, "", n, k);
    if (holder.size() < k)
      return "";
    return holder.get(k - 1);
  }

  private static void dfs(List<String> holder, String str, int n, int k) {
    if (str.length() >= n) {
      holder.add(str);
      return;
    }
    if (holder.size() >= k)
      return;
    if (str == "") {
      dfs(holder, "a", n, k);
      dfs(holder, "b", n, k);
      dfs(holder, "c", n, k);
      return;
    }
    int l = str.length();
    if (str.charAt(l - 1) == 'a') {
      dfs(holder, str + "b", n, k);
      dfs(holder, str + "c", n, k);
    } else if (str.charAt(l - 1) == 'b') {
      dfs(holder, str + "a", n, k);
      dfs(holder, str + "c", n, k);
    } else {
      dfs(holder, str + "a", n, k);
      dfs(holder, str + "b", n, k);
    }
  }

  public static void main(String[] args) {
    int n = 3, k = 9;
    System.out.println(getHappyString(n, k));
  }
}
