public class lc2351 {
  public char repeatedCharacter(String s) {
    int[] map = new int[26];
    int l = s.length();
    for (int i = 0; i < l; i++) {
      map[s.charAt(i) - 'a']++;
      if (map[s.charAt(i) - 'a'] >= 2)
        return s.charAt(i);
    }
    return s.charAt(0);
  }
}
