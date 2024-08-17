public class lc647 {

  private static int countSubstrings(String s) {
    int l = s.length();
    int ans = l;
    for (int i = 1; i < l; i++) {
      int lp = i - 1;
      int rp = i + 1;
      while (lp >= 0 && rp < l) {
        if (s.charAt(lp--) == s.charAt(rp++)) ans++; else break;
      }
      lp = i - 1;
      rp = i;
      while (lp >= 0 && rp < l) {
        if (s.charAt(lp--) == s.charAt(rp++)) ans++; else break;
      }
    }
    return ans;
  }

  public static void main(String[] args) {
    String s = "abc";
    System.out.println(countSubstrings(s));
  }
}
