public class lc1010 {

  private static int numPairsDivisibleBy60(int[] time) {
    int l = time.length;
    int ans = 0;
    for (int i = 0; i < l; i++) time[i] %= 60;
    int[] map = new int[60];
    for (int t : time) map[t]++;
    int tmp;
    for (int t : time) {
      tmp = 60 - t;
      if (tmp == 60 || tmp == 30) {
        if (map[t] > 1) ans += map[t] - 1;
      } else ans += map[tmp];
      map[t] = Math.max(0, map[t] - 1);
    }
    return ans;
  }

  public static void main(String[] args) {
    int[] time = { 30, 20, 150, 100, 40 };
    System.out.println(numPairsDivisibleBy60(time));
  }
}
