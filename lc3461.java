public class lc3461 {
  public boolean hasSameDigits(String s) {
    int l = s.length();
    char[] list = s.toCharArray();
    int n1, n2;
    while (l > 2) {
      for (int i = 0, n = l - 1; i < n; i++) {
        n1 = (int) (list[i] - '0');
        n2 = (int) (list[i + 1] - '0');
        list[i] = (char) ((n1 + n2) % 10 + '0');
      }
      l--;
    }
    return list[0] == list[1];
  }
}
