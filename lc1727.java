import java.util.Arrays;

public class lc1727 {
  public int largestSubmatrix(int[][] matrix) {
    int lr = matrix.length;
    int lc = matrix[0].length;
    int[][] prefix = new int[lr][lc];
    int ans = 0;
    for (int c = 0; c < lc; c++) {
      for (int r = 0, tmp = 0; r < lr; r++) {
        if (matrix[r][c] == 0) {
          tmp = 0;
          prefix[r][c] = 0;
          continue;
        }
        tmp++;
        prefix[r][c] = tmp;
      }
    }
    for (int r = 0; r < lr; r++) {
      Arrays.sort(prefix[r]);
      // System.out.println(Arrays.deepToString(prefix));
      for (int c = lc - 1; c >= 0; c--) {
        ans = Math.max(ans, prefix[r][c] * (lc - c));
        if (prefix[r][c] == 0)
          break;
      }
    }
    return ans;
  }
}
