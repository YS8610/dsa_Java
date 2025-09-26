public class lc424 {
  public int characterReplacement(String s, int k) {
    int l = s.length();
    int lp = 0, rp = 0;
    int ans = Math.min(1 + k, l);
    int[] map = new int[26];
    int len, diff;
    while (lp < l) {
      // move rp
      if (rp == 0)
        map[s.charAt(rp) - 'A']++;
      while (rp < l && rp - lp + 1 <= map[s.charAt(lp) - 'A'] + k) {
        ans = Math.max(rp - lp + 1, ans);
        rp++;
        if (rp < l)
          map[s.charAt(rp) - 'A']++;
      }
      len = rp < l ? rp - lp + 1 : rp - lp;
      diff = map[s.charAt(lp) - 'A'] + k - len;
      if (diff > 0)
        ans = Math.max(ans, len + Math.min(diff, lp));
      map[s.charAt(lp) - 'A']--;
      lp++;
    }
    return ans;
  }
}
