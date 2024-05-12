public class lc3142 {
  private static boolean satisfiesConditions(int[][] grid) {
    int lr = grid.length;
    int lc = grid[0].length;
    for(int c=0;c<lc;c++){
      for (int r=1;r<lr;r++){
        if (grid[r][c]!=grid[0][c]) return false;
      }
    }
    for (int c=0;c<lc-1;c++){
      if (grid[0][c]==grid[0][c+1]) return false;
    }
    return true;
  }

  public static void main(String[] args) {
    int[][] grid = {{1,1,1},{0,0,0}};
    System.out.println(satisfiesConditions(grid));
  }
}
