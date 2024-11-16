import java.util.ArrayList;
import java.util.List;

public class lc386 {
  private static void dfs(int i, int n, List<Integer>ans){
    if (i > n) return;
    for (int j=0;j<=9;j++){
      if (i+j==0) continue;
      if (i+j > n) break;
      ans.add(i+j);
      dfs((i+j)*10, n, ans);
    }
  }

  private static List<Integer> lexicalOrder(int n) {
    List<Integer> ans = new ArrayList<>(n);
    dfs(0, n ,ans);
    return ans;
  }

  public static void main(String[] args) {
    int n = 21;
    System.out.println(lexicalOrder(n).toString());
  }
}
