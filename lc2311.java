public class lc2311 {
  public int longestSubsequence(String s, int k) {
    int l = s.length();
    int tmp = 0;
    int ans = 0;
    int[] table = new int[32];
    table[0] = 1;
    for (int i = 1; i < 32; i++)
      table[i] = table[i - 1] * 2;
    for (int i = l - 1; i >= 0; i--) {
      if (s.charAt(i) == '0') {
        ans++;
        continue;
      }
      if (ans >= 31 || tmp + table[ans] > k)
        continue;
      tmp += table[ans];
      ans++;
    }
    return ans;
  }
}
