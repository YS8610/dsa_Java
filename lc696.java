public class lc696 {
  public int countBinarySubstrings(String s) {
    int l = s.length();
    int ans = 0;
    for (int i = 0, lp = 0, rp = 0, n = l - 1; i < n; i++) {
      if (s.charAt(i + 1) == s.charAt(i))
        continue;
      lp = i;
      rp = i + 1;
      while (lp >= 0 && rp < l && s.charAt(lp) == s.charAt(i) && s.charAt(rp) == s.charAt(i + 1)) {
        ans++;
        lp--;
        rp++;
      }
    }
    return ans;
  }
}
