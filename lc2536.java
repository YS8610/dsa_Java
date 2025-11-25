public class lc2536 {
  public int[][] rangeAddQueries(int n, int[][] queries) {
    int[][] ans = new int[n][n];
    for (int[] q : queries) {
      for (int r = q[0]; r <= q[2]; r++) {
        ans[r][q[1]] += 1;
        if (q[3] + 1 >= n)
          continue;
        ans[r][q[3] + 1] -= 1;
      }
    }
    for (int[] r : ans) {
      for (int c = 0, tmp = 0; c < n; c++) {
        tmp += r[c];
        r[c] = tmp;
      }
    }
    return ans;
  }
}
