public class lc1399 {
  public int countLargestGroup(int n) {
    int[] map = new int[4 * 9 + 1];
    int big = 0;
    int ans = 0;
    for (int i = 1; i <= n; i++) {
      map[sumdigit(i)]++;
      big = Math.max(big, map[sumdigit(i)]);
    }
    for (int m : map)
      ans += m == big ? 1 : 0;
    return ans;
  }

  static private int sumdigit(int n) {
    int ans = 0;
    while (n / 10 != 0) {
      ans += n % 10;
      n /= 10;
    }
    ans += n % 10;
    return ans;
  }

}
