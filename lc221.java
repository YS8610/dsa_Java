public class lc221 {

  private static int maximalSquare(char[][] matrix) {
    int rlen = matrix.length;
    int clen = matrix[0].length;
    int[][] memo = new int[rlen][clen];
    memo[0][0] = Character.getNumericValue(matrix[0][0]);
    if (clen > 1) {
      for (int c = 1; c < clen; c++) {
        memo[0][c] = memo[0][c - 1] + Character.getNumericValue(matrix[0][c]) ;
      }
    }
    if (rlen > 1) {
      for (int r = 1; r < rlen; r++) {
        memo[r][0] = memo[r - 1][0] + Character.getNumericValue(matrix[r][0]);
      }
    }

    if (rlen > 1 && clen > 1) {
      for (int r = 1; r < rlen; r++) {
        for (int c = 1; c < clen; c++) {
          memo[r][c] =
            memo[r - 1][c] + memo[r][c - 1] + Character.getNumericValue(matrix[r][c]) - memo[r - 1][c - 1];
        }
      }
    }
    int ans = 1;
    int r1, c1;
    int sum;
    int maxArea=0;
    for (int r = 0; r < rlen; r++) {
      for (int c = 0; c < clen; c++) {
        r1 = r+ans;
        c1 = c+ans;
        if (matrix[r][c]=='1' && r1<rlen && c1<clen){
          maxArea = maxArea==0?1:maxArea;
          sum = lc221.sumRegion(memo, r, c, r1, c1);
          while (sum == Math.pow(ans+1, 2) ){
            maxArea = sum;
            r1++;
            c1++; 
            if (r1>=rlen || c1 >=clen) break;
            ans++;
            sum =lc221.sumRegion(memo, r, c, r1, c1);
          }
        }
        else if (matrix[r][c]=='1') maxArea = maxArea==0?1:maxArea;
      }
    }
    return maxArea;
  }

  private static int sumRegion(int[][] memo, int row1, int col1, int row2, int col2) {
    if (row1 == 0 && col1 == 0) {
      return memo[row2][col2];
    } else if (row1 == 0) {
      return memo[row2][col2] - memo[row2][col1 - 1];
    } else if (col1 == 0) {
      return memo[row2][col2] - memo[row1 - 1][col2];
    } else {
      return (
        memo[row2][col2] +
        memo[row1 - 1][col1 - 1] -
        memo[row1 - 1][col2] -
        memo[row2][col1 - 1]
      );
    }
  }

  public static void main(String[] args) {
    char[][] matrix = {
      { '1', '1', '1', '1', '0' },
      { '1', '1', '1', '1', '1' },
      { '1', '1', '1', '1', '1' },
      { '1', '1', '1', '1', '0' },
    };
    System.out.println(maximalSquare(matrix));
  }
}
