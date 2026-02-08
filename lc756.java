import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class lc756 {
  static public boolean pyramidTransition(String bottom, List<String> allowed) {
    boolean[][][] choices = new boolean[6][6][6];
    for (String a : allowed)
      choices[a.charAt(0) - 'A'][a.charAt(1) - 'A'][a.charAt(2) - 'A'] = true;
    return dfs1(new HashSet<>(), new HashSet<>(), choices, bottom);
  }

  static private boolean dfs1(Set<String> memo, Set<String> fail, boolean[][][] choices, String bottom) {
    Set<String> layer = new HashSet<>();
    dfs(layer, bottom, choices, 0, new char[bottom.length() - 1]);
    if (memo.contains(bottom))
      return true;
    if (layer.isEmpty() || fail.contains(bottom))
      return false;
    for (String lay : layer) {
      if (lay.length() == 1)
        return true;
      break;
    }
    for (String lay : layer) {
      if (dfs1(memo, fail, choices, lay)) {
        memo.add(lay);
        return true;
      }
    }
    fail.add(bottom);
    return false;
  }

  static public void dfs(Set<String> layer, String bottom, boolean[][][] choices, int pos, char[] res) {
    int l = bottom.length();
    if (pos == l - 1) {
      layer.add(String.valueOf(res));
      return;
    }
    for (int i = pos, n = l - 1; i < n; i++) {
      if (i > 0 && res[i - 1] == 0)
        break;
      for (int j = 0; j < 6; j++) {
        if (!choices[bottom.charAt(i) - 'A'][bottom.charAt(i + 1) - 'A'][j])
          continue;
        char[] copy = Arrays.copyOf(res, res.length);
        copy[i] = (char) (j + 'A');
        dfs(layer, bottom, choices, i + 1, copy);
      }
    }
  }

  public static void main(String[] args) {
    String bottom = "AAAA";
    List<String> allowed = Arrays.asList("AAB", "AAC", "BCD", "BBE", "DEF");
    System.out.println(pyramidTransition(bottom, allowed));
  }
}
