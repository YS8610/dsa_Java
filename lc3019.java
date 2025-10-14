public class lc3019 {
  public int countKeyChanges(String s) {
    int l = s.length();
    int ans = 0;
    int diff = 'a' - 'A';
    for (int i = 0, n = l - 1, tmp = 0; i < n; i++) {
      tmp = Math.abs(s.charAt(i) - s.charAt(i + 1));
      ans += (tmp == diff || tmp == 0) ? 0 : 1;
    }
    return ans;
  }
}
