public class lc2486 {
  private static int appendCharacters(String s, String t) {
    int ps = 0;
    int pt = 0;
    int ls = s.length();
    int lt = t.length();
    while (ps < ls){
      if (pt < lt && s.charAt(ps) == t.charAt(pt)) pt++;
      ps++;
    }
    return lt - pt;
  }

  public static void main(String[] args) {
    String s = "coaching", t = "coding";
    System.out.println(appendCharacters(s, t));
  }
}
