public class lc1572 {
  private static int diagonalSum(int[][] mat) {
    int ans=0;
    if (mat.length==1) return mat[0][0];

    for (int i=0, n =mat.length; i<n; i++ ){
      ans += mat[i][i] + mat[i][n-1-i];
      if (i == n-1-i) ans -= mat[i][i];
    }

    return ans;
  }
  
  public static void main(String[] args) {
    int[][] mat =  {{7,3,1,9},
                    {3,4,6,9},
                    {6,9,6,6},
                    {9,5,8,5}};
    System.out.println( diagonalSum(mat));

  }
}
