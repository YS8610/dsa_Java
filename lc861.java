public class lc861 {
  private static int matrixScore(int[][] grid) {
    int lr = grid.length;
    int lc = grid[0].length;
    for (int r = 0;r<lr;r++){
      if (grid[r][0] == 0) {
        for (int c=0;c<lc;c++){
          grid[r][c] = grid[r][c]==1?0:1;
        }
      }
    }
    int total;
    for (int c = 0; c<lc;c++){
      total = 0;
      for (int r = 0; r< lr;r++){
        if (grid[r][c]==1) total++;
      }
      if (lr - total > total){
        grid[0][c] = lr - total;
      }
      else grid[0][c] =total;
    }
    int mask = 1;
    for (int i = lc-2;i>=0;i--){
      mask <<=1;
      grid[0][i] *= mask; 
    }
    int ans = 0;
    for (int a : grid[0]) ans+= a;
    return ans; 
  }

  public static void main(String[] args) {
    int[][] grid = {{0,0,1,1},{1,0,1,0},{1,1,0,0}};
    System.out.println(matrixScore(grid));
  }
}
