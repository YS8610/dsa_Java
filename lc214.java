public class lc214 {

  private static String shortestPalindrome(String s) {
    int l = s.length();
    int lp, rp;
    int pos = 0;
    out:for (int i = l - 1; i >= 0; i--) {
      rp = i;
      lp = 0;
      while (lp < rp) {
        if (s.charAt(lp) == s.charAt(rp)) {
          rp--;
          lp++;
        } else continue out;
      }
      pos = i;
      break;
    }
    StringBuilder ans = new StringBuilder();
    for (int i = l - 1; i > pos; i--) {
      ans.append(s.charAt(i));
    }
    for (int i = 0; i < l; i++) {
      ans.append(s.charAt(i));
    }
    return ans.toString();
  }

  public static void main(String[] args) {
    String s = "aacecaaa";
    System.out.println(shortestPalindrome(s));
  }
}
