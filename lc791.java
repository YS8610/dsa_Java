import java.util.Arrays;

public class lc791 {
  private static String customSortString(String order, String s) {
    int[] map = new int[26];
    int len = order.length();
    int m = s.length();
    Character[] a = new Character[m];
    for (int i=0;i<m;i++) a[i] = s.charAt(i);
    for (int i=0;i<len;i++) map[order.charAt(i) - 'a'] = 25 - i;
    Arrays.sort(a, (m1,m2) -> Integer.compare(map[m2 - 'a'], map[m1 - 'a']));
    char[] b  = new char[m];
    for (int i=0;i<m;i++) b[i] = a[i];
    return String.valueOf(b);
  }

  public static void main(String[] args) {
    String order = "cba", s = "abcd";
    System.out.println(customSortString(order, s));
  }
}
