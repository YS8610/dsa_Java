import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;


public class lc51 {
  private static void fill(boolean[] excluded, int posr, int posc, int r, int c, int n){
    if (posr<0 || posc<0 || posr>=n || posc>=n) return ;
    excluded[posr*n+posc] = true;
    fill(excluded, posr+r, posc+c, r, c, n);
  }

  private static void dfs(Set<Integer> s, boolean[] excluded, int n){
    for (int r=0;r<n;r++){
      for (int c=0;c<n;c++){
        if (excluded[r*n+c]) continue;
        fill(excluded, r, c, 1, 0, n);
        fill(excluded, r, c, -1, 0, n);
        fill(excluded, r, c, 0, -1, n);
        fill(excluded, r, c, 0, 1, n);
        fill(excluded, r, c, 1, 1, n);
        fill(excluded, r, c, -1, -1, n);
        fill(excluded, r, c, 1, -1, n);
        fill(excluded, r, c, -1, 1, n);
        s.add(r*n+c);
        dfs(new HashSet<>(s), Arrays.copyOf(excluded, n*n), n);
      }
    }
  }
  
  private static List<String> chess(Set<Integer> s, int n){
    char[][] tmp = new char[n][n];
    List<String> ans = new ArrayList<>(n); 
    for (int i=0;i<n;i++){
      for (int j=0;j<n;j++){
        if (s.contains(i*n+j)) tmp[i][j]='Q';
        else tmp[i][j]='.';
      }
    }
    for (char[] t :tmp){
      StringBuilder str = new StringBuilder();
      for (char a : t) str.append(a);
      ans.add(str.toString());
    }
    return ans;
  }

  private static List<List<String>> solveNQueens(int n) {
    if (n == 1){
      List<List<String>> ans = new ArrayList<>();
      ans.add(List.of("Q"));
      return ans;
    }
    if (n == 2 || n == 3) return new ArrayList<>();
    Set<Integer> s = new HashSet<>();
    boolean[] excluded = new boolean[n*n];
    Set<Set<Integer>> subans = new HashSet<>();

    for (int i=0;i<n;i++){
      for (int j=0;j<n;j++){
        if (s.size() == n){
          subans.add(new HashSet<>(s));
        }
        s.clear();
        Arrays.fill(excluded, false);
        s.add(i*n+j);
        fill(excluded, i, j, 1, 0, n);
        fill(excluded, i, j, -1, 0, n);
        fill(excluded, i, j, 0, -1, n);
        fill(excluded, i, j, 0, 1, n);
        fill(excluded, i, j, 1, 1, n);
        fill(excluded, i, j, -1, -1, n);
        fill(excluded, i, j, 1, -1, n);
        fill(excluded, i, j, -1, 1, n);
        dfs(s, excluded, n);
      }
    }
    System.out.println(subans);
    List<List<String>> ans = new ArrayList<>();
    // for (Set<Integer> sub : subans){
    //   ans.add(chess(sub,n));
    // }
    return ans;
  }

  public static void main(String[] args) {
    int n=5;
    System.out.println(solveNQueens(n));
  }
}
