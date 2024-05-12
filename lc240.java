import java.util.Arrays;

public class lc240 {

  private static boolean searchMatrix(int[][] matrix, int target) {
    int rlen = matrix[0].length;
    int clen = matrix.length;
    if (
      matrix[0][0] > target || matrix[clen - 1][rlen - 1] < target
    ) return false;
    int[] t1 = new int[clen];
    int[] t2 = new int[clen];
    for (int i = 0; i < clen; i++) {
      t1[i] = matrix[i][0];
      t2[i] = matrix[i][rlen - 1];
    }
    int lowerBound = Arrays.binarySearch(t1, target);
    if (lowerBound >= 0) return true;
    int upperBound = Arrays.binarySearch(t2, target);
    if (upperBound >= 0) return true;
    lowerBound = lowerBound * -1 - 1;
    upperBound = upperBound * -1 - 1;
    for (int i = upperBound; i < lowerBound; i++) {
      if (Arrays.binarySearch(matrix[i], target) >= 0) return true;
    }
    return false;
  }

  public static void main(String[] args) {
    int[][] matrix = {
      { 1, 4, 4, 11, 15 },
      { 2, 5, 8, 12, 19 },
      { 3, 6, 9, 16, 22 },
      { 10, 13, 14, 17, 24 },
      { 18, 21, 23, 26, 30 },
    };
    // int[][] matrix = {{1},{2},{3},{10},{18}};
    int target = 9;
    System.out.println(searchMatrix(matrix, target));
  }
}
