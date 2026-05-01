public class lc1784 {
  public boolean checkOnesSegment(String s) {
    int l = s.length();
    int count = 0;
    for (int i = 0, tmp = 0; i < l; i++) {
      if (s.charAt(i) == '0') {
        tmp = 0;
        continue;
      }
      tmp++;
      count += tmp == 1 ? 1 : 0;
      if (count > 2)
        return false;
    }
    return count == 1;
  }
}
