import java.util.Arrays;

public class lc2316 {
  public long countPairs(int n, int[][] edges) {
    int[] par = new int[n];
    Arrays.fill(par, -1);
    int p1, p2;
    for (int[] e : edges) {
      p1 = findp(par, e[0]);
      p2 = findp(par, e[1]);
      if (p1 == p2)
        continue;
      if (p1 < p2) {
        par[p1] += par[p2];
        par[p2] = p1;
        continue;
      }
      par[p2] += par[p1];
      par[p1] = p2;
    }
    // path compression
    int grpno = 0;
    for (int i = 0; i < n; i++) {
      if (par[i] < 0) {
        grpno++;
        continue;
      }
      par[i] = findp(par, i);
    }
    if (grpno == 1)
      return 0;
    int[] grps = new int[grpno];
    grpno = 0;
    for (int p : par) {
      if (p < 0)
        grps[grpno++] = -p;
    }
    long ans = 0;
    int[] prefix = new int[grpno];
    prefix[grpno - 1] = grps[grpno - 1];
    for (int i = grpno - 2; i >= 0; i--)
      prefix[i] = prefix[i + 1] + grps[i];
    for (int i = 0, m = grpno - 1; i < m; i++)
      ans += (long) grps[i] * prefix[i + 1];
    return ans;
  }

  public int findp(int[] par, int i) {
    if (par[i] < 0)
      return i;
    return findp(par, par[i]);
  }
}
