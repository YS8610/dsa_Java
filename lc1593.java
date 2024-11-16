import java.util.HashSet;
import java.util.Set;

public class lc1593 {

  private static int bt(String s, int i, Set<String> set) {
    int l = s.length();
    int max = 0;
    if (i == l) return 0;
    for (int j = i + 1; j <= l; j++) {
      String a = s.substring(i, j);
      if (set.contains(a)) continue;
      set.add(a);
      max = Math.max(max, 1 + bt(s, j, set));
      set.remove(a);
    }
    return max;
  }

  private static int maxUniqueSplit(String s) {
    return bt(s, 0, new HashSet<>());
  }

  public static void main(String[] args) {
    String s = "ababccc";
    System.out.println(maxUniqueSplit(s));
  }
}
