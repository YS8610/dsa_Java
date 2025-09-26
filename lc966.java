import java.util.HashSet;
import java.util.Set;

public class lc966 {
  public String[] spellchecker(String[] wordlist, String[] queries) {
    Set<String> set = new HashSet<>();
    Set<String> set2 = new HashSet<>();
    String[] ans = new String[queries.length];
    boolean[] map = new boolean[128];
    String tmp = "AEIOUaeiou";
    for (int i = 0, n = tmp.length(); i < n; i++)
      map[tmp.charAt(i)] = true;
    int i = 0;
    for (String w : wordlist)
      set.add(w);
    for (String w : wordlist)
      set2.add(w.toLowerCase());
    out: for (String q : queries) {
      if (set.contains(q)) {
        ans[i++] = q;
        continue;
      }
      if (set2.contains(q.toLowerCase())) {
        for (String w : wordlist) {
          if (!w.equalsIgnoreCase(q))
            continue;
          ans[i++] = w;
          continue out;
        }
      }
      for (String w : wordlist) {
        if (q.length() != w.length())
          continue;
        if (vowelMatch(w, q, map)) {
          ans[i++] = w;
          continue out;
        }
      }
      ans[i++] = "";
    }
    return ans;
  }

  private boolean vowelMatch(String a, String b, boolean[] map) {
    int l = a.length();
    for (int i = 0; i < l; i++) {
      if (a.charAt(i) == b.charAt(i))
        continue;
      if (map[a.charAt(i)] && map[b.charAt(i)])
        continue;
      if (Character.toLowerCase(a.charAt(i)) == Character.toLowerCase(b.charAt(i)))
        continue;
      return false;
    }
    return true;
  }
}
