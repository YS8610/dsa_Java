import java.util.Arrays;

public class lc2528 {
  static public long maxPower(int[] stations, int r, int k) {
    int l = stations.length;
    long[] pow = new long[l];
    long[] add = new long[l + 1];
    for (int i = 0; i < l; i++) {
      pow[Math.max(0, i - r)] += stations[i];
      if (i + r + 1 < l)
        pow[i + r + 1] -= stations[i];
    }
    long tmp = 0;
    for (int i = 0; i < l; i++) {
      tmp += pow[i];
      pow[i] = tmp;
    }
    long low = pow[0];
    for (int i = 0; i < l; i++)
      low = Math.min(low, pow[i]);
    long high = low + k;
    long lp = low, rp = high;
    long mp;
    while (lp < rp) {
      mp = (lp + rp + 2 - 1) / 2l;
      if (!can(pow, add, mp, k, r))
        rp = mp - 1;
      else
        lp = mp;
    }
    return lp;
  }

  static public boolean can(long[] pow, long[] add, long p, int k, int r) {
    Arrays.fill(add, 0);
    long window = 0;
    long diff, cur;
    for (int i = 0, n = pow.length; i < n; i++) {
      window += add[i];
      cur = pow[i] + window;
      if (cur >= p)
        continue;
      diff = p - cur;
      k -= diff;
      if (k < 0)
        return false;
      window += diff;
      if (i + 2 * r + 1 < n)
        add[i + 2 * r + 1] -= diff;
    }
    return true;
  }

  public static void main(String[] args) {
    int[] stations = { 13, 12, 8, 14, 7 };
    int r = 2, k = 23;
    System.out.println(maxPower(stations, r, k));
  }
}
