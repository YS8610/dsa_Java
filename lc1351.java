
public class lc1351 {
  
  private static int countNegatives(int[][] grid){
    int n = grid.length;
    int m = grid[0].length;
    if (grid[0][0]<0) return n*m;
    if (grid[n-1][m-1]>=0) return 0;
    int counter=0;
    for ( int i=0;i<n;i++ ){
      for (int j=m-1;j>=0;j--){
        if (grid[i][j] < 0) counter++;
        else break;
      }
    }
    return counter;
  }

  public static void main(String[] args) {
    int[][] grid = {{5,1,0},{-5,-5,-5}};
    System.out.println( countNegatives(grid) );

  }
}
