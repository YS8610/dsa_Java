public class lc395 {
  public int longestSubstring(String s, int k) {
    return redo(s, k, 0, s.length());
  }

  // start inclusive, end exclusive
  public int redo(String s, int k, int start, int end) {
    if (end - start < k)
      return 0;
    int[] map = new int[26];
    for (int i = start; i < end; i++)
      map[s.charAt(i) - 'a']++;
    if (can(map, k))
      return end - start;
    int ans = 0;
    int lp = start, rp = start;
    while (lp < end) {
      if (map[s.charAt(lp) - 'a'] < k) {
        rp = ++lp;
        continue;
      }
      // move rp
      while (rp < end && map[s.charAt(rp) - 'a'] >= k)
        rp++;
      ans = Math.max(ans, redo(s, k, lp, rp));
      lp = rp;
    }
    return ans;
  }

  public boolean can(int[] map, int k) {
    for (int m : map)
      if (m > 0 && m < k)
        return false;
    return true;
  }
}