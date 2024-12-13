public class lc2516 {

  public int takeCharacters(String s, int k) {
    if (k == 0) return 0;
    if (s.length() < 3) return -1;
    int[] map = new int[3];
    for (int i = 0, n = s.length(); i < n; i++) map[s.charAt(i) - 'a']++;
    if (!can(map, k)) return -1;
    if (s.length() == k * 3) return s.length();
    int lp = 0;
    int rp = 0;
    int l = s.length();
    int len = 0;
    while (rp < l) {
      map[s.charAt(rp) - 'a']--;
      if (can(map, k)) {
        len = Math.max(len, rp - lp + 1);
        rp++;
        continue;
      }
      while (lp < rp && !can(map, k)) {
        map[s.charAt(lp) - 'a']++;
        lp++;
      }
      len = Math.max(len, rp - lp + 1);
      rp++;
    }
    return l - len;
  }

  private static boolean can(int[] map, int k) {
    if (map[0] >= k && map[1] >= k && map[2] >= k) return true;
    return false;
  }
}
