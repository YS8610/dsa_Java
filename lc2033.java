import java.util.Arrays;

public class lc2033 {
  static public int minOperations(int[][] grid, int x) {
    int mod = grid[0][0] % x;
    int r = grid.length;
    int c = grid[0].length;
    int l = r * c;
    if (l==1) return 0;
    int[] tmp = new int[l];
    for (int row = 0, i = 0; row < r; row++) {
      for (int col = 0; col < c; col++) {
        tmp[i++] = grid[row][col];
        if (grid[row][col] % x != mod)
          return -1;
      }
    }
    Arrays.sort(tmp);
    int[] prefix = new int[l];
    int[] suffix = new int[l];
    prefix[0] = tmp[0];
    suffix[l - 1] = tmp[l - 1];
    for (int i = 1, j = l - 2; i < l && j >= 0; i++, j--) {
      prefix[i] = prefix[i - 1] + tmp[i];
      suffix[j] = suffix[j + 1] + tmp[j];
    }
    int ans = Integer.MAX_VALUE;
    for (int i = 0; i < l; i++) {
      if (i == 0) {
        ans = Math.min(ans, (suffix[1] - tmp[0] * (l-1)) / x);
        continue;
      }
      if (i == l - 1) {
        ans = Math.min(ans, (tmp[l - 1] * (l-1) - prefix[l-2]) / x);
        continue;
      }
      ans = Math.min(ans, (tmp[i]*i - prefix[i-1] ) / x + (suffix[i + 1] - tmp[i]*(l-i-1)) / x);
    }
    return ans;
  }

  public static void main(String[] args) {
    int[][] grid = {{2,4},{6,8}};
    int x = 2;
    System.out.println(minOperations(grid, x));
  }
}
