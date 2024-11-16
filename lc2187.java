public class lc2187 {

  private static long trip(int[] time, long t) {
    long ans = 0;
    for (int ti : time) ans += t / ti;
    return ans;
  }

  public long minimumTime(int[] time, int totalTrips) {
    if (time.length == 1) return time[0] * (long) totalTrips;
    int min = time[0];
    for (int t : time) min = Math.min(min, t);
    long rp = totalTrips * (long) min;
    long lp = min;
    long m = 0;
    long tmp;
    while (lp < rp) {
      m = (rp - lp) / 2 + lp;
      tmp = trip(time, m);
      if (tmp >= totalTrips) rp = m; else lp = m + 1;
    }
    return lp;
  }
}
