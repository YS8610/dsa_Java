public class lc2226 {

  private static boolean can(int g, int[] candies, long k) {
    for (int c : candies) k -= c / g;
    return k <= 0;
  }

  public int maximumCandies(int[] candies, long k) {
    long sum = 0;
    int max = candies[0];
    for (int c : candies) {
      sum += c;
      max = Math.max(c, max);
    }
    if (sum < k) return 0;
    if (sum == k) return 1;
    int lp = 1;
    int rp = max;
    int m = 0;
    while (lp < rp) {
      m = (rp - lp) / 2 + lp;
      if (can(m, candies, k)) lp = m + 1; else rp = m - 1;
    }
    return can(lp, candies, k) ? lp : lp - 1;
  }
}
