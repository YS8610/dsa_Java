import java.util.HashSet;
import java.util.Set;

public class lc3 {

  private static int lengthOfLongestSubstring(String s) {
    int ans = 1;
    int len = s.length();
    if (len == 0) return 0;
    Set<Integer> moreThan1 = new HashSet<>();
    int[] charArray = new int[127];
    charArray[(int) s.charAt(0)]++;
    for (int i = 0; i < len; i++) {
      if (i != 0) {
        if (charArray[(int) s.charAt(i - 1)] == 2) moreThan1.remove(
          (int) s.charAt(i - 1)
        );
        charArray[(int) s.charAt(i - 1)]--;
      }
      if (i + ans < len) {
        charArray[(int) s.charAt(i + ans)]++;
        if (charArray[(int) s.charAt(i + ans)] > 1) moreThan1.add(
          (int) s.charAt(i + ans)
        );
        while (i + ans < len && moreThan1.isEmpty()) {
          ans++;
          if (i + ans >= len) break;
          charArray[(int) s.charAt(i + ans)]++;
          if (charArray[(int) s.charAt(i + ans)] > 1) moreThan1.add(
            (int) s.charAt(i + ans)
          );
        }
      }
    }
    return ans;
  }

  private static boolean unique(int[] map) {
    for (int i = 0; i < 127; i++) if (map[i] > 1) return false;
    return true;
  }

  public int lengthOfLongestSubstring1(String s) {
    if (s.isEmpty()) return 0;
    int[] map = new int[127];
    int l = s.length();
    int lp = 0;
    int rp = 0;
    int ans = 1;
    map[s.charAt(rp)]++;
    while (rp < l) {
      if (lp == rp) {
        rp++;
        if (rp < l) map[s.charAt(rp)]++;
        continue;
      }
      if (unique(map)) {
        ans = Math.max(ans, rp - lp + 1);
        rp++;
        if (rp < l) map[s.charAt(rp)]++;
      } else {
        map[s.charAt(lp)]--;
        lp++;
      }
    }
    return ans;
  }

  public static void main(String[] args) {
    String s = "bbccaaabvgfvj";
    System.out.println(lengthOfLongestSubstring(s));
  }
}
