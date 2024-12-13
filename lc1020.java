public class lc1020 {
  private static void dfs(int[][] grid, int r, int c){
    if (r <0 || c <0 || r>= grid.length||c>=grid[0].length) return ;
    if (grid[r][c] != 1) return;
    grid[r][c] = 2;
    dfs(grid, r+1, c);
    dfs(grid, r-1, c);
    dfs(grid, r, c-1);
    dfs(grid, r, c+1);
  }
  
  private static int numEnclaves(int[][] grid) {
    int lr = grid.length;
    int lc = grid[0].length;
    for (int c=0; c < lc; c++) {
      dfs(grid, 0, c);
      dfs(grid, lr-1, c);
    }
    for (int r=0; r <lr ; r++){
      dfs(grid, r, 0);
      dfs(grid, r, lc-1);
    }
    int ans = 0;
    for (int r=0; r < lr;r++){
      for (int c=0;c<lc;c++){
        if (grid[r][c] == 1) ans++;
      }
    }
    return ans;
  }

  public static void main(String[] args) {
    int[][] grid = {{0,1,1,0},{0,0,1,0},{0,0,1,0},{0,0,0,0}};
    System.out.println(numEnclaves(grid));
  }
}
