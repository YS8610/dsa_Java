import java.util.Arrays;

class lc1368{
  private static int minCost(int[][] grid) {
    int lr = grid.length;
    int lc = grid[0].length;
    int[][] info = new int[][]{
      {0,0},
      {0,1},
      {0,-1},
      {1,0},
      {-1,0},
    };
    int[][][] memo = new int[lr][lc][4];
    for (int r = 0; r<lr;r++)
      for (int c= 0; c<lc;c++)
        Arrays.fill(memo[r][c], Integer.MAX_VALUE);


    return 0;
  }

  private static int dfs(int[][] grid, int[][] info, int r, int c, int prev){
    int lr = grid.length;
    int lc = grid[0].length;
    if (r < 0 || c < 0|| r >=lr || c >=lc)
      return Integer.MAX_VALUE;
    int ans = Integer.MAX_VALUE;
    for (int i = 1; i<=4;i++){
      if (prev == 1 && i == 2) continue; 
      if (prev == 2 && i == 1) continue; 
      if (prev == 3 && i == 4) continue; 
      if (prev == 4 && i == 3) continue; 
      ans = Math.min(ans, dfs(grid, info, lr+info[grid[r][c]][0], lc+info[grid[r][c]][1], grid[r][c]) );
    }
    return ans;
  }

  public static void main(String[] args) {
    int[][] grid = {
      {1,1,1,1},
      {2,2,2,2},
      {1,1,1,1},
      {2,2,2,2}
    };
    System.out.println(minCost(grid));
  }
}