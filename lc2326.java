public class lc2326 {

  public int[][] spiralMatrix(int m, int n, ListNode head) {
    int[][] ans = new int[m][n];

    int lp = 0, rp = n - 1;
    int up = 0, dp = m - 1;
    ListNode cp = head;
    while (lp != rp || up != dp) {
      // top row
      if (up != dp) {
        for (int i = lp; i <= rp; i++) {
          ans[up][i] = cp == null ? -1 : cp.val;
          cp = cp == null ? null : cp.next;
        }
        up++;
      } else {
        for (int i = lp; i <= rp; i++) {
          ans[up][i] = cp == null ? -1 : cp.val;
          cp = cp == null ? null : cp.next;
        }
        break;
      }
      // right col
      if (lp != rp) {
        for (int i = up; i <= dp; i++) {
          ans[i][rp] = cp == null ? -1 : cp.val;
          cp = cp == null ? null : cp.next;
        }
        rp--;
      } else {
        for (int i = up; i <= dp; i++) {
          ans[i][rp] = cp == null ? -1 : cp.val;
          cp = cp == null ? null : cp.next;
        }
        break;
      }
      // bottom row
      if (up != dp) {
        for (int i = rp; i >= lp; i--) {
          ans[dp][i] = cp == null ? -1 : cp.val;
          cp = cp == null ? null : cp.next;
        }
        dp--;
      } else {
        for (int i = rp; i >= lp; i--) {
          ans[dp][i] = cp == null ? -1 : cp.val;
          cp = cp == null ? null : cp.next;
        }
        break;
      }
      // left col
      if (lp != rp) {
        for (int i = dp; i >= up; i--) {
          ans[i][lp] = cp == null ? -1 : cp.val;
          cp = cp == null ? null : cp.next;
        }
        lp++;
      } else {
        for (int i = dp; i >= up; i--) {
          ans[i][lp] = cp == null ? -1 : cp.val;
          cp = cp == null ? null : cp.next;
        }
        break;
      }
    }
    if (n == m && n % 2 != 0) ans[n / 2][n / 2] = cp == null ? -1 : cp.val;
    return ans;
  }
}
