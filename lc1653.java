public class lc1653 {

  private static int minimumDeletions(String s) {
    int len = s.length();
    if (len == 1) return 0;
    int[] map = new int[len];
    map[0] = s.charAt(0) == 'a' ? 1 : 0;
    for (int i = 1; i < len; i++) {
      if (s.charAt(i) == 'a') map[i] += map[i - 1] + 1; else map[i] =
        map[i - 1];
    }
    int ans = len;
    int leftB = 0;
    int rightA = 0;
    for (int i = 0; i < len; i++) {
      if (i == 0) leftB = 0; else leftB = i - (map[i - 1]);
      if (i == len - 1) rightA = 0; else rightA = map[len - 1] - map[i];
      ans = Math.min(ans, rightA + leftB);
    }
    return ans;
  }

  public static void main(String[] args) {
    String s = "aababbab";
    System.out.println(minimumDeletions(s));
  }
}
