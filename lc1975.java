public class lc1975 {
  private static long maxMatrixSum(int[][] matrix) {
    Long sum=0l;
    int neg=0;
    boolean zero=false;
    int smallest=Math.abs(matrix[0][0]);
    for (int[] r : matrix){
      for (int n : r) {
        sum += Math.abs(n);
        smallest = Math.min(smallest, Math.abs(n));
        if (n==0) zero=true;
        if (n < 0) neg++;
      }
    }
    if (neg%2==0 || zero) return sum;
    return sum - 2*Math.abs(smallest);
  }

  public static void main(String[] args) {
    int[][] matrix = {{-8,-9,-10,1},{-5,-7,-10,-3},{-8,-4,-2,-6},{2,-1,8,-3}};
    System.out.println(maxMatrixSum(matrix));
  }
}
