public class lc5 {
  private static boolean valid(String s, int lp, int rp, int len){
    if (lp>=rp) return false;
    if (lp >= len || rp >= len) return false;
    while (lp<rp){
      if (s.charAt(lp)!= s.charAt(rp)) return false;
      lp++;
      rp--;
    }
    return true;
  }
  
  private static String longestPalindrome(String s) {
    int len = s.length();
    int l = 1;
    String a = s.substring(0, 1);
    if (len == 1) return s;
    int lp = 0;
    int rp = len-1;

    while (lp<len-1 && rp <len){
      while (lp + l<=rp && rp<len){
        if (valid(s, lp, rp, len)){
          l = Math.max(l,rp-lp+1);
          a = s.substring(lp,rp+1);
          break;
        }
        rp--;
      }
      lp++;
      rp = len - 1;
    }
    return a;
  }

  public static void main(String[] args) {
    String s = "caba";
    System.out.println(longestPalindrome(s));
  }
}
