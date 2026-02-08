import java.util.Arrays;

public class lc85 {
  static public int maximalRectangle(char[][] matrix) {
    int lr = matrix.length;
    int lc = matrix[0].length;
    int maxArea = lr * lc;
    int[][] prefix = new int[lr][lc];
    int ans = 0;
    prefix[0][0] = matrix[0][0] - '0';
    // filling first row
    for (int c = 1; c < lc; c++)
      prefix[0][c] = (matrix[0][c] - '0') + prefix[0][c - 1];
    // filling first col
    for (int r = 1; r < lr; r++)
      prefix[r][0] = (matrix[r][0] - '0') + prefix[r - 1][0];
    // filling up the cells
    for (int r = 1; r < lr; r++) {
      for (int c = 1, tmp = 0; c < lc; c++) {
        tmp = prefix[r - 1][c] + prefix[r][c - 1] - prefix[r - 1][c - 1];
        prefix[r][c] = tmp + (matrix[r][c] - '0');
      }
    }
    if (prefix[lr - 1][lc - 1] == 0)
      return 0;
    if (prefix[lr - 1][lc - 1] == maxArea)
      return maxArea;
    // System.out.println(Arrays.deepToString(prefix));
    for (int r = 0; r < lr; r++) {
      for (int c = 0; c < lc; c++) {
        if (matrix[r][c] == '0')
          continue;
        ans = Math.max(ans, maxArea(matrix, prefix, r, c));
      }
    }
    return ans;
  }

  static public int maxArea(char[][] matrix, int[][] prefix, int row, int col) {
    int ans = 1;
    int lr = prefix.length;
    int lc = prefix[0].length;
    for (int r = row; r < lr; r++) {
      for (int c = col, area = 0; c < lc; c++) {
        if (r == row && c == col)
          continue;
        if (matrix[r][c] == '0')
          break;
        area = (Math.abs(row - r) + 1) * (Math.abs(col - c) + 1);
        if (area == count(prefix, row, col, r, c))
          ans = Math.max(ans, area);
      }
    }
    return ans;
  }

  static public int count(int[][] prefix, int r1, int c1, int r2, int c2) {
    if (r1 == 0 && c1 == 0)
      return prefix[r2][c2];
    if (r1 == 0)
      return prefix[r2][c2] - prefix[r2][c1 - 1];
    if (c1 == 0)
      return prefix[r2][c2] - prefix[r1 - 1][c2];
    return prefix[r2][c2] + prefix[r1 - 1][c1 - 1] - prefix[r2][c1 - 1] - prefix[r1 - 1][c2];
  }

  public static void main(String[] args) {
    char[][] matrix = {
        { '1', '0', '1', '0', '0' },
        { '1', '0', '1', '1', '1' },
        { '1', '1', '1', '1', '1' },
        { '1', '0', '0', '1', '0' }
    };
    System.out.println(maximalRectangle(matrix));
  }
}
