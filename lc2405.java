import java.util.Arrays;

public class lc2405 {

  private static int partitionString(String s) {
    int l = s.length();
    int i = 0;
    int j = 0;
    int ans = 0;
    boolean[] set = new boolean[26];
    while (i < l) {
      j = 0;
      Arrays.fill(set, false);
      while (i + j < l && !set[s.charAt(i + j) - 'a']) {
        set[s.charAt(i + j) - 'a'] = true;
        j++;
      }
      ans++;
      i += j;
    }
    return ans;
  }

  public static void main(String[] args) {
    String s = "abacaba";
    System.out.println(partitionString(s));
  }
}
