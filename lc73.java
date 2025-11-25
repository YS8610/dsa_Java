import java.util.Arrays;

public class lc73 {
  private static void setZeroes(int[][] matrix) {
    int lr = matrix.length;
    int lc = matrix[0].length;
    boolean[] row = new boolean[lr];
    boolean[] col = new boolean[lc];
    for (int r = 0; r < lr; r++) {
      for (int c = 0; c < lc; c++) {
        if (matrix[r][c] != 0)
          continue;
        row[r] = true;
        col[c] = true;
      }
    }
    for (int i = 0; i < lr; i++) {
      if (!row[i])
        continue;
      for (int c = 0; c < lc; c++)
        matrix[i][c] = 0;
    }
    for (int i = 0; i < lc; i++) {
      if (!col[i])
        continue;
      for (int r = 0; r < lr; r++)
        matrix[r][i] = 0;
    }
  }

  public static void main(String[] args) {
    int[][] matrix = { { 0, 1, 2, 0 }, { 3, 4, 5, 2 }, { 1, 3, 1, 5 } };
    setZeroes(matrix);
    System.out.println(Arrays.toString(matrix));

  }
}
