import java.util.Arrays;

public class lc3713 {
  public int longestBalanced(String s) {
    int l = s.length();
    int[] freq = new int[26];
    int ans = 1;
    for (int i = 0, n = l - 1; i < n; i++) {
      Arrays.fill(freq, 0);
      freq[s.charAt(i) - 'a']++;
      for (int j = i + 1; j < l; j++) {
        freq[s.charAt(j) - 'a']++;
        ans = can(freq) ? Math.max(ans, j - i + 1) : ans;
      }
    }
    return ans;
  }

  public boolean can(int[] freq) {
    for (int i = 0, tmp = 0; i < 26; i++) {
      if (freq[i] == 0)
        continue;
      tmp = tmp == 0 ? freq[i] : tmp;
      if (tmp != freq[i])
        return false;
    }
    return true;
  }
}
