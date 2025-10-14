public class lc1482 {
  static public int minDays(int[] bloomDay, int m, int k) {
      int l = bloomDay.length;
    int lp = bloomDay[0];
    int rp = bloomDay[0];
    int ans = -1;
    if (Integer.compare(m*k, l) > 0)
      return ans;
    for (int b : bloomDay) {
      lp = Math.min(lp, b);
      rp = Math.max(rp, b);
    }
    int mp;
    while (lp < rp) {
      mp = (rp + lp) / 2;
      if (can(bloomDay, m, k, mp))
        rp = mp;
      else
        lp = mp + 1;
    }
    return lp;
  }

  private static boolean can(int[] bloomDay, int m, int k, int day) {
    int l = bloomDay.length;
    int bouquet = 0;
    out: for (int i = 0, tmp = k; i < l; i++) {
      if (bloomDay[i] > day)
        continue;
      tmp = k;
      for (int j = i, n = Math.min(i + k, l); j < n; j++) {
        if (bloomDay[j] > day) {
          i = j;
          continue out;
        }
        tmp--;
      }
      bouquet += tmp==0?1:0;
      i += k - 1;
    }
    if (bouquet >= m)
      return true;
    return false;
  }

  public static void main(String[] args){
    int[] bloomDay = {7,7,7,7,12,7,7};
    int m = 2, k = 3;
    System.out.println(minDays(bloomDay, m, k));
  }
}
