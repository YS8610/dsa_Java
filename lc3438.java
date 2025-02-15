public class lc3438 {
  private static String findValidPair(String s) {
    int[] map = new int[10];
    int l = s.length();
    for (int i=0;i<l;i++)
      map[s.charAt(i)-'0']++;
    for (int i=0, n=l-1;i<n;i++){
      if (s.charAt(i) != s.charAt(i+1) && map[s.charAt(i)-'0'] == s.charAt(i)-'0' && map[s.charAt(i+1)-'0'] == s.charAt(i+1)-'0'){
        StringBuilder a = new StringBuilder();
        a.append(s.charAt(i));
        a.append(s.charAt(i+1));
        return a.toString();
      }
    }
    return "";
  }

  public static void main(String[] args) {
    String s = "221";
    System.out.println(findValidPair(s));
  }
}
