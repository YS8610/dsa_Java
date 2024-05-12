import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class lc438 {

  private static List<Integer> findAnagrams(String s, String p) {
    int l1 = s.length();
    int l2 = p.length();
    if (l1 < l2) return new ArrayList<>();
    int[] map = new int[26];
    int[] slidingWin = new int[26];
    List<Integer> ans = new ArrayList<>();
    for (int i = 0; i < l2; i++) {
      map[(int) p.charAt(i) - 'a']++;
      slidingWin[(int) s.charAt(i) - 'a']++;
    }
    if (Arrays.equals(map, slidingWin)) ans.add(0);
    for (int i = 1, n = l1 - l2; i <= n; i++) {
      slidingWin[(int) s.charAt(i - 1) - 'a']--;
      slidingWin[(int) s.charAt(i + l2 - 1) - 'a']++;
      if (Arrays.equals(map, slidingWin)) ans.add(i);
    }
    return ans;
  }

  public static void main(String[] args) {
    String s = "cbaebabacd", p = "abc";
    System.out.println(findAnagrams(s, p).toString());
  }
}
