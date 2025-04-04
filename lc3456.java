public class lc3456 {
  private static boolean hasSpecialSubstring(String s, int k) {
    int l = s.length();
    if (l == k) return ss(s, 0, k);
    if (ss(s, 0, k) && s.charAt(0) != s.charAt(k))
      return true;
    for (int i = 1; i<=l-1-k;i++)
      if (ss(s, i, k))
        if (s.charAt(i-1) != s.charAt(i) && s.charAt(i) != s.charAt(i+k))
          return true;
    if (ss(s, l-k, k) && s.charAt(l-k) != s.charAt(l-k-1))
      return true;
    return false;
  }

  private static boolean ss(String s, int pos, int k){
    int l = s.length();
    if (pos > l - k) return false;
    for (int i= pos; i<pos+k;i++){
      if (s.charAt(pos) != s.charAt(i))
        return false;
    }
    return true;
  }


  public static void main(String[] args) {
    String s = "abbba";
    int k = 3;
    System.out.println(hasSpecialSubstring(s, k));
  }
}
