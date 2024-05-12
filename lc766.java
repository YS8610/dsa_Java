public class lc766 {
  private static boolean isToeplitzMatrix(int[][] matrix){
    int rlen = matrix.length;
    int clen = matrix[0].length;
    // travel right 1st row
    for (int c=0; c<clen;c++){
      int no = matrix[0][c];
      for(int r=0; r<rlen;r++){
        if (r+c<clen &&matrix[r][r+c]!=no) return false;
      }
    }
    // travel down 1st col
    for (int r=1; r<rlen;r++){
      int no = matrix[r][0];
      for (int c=0;c<clen;c++){
        if (r+c<rlen && matrix[r+c][c]!=no) return false;
      }
    }
    return true;
  }

  public static void main(String[] args) {
    int[][] matrix = {
      {1,2,3,4},
      {5,1,2,3},
      {9,5,1,2},
      {1,9,5,1}
    };
    System.out.println( isToeplitzMatrix(matrix) );
  }
}
