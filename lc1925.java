public class lc1925 {
  public int countTriples(int n) {
    int l = n * n;
    boolean[] sq = new boolean[l + 1];
    for (int i = 0; i <= n; i++)
      sq[i * i] = true;
    int ans = 0;
    for (int i = 1; i <= n; i++) {
      for (int j = i + 1, tmp = 0; j <= n; j++) {
        tmp = i * i + j * j;
        if (tmp > l)
          break;
        ans += sq[tmp] ? 2 : 0;
      }
    }
    return ans;
  }
}
