public class lc3228 {
  public int maxOperations(String s) {
    int l = s.length();
    int ans = 0;
    for (int i = 0, sum = 0; i < l; i++) {
      if (s.charAt(i) == '1') {
        sum++;
        continue;
      }
      if (i - 1 >= 0 && s.charAt(i - 1) == '1')
        ans += sum;
    }
    return ans;
  }
}
