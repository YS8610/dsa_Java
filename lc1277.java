public class lc1277 {
  private static int countSquares(int[][] matrix) {
    int ans = 0;
    for (int r=0, n=matrix.length;r<n;r++){
      for (int c=0, m=matrix[0].length;c<m;c++){
        if (matrix[r][c] == 0) continue;
        ans++;
        int r1 = r;
        int c1 = c;
        out:
        while (++r1 <n && ++c1 <m){
          if (matrix[r1][c1] == 0) break out;
            for (int i =r;i<r1;i++)
              if (matrix[i][c1] == 0) break out;
            for (int i=c;i<c1;i++)
              if (matrix[r1][i] == 0) break out;
            ans++;
        }
      }
    };
    return ans;
  }

  public static void main(String[] args) {
    int[][] matrix = {
      {0,1,1,1},
      {1,1,1,1},
      {0,1,1,1}
    };
    System.out.println(countSquares(matrix));
  }
}
