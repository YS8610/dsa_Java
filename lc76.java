public class lc76 {
  static public String minWindow(String s, String t) {
    int l = s.length();
    int[] map = new int['z' - 'A' + 1];
    int[] mapt = new int['z' - 'A' + 1];
    int lp = 0, rp = 0;
    int len = l + 1;
    // start and end inclusive
    int[] ans = new int[] { -1, -1 };
    for (int i = 0, j = t.length(); i < j; i++)
      mapt[t.charAt(i) - 'A']++;
    // inclusive rp
    while (rp < l) {
      map[s.charAt(rp) - 'A']++;
      // move lp
      while (lp < l && can(map, mapt)) {
        if (len > rp - lp + 1) {
          len = rp - lp + 1;
          ans[0] = lp;
          ans[1] = rp;
        }
        map[s.charAt(lp) - 'A']--;
        lp++;
      }
      // move rp
      rp++;
    }
    return len == l + 1 ? "" : s.substring(ans[0], ans[1] + 1);
  }

  static public boolean can(int[] map, int[] mapt) {
    int l = map.length;
    for (int i = 0; i < l; i++)
      if (map[i] < mapt[i])
        return false;
    return true;
  }

  public static void main(String[] args) {
    String s = "ADOBECODEBANC", t = "ABC";
    System.out.println(minWindow(s, t));
  }
}
