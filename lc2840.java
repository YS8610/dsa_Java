public class lc2840 {
  public boolean checkStrings(String s1, String s2) {
    int[] feven = new int[26];
    int[] fodd = new int[26];
    int l = s1.length();
    for (int i = 0; i < l; i++) {
      if (i % 2 == 0)
        feven[s1.charAt(i) - 'a']++;
      else
        fodd[s1.charAt(i) - 'a']++;
    }
    for (int i = 0; i < l; i++) {
      if (i % 2 == 0)
        feven[s2.charAt(i) - 'a']--;
      else
        fodd[s2.charAt(i) - 'a']--;
    }
    for (int i = 0; i < 26; i++)
      if (feven[i] != 0 || fodd[i] != 0)
        return false;
    return true;
  }
}
