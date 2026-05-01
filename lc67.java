public class lc67 {
  public String addBinary(String a, String b) {
    if (a.equals("0") && b.equals("0"))
      return "0";
    int[] tmp = new int[Math.max(a.length(), b.length()) + 1];
    for (int i = a.length() - 1, l = tmp.length - 1; i >= 0; i--)
      tmp[l--] += a.charAt(i) - '0';
    for (int i = b.length() - 1, l = tmp.length - 1; i >= 0; i--)
      tmp[l--] += b.charAt(i) - '0';
    for (int i = tmp.length - 1; i > 0; i--) {
      if (tmp[i] <= 1)
        continue;
      tmp[i] -= 2;
      tmp[i - 1]++;
    }
    char[] ans;
    if (tmp[0] == 0) {
      ans = new char[tmp.length - 1];
      for (int i = 1; i < tmp.length; i++)
        ans[i - 1] = (char) (tmp[i] + '0');
    } else {
      ans = new char[tmp.length];
      for (int i = 0; i < tmp.length; i++)
        ans[i] = (char) (tmp[i] + '0');
    }
    return String.valueOf(ans);
  }
}
