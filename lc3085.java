public class lc3085 {
  public int minimumDeletions(String word, int k) {
    int[] map = new int[26];
    int l = word.length();
    int ans = word.length();
    for (int i = 0; i < l; i++)
      map[word.charAt(i) - 'a']++;
    for (int i = 0, tmp = 0; i < 26; i++) {
      if (map[i] == 0)
        continue;
      tmp = 0;
      for (int j = 0; j < 26; j++) {
        if (map[i] == map[j] || map[j] == 0)
          continue;
        if (map[i] > map[j])
          tmp += map[j];
        else
          tmp += Math.max(0, map[j] - map[i] - k);
      }
      ans = Math.min(ans, tmp);
    }
    return ans;
  }
}
