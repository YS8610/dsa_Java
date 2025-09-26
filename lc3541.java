public class lc3541 {
  public int maxFreqSum(String s) {
    int[] freq = new int[26];
    int l = s.length();
    for (int i = 0; i < l; i++)
      freq[s.charAt(i) - 'a']++;
    int l1 = 0;
    int l2 = 0;
    for (int i = 0; i < 26; i++) {
      if (i == 'a' - 'a' || i == 'e' - 'a' || i == 'i' - 'a' || i == 'o' - 'a' || i == 'u' - 'a')
        l1 = Math.max(l1, freq[i]);
      else
        l2 = Math.max(l2, freq[i]);
    }
    return l1 + l2;
  }
}
