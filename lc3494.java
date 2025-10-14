class lc3494 {
  public static long minTime(int[] skill, int[] mana) {
    int n = skill.length;
    int m = mana.length;
    long[] avail = new long[n];
    long stime = 0;
    avail[0] = (long) skill[0] * mana[0];
    for (int i = 1; i < n; i++)
      avail[i] = avail[i - 1] + skill[i] * mana[0];
    for (int p = 1; p < m; p++) {
      stime = minstime(avail, skill, mana, p);
      avail[0] = stime + (long) skill[0] * mana[p];
      for (int w = 1; w < n; w++)
        avail[w] = avail[w - 1] + ((long) skill[w] * mana[p]);
    }
    return avail[n - 1];
  }

  public static long minstime(long[] avail, int[] skill, int[] mana, int m) {
    int l = avail.length;
    long lp = avail[0];
    long rp = avail[l - 1];
    long mp;
    while (lp < rp) {
      mp = (lp + rp) / 2;
      if (can(avail, skill, mana, m, mp))
        rp = mp;
      else
        lp = mp + 1;
    }
    return lp;
  }

  public static boolean can(long[] avail, int[] skill, int[] mana, int m, long starttime) {
    if (starttime < avail[0])
      return false;
    for (int w = 1, n = skill.length; w < n; w++) {
      starttime += skill[w - 1] * mana[m];
      if (avail[w] > starttime)
        return false;
    }
    return true;
  }

  public static void main(String[] args) {
    int[] skill = { 1, 3, 4 };
    int[] mana = { 2, 3, 3, 3 };
    System.out.println(minTime(skill, mana));
  }
}