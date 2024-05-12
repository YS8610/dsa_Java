import java.util.ArrayList;
import java.util.List;

public class lc93 {
  private static void dfs(String s, int i, List<char[]> subans, List<String> ans){
    int l = s.length();
    int l1 = 0;
    if ( i==3 && (l < 4 || l > 12)) return;
    if ( i==2 && (l < 3 || l > 9)) return;
    if ( i==1 && (l < 2 || l > 6)) return;
    if ( i==0 && (l < 1 || l > 3)) return;
    if (i==0){
      if (l>1 && Integer.parseInt(s) < Math.pow(10, l-1)) return;
      if (Integer.parseInt(s)>255) return;
      for (char[] sub :subans) l1 += sub.length+1;
      l1 += s.length();
      StringBuilder a = new StringBuilder(l1);
      for (char[] sub:subans) {
        a.append(sub);
        a.append('.');
      }
      a.append(s);
      ans.add(a.toString());
      return;
    }
    if (l>=3 && Integer.parseInt(s.substring(0, 3))<=255) {
      if (Integer.parseInt(s.substring(0, 3)) >= Math.pow(10, 2)){
        subans.add(s.substring(0, 3).toCharArray());
        dfs(s.substring(3), i-1, subans, ans);
        subans.remove(subans.size()-1);
      }
    }
    if (l>=2) {
      if (Integer.parseInt(s.substring(0, 2)) >= Math.pow(10, 1)){
        subans.add(s.substring(0, 2).toCharArray());
        dfs(s.substring(2), i-1, subans, ans);
        subans.remove(subans.size()-1);
      }
    }
    if (l>=1) {
      subans.add(s.substring(0, 1).toCharArray());
      dfs(s.substring(1), i-1, subans, ans);
      subans.remove(subans.size()-1);
    }
  }

  private static List<String> restoreIpAddresses(String s) {
    List<String> ans = new ArrayList<>();
    dfs(s, 3, new ArrayList<>(), ans);
    return ans;
  }

  public static void main(String[] args) {
    String s = "172162541";
    System.out.println(restoreIpAddresses(s));
  }
}
