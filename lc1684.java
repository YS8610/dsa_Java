import java.util.Arrays;

public class lc1684 {

  private static int countConsistentStrings(String allowed, String[] words) {
    boolean[] set = new boolean[26];
    int ans = 0;
    Arrays.fill(set, false);
    for (int i = 0, n = allowed.length(); i < n; i++) {
      set[allowed.charAt(i) - 'a'] = true;
    }
    out:for (String w : words) {
      for (int i = 0, n = w.length(); i < n; i++) {
        if (!set[w.charAt(i) - 'a']) continue out;
      }
      ans++;
    }
    return ans;
  }

  public static void main(String[] args) {
    String allowed = "ab";
    String[] words = { "ad", "bd", "aaab", "baa", "badab" };
    System.out.println(countConsistentStrings(allowed, words));
  }
}
