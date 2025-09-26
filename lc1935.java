public class lc1935 {
  public int canBeTypedWords(String text, String brokenLetters) {
    boolean[] map = new boolean[26];
    int ans = 0;
    int l = text.length();
    int lp = 0, rp = 0;
    boolean isBroken = false;
    for (int i = 0, len = brokenLetters.length(); i < len; i++)
      map[brokenLetters.charAt(i) - 'a'] = true;
    while (lp < l) {
      rp = lp;
      isBroken = false;
      while (rp < l && text.charAt(rp) != ' ') {
        if (map[text.charAt(rp) - 'a'])
          isBroken = true;
        rp++;
      }
      ans += isBroken ? 0 : 1;
      lp = rp + 1;
    }
    return ans;
  }
}
