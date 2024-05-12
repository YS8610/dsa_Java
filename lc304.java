public class lc304 {

  int[][] memo;

  public lc304(int[][] matrix) {
    int rlen = matrix.length;
    int clen = matrix[0].length;
    this.memo = new int[rlen][clen];
    this.memo[0][0] = matrix[0][0];
    if (clen > 1) {
      for (int c = 1; c < clen; c++) {
        this.memo[0][c] = this.memo[0][c - 1] + matrix[0][c];
      }
    }
    if (rlen > 1) {
      for (int r = 1; r < rlen; r++) {
        this.memo[r][0] = this.memo[r - 1][0] + matrix[r][0];
      }
    }

    if (rlen > 1 && clen > 1) {
      for (int r = 1; r < rlen; r++) {
        for (int c = 1; c < clen; c++) {
          this.memo[r][c] =
            this.memo[r - 1][c] +
            this.memo[r][c - 1] +
            matrix[r][c] -
            this.memo[r - 1][c - 1];
        }
      }
    }
  }

  public int sumRegion(int row1, int col1, int row2, int col2) {
    if (row1 == 0 && col1 == 0) {
      return this.memo[row2][col2];
    } else if (row1 == 0) {
      return this.memo[row2][col2] - this.memo[row2][col1 - 1];
    } else if (col1 == 0) {
      return this.memo[row2][col2] - this.memo[row1 - 1][col2];
    } else {
      return (
        this.memo[row2][col2] +
        this.memo[row1 - 1][col1 - 1] -
        this.memo[row1 - 1][col2] -
        this.memo[row2][col1 - 1]
      );
    }
  }

  public static void main(String[] args) {
    int[][] matrix = {
      {  8,-4, 5 },
      { -1, 4, 4 },
      { -2, 3, 1 },
      { -4, 4, 3 },
    };
    // int[][] matrix = { {3},{5},{1},{4},{1} };
    lc304 lc = new lc304(matrix);
    System.out.println(lc.sumRegion(0, 1, 0, 2));
  }
}
