public class lc1905 {
  private static boolean dfs(int[][] grid1, int[][] grid2, int r, int c){
    int lr = grid1[0].length;
    int lc = grid1.length;
    if (r < 0 || r >= lc || c < 0 || c >= lr) return true;
    if (grid2[r][c] == 1 && grid1[r][c] == 0) return false;
    if (grid2[r][c] == 2 || grid2[r][c] == 0) return true;
    grid2[r][c] = 2;
    boolean up = dfs(grid1, grid2, r-1, c);
    boolean down = dfs(grid1, grid2, r+1, c);
    boolean left = dfs(grid1, grid2, r, c-1);
    boolean right = dfs(grid1, grid2, r, c+1);
    return up && down && left && right;
  }
  
  private static int countSubIslands(int[][] grid1, int[][] grid2) {
    int ans = 0;
    for (int r = 0, n=grid1.length; r<n;r++){
      for (int c=0,m=grid1[0].length;c<m;c++){
        if (grid2[r][c] == 2 || grid2[r][c] == 0) continue;
        if (dfs(grid1, grid2, r, c)) ans++;
      }
    }
    return ans;
  }

  public static void main(String[] args) {
    int[][] grid1 = {
      {1,0,1,0,1},
      {1,1,1,1,1},
      {0,0,0,0,0},
      {1,1,1,1,1},
      {1,0,1,0,1}
    };
    int[][] grid2 = {
      {0,0,0,0,0},
      {1,1,1,1,1},
      {0,1,0,1,0},
      {0,1,0,1,0},
      {1,0,0,0,1}
    };
    System.out.println(countSubIslands(grid1, grid2));
  }
}
