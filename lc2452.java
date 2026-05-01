import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class lc2452 {
  public List<String> twoEditWords(String[] queries, String[] dictionary) {
    Set<String> set = new HashSet<>();
    List<String> ans = new ArrayList<>();
    for (String dict : dictionary)
      set.add(dict);
    for (String q : queries) {
      if (set.contains(q)) {
        ans.add(q);
        continue;
      }
      for (String d : dictionary) {
        if (compare(q, d) > 2)
          continue;
        ans.add(q);
        break;
      }
    }
    return ans;
  }

  public int compare(String q, String d) {
    int l1 = q.length();
    int l2 = d.length();
    int minL = Math.min(l1, l2);
    int ans = 0;
    for (int i = 0; i < minL; i++) {
      ans += q.charAt(i) != d.charAt(i) ? 1 : 0;
      if (ans > 2)
        return ans;
    }
    return ans;
  }
}
