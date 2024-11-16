import java.util.Arrays;

public class lc14 {
  private static String longestCommonPrefix(String[] strs) {
    int sh = strs[0].length();
    for (String s:strs) sh =Math.min(sh, s.length());
    int[] map = new int[26];
    int tmp=0;
    for (int i=0; i<sh;i++){
      for (String s:strs)
        map[s.charAt(i) - 'a']++;
      if (map[strs[0].charAt(i) - 'a'] != strs.length) break;
      tmp++;
      Arrays.fill(map, 0);
    }
    return strs[0].substring(0, tmp);
  }
  public static void main(String[] args) {
    String[] strs = {"ab", "a"};
    System.out.println(longestCommonPrefix(strs));
  }
}
