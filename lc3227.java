public class lc3227 {
  public boolean doesAliceWin(String s) {
    int l = s.length();
    int vowel = 0;
    boolean[] v = new boolean[26];
    v['a' - 'a'] = true;
    v['e' - 'a'] = true;
    v['i' - 'a'] = true;
    v['o' - 'a'] = true;
    v['u' - 'a'] = true;
    for (int i = 0; i < l; i++)
      vowel += v[s.charAt(i) - 'a'] ? 1 : 0;
    if (vowel == 0)
      return false;
    return true;
  }
}
