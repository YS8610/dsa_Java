public class lc2220 {

  private static int minBitFlips(int start, int goal) {
    int mask = 1;
    int diff = start ^ goal;
    int ans = 0;
    for (int i = 0; i < 31; i++) {
      if ((mask & diff) > 0) ans++;
      mask <<= 1;
    }
    return ans;
  }

  public static void main(String[] args) {
    int start = 10, goal = 7;
    System.out.println(minBitFlips(start, goal));
  }
}
