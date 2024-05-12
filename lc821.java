import java.util.Arrays;

public class lc821 {

  private static int[] shortestToChar(String s, char c) {
    char[] charA = s.toCharArray();
    int n = charA.length;
    int[] ans = new int[n];
    Arrays.fill(ans, n);
    for (int i = 0; i < n; i++) {
      int lp, rp;
      if (charA[i] == c) {
        ans[i] = 0;
        lp = i;
        lp--;
        rp = i;
        rp++;
        while (lp >= 0 && charA[lp] != c && ans[lp] >= i - lp) {
          ans[lp] = i - lp;
          lp--;
        }
        while (rp < n && charA[rp] != c && ans[rp] >= rp - i) {
          ans[rp] = rp - i;
          rp++;
        }
      }
    }
    return ans;
  }

  public static void main(String[] args) {
    String s = "loveleetcode";
    char c = 'e';
    System.out.println(Arrays.toString(shortestToChar(s, c)));
  }
}
