class lc2658{
  private static int findMaxFish(int[][] grid) {
    int ans = 0;
    int lr = grid.length;
    int lc = grid[0].length;
    for (int r=0; r<lr;r++)
      for (int c=0;c<lc;c++)
        if (grid[r][c]!=0)
          ans = Math.max(ans, dfs(grid, r, c));
    return ans;
  }

  private static int dfs(int[][] grid, int r, int c){
    int lr = grid.length;
    int lc = grid[0].length;
    if (r < 0 || c < 0 || r >= lr || c >= lc || grid[r][c] == 0)
      return 0;
    int ans = grid[r][c]; 
    grid[r][c] = 0;
    ans += dfs(grid, r+1, c)
         + dfs(grid, r-1, c)
         + dfs(grid, r, c+1)
         + dfs(grid, r, c-1);
    return ans;
  }

  public static void main(String[] args){
    int[][] grid = {{4}};
    System.out.println(findMaxFish(grid));
  }
}
