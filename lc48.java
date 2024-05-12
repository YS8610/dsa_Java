import java.util.Arrays;

public class lc48 {

  private static void rotate(int[][] matrix) {
    int n = matrix.length;
    int lp = 0;
    int rp = n - 1;
    while (lp < rp) {
      for (int i = lp; i < rp; i++) {
        int temp = matrix[rp - (i-lp)][lp];
        // 4 sides
        matrix[rp - (i-lp)][lp] = matrix[rp][rp - (i-lp)];
        matrix[rp][rp - (i-lp)] = matrix[lp + (i-lp)][rp];
        matrix[lp + (i-lp)][rp] = matrix[lp][lp + (i-lp)];
        matrix[lp][lp + (i-lp)] = temp;
      }
      lp++;
      rp--;
    }
  }

  public static void main(String[] args) {
    int[][] matrix = {
      { 2,  29, 20, 26, 16, 28 },
      { 12, 27, 9,  25, 13, 21 },
      { 32, 33, 32, 2,  28, 14 },
      { 13, 14, 32, 27, 22, 26 },
      { 33, 1,  20, 7,  21, 7 },
      { 4,  24, 1,  6,  32, 34 },
    };
    rotate(matrix);
    System.out.println(Arrays.deepToString(matrix));
  }
}
