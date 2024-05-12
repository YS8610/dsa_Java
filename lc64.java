public class lc64 {
  private static int minPathSum(int[][] grid){
    int rlen = grid.length;
    int clen = grid[0].length;
    if (rlen==1 && clen==1 ) return grid[0][0];
    int[][] memo = new int[rlen][clen];
    memo[0][0] = grid[0][0];

    for (int i=1;i<clen;i++) memo[0][i] =  memo[0][i-1] + grid[0][i];
    for (int j=1;j<rlen;j++) memo[j][0] += memo[j-1][0] + grid[j][0];

    for (int r=1; r<rlen;r++){
      for(int c=1; c<clen;c++){
        memo[r][c]= Math.min( memo[r-1][c], memo[r][c-1]) + grid[r][c];
      }
    }
    return memo[rlen-1][clen-1];
  }

  public static void main(String[] args) {
    int[][] grid = {{1,3,1},{1,5,1},{4,2,1}};
    System.out.println( minPathSum(grid));
    // System.out.println( help(grid.length,grid[0].length, grid));
  }
}
