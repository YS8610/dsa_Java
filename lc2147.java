public class lc2147 {
  public int numberOfWays(String corridor) {
    int l = corridor.length();
    int seat = 0;
    int plant = 1;
    long ans = 1;
    int MOD = 1000000007;
    int start = -1;
    while (++start < l && seat < 2)
      seat += corridor.charAt(start) == 'P' ? 0 : 1;
    for (int i = start; i < l; i++) {
      if (corridor.charAt(i) == 'P') {
        plant++;
        continue;
      }
      seat++;
      if (seat % 2 == 1)
        ans = (ans * plant) % MOD;
      else
        plant = 1;
    }
    if (seat == 0 || seat % 2 == 1)
      return 0;
    return (int) ans;
  }
}
