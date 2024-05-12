import java.util.Arrays;

public class lc205 {
  private static boolean isIsomorphic(String s, String t) {
    char[] map = new char['~' - ' ' + 1];
    int[] check = new int['~' - ' ' + 1];
    Arrays.fill(map, '\t');
    for (int i = 0, n = s.length(); i < n; i++) {
      if (map[s.charAt(i) - ' '] == '\t') {
        map[s.charAt(i) - ' '] = t.charAt(i);
      } else if (map[s.charAt(i) - ' '] == t.charAt(i)) {
        continue;
      } else return false;
    }
    for (char m : map) {
      if (m != '\t') {
        if (check[m - ' '] == 0) check[m - ' ']++; else return false;
      }
    }
    return true;
  }

  public static void main(String[] args) {
    String s = "egg", t = "add";
    System.out.println(isIsomorphic(s, t));
  }
}
