public class lc1957 {

  private static String makeFancyString(String s) {
    StringBuilder ans = new StringBuilder();
    int i = 1;
    int j = 0;
    int l = s.length();
    ans.append(s.charAt(0));
    while (i < l) {
      if (s.charAt(i) != s.charAt(i - 1)) {
        ans.append(s.charAt(i));
        i++;
        continue;
      }
      j = 0;
      while (i + j < l) {
        if (j == 0) {
          ans.append(s.charAt(i + j));
          j++;
          continue;
        }
        if (s.charAt(i + j) == s.charAt(i + j - 1)) {
          j++;
        } else break;
      }
      if (j > 0) i += j; else i++;
    }
    return ans.toString();
  }

  public static void main(String[] args) {
    String s = "leeetcode";
    System.out.println(makeFancyString(s));
  }
}
