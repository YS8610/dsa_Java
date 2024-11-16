public class lc2938 {

  private static long minimumSteps(String s) {
    int l = s.length();
    long ans = 0;
    int tmp = 0;
    int rp = l - 1;
    while (rp >= 0) {
      if (s.charAt(rp) == '1') {
        rp--;
        ans += tmp;
        continue;
      }
      tmp++;
      rp--;
    }
    return ans;
  }

  public static void main(String[] args) {
    String s = "100";
    System.out.println(minimumSteps(s));
  }
}
