import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

class lc827{
  private static int largestIsland(int[][] grid) {
    int lr = grid.length; 
    int lc = grid[0].length; 
    int[][] idmap = new int[lr][lc];
    boolean[][] visited = new boolean[lr][lc];
    int tmp;
    int count = 0;
    // assign id to island
    for (int r=0;r<lr;r++){
      for (int c=0;c<lc;c++){
        if (grid[r][c] == 0 || idmap[r][c] != 0)
          continue;
        countIsland(grid, visited, idmap, r, c, ++count);
      }
    }
    for (boolean[] v :visited)
      Arrays.fill(v,false);
    // flood fill island with their area
    for (int r=0;r<lr;r++){
      for (int c=0;c<lc;c++){
        if (grid[r][c] == 0 || visited[r][c])
          continue;
        tmp = area(grid, r, c);
        dfs(grid, visited, r, c, tmp);
      }
    }
    int ans = 0;
    Set<Integer> set = new HashSet<>();
    for (int r=0;r<lr;r++){
      for (int c=0;c<lc;c++){
        if (grid[r][c] != 0)
          continue;
        set.clear();
        tmp = sumArea(grid, idmap, set, r+1, c)
            + sumArea(grid, idmap, set, r-1, c)
            + sumArea(grid, idmap, set, r, c+1)
            + sumArea(grid, idmap, set, r, c-1)
            + 1;
        ans = Math.max(ans, tmp);
      }
    }
    if (ans == 0)
      return lr*lc;
    return ans;
  }

  private static int sumArea(int[][] grid, int[][] idmap, Set<Integer> set, int r, int c){
    int lr = grid.length; 
    int lc = grid[0].length; 
    if (r < 0 || c <0 || r >= lr || c >= lc || set.contains(idmap[r][c]) || idmap[r][c] == 0)
      return 0;
    set.add(idmap[r][c]) ;
    return grid[r][c];
  }

  private static int area(int[][] grid, int r, int c){
    int lr = grid.length; 
    int lc = grid[0].length; 
    if (r < 0 || c <0 || r >= lr || c >= lc || grid[r][c] == 0 || grid[r][c] == 2)
     return 0;
    grid[r][c] = 2;
    int ans = area(grid, r+1, c)
            + area(grid, r-1, c)
            + area(grid, r, c+1)
            + area(grid, r, c-1)
            + 1;
    return ans;
  }

  private static void dfs(int[][] grid, boolean[][] visited, int r, int c, int a){
    int lr = grid.length; 
    int lc = grid[0].length; 
    if (r < 0 || c <0 || r >= lr || c >= lc || grid[r][c] == 0 || visited[r][c])
      return;
    grid[r][c] = a;
    visited[r][c] = true;
    dfs(grid, visited, r+1, c, a);
    dfs(grid, visited, r-1, c, a);
    dfs(grid, visited, r, c+1, a);
    dfs(grid, visited, r, c-1, a);
  }

  private static void countIsland(int[][] grid, boolean[][] visited, int[][] idmap, int r, int c, int count){
    int lr = grid.length; 
    int lc = grid[0].length; 
    if (r < 0 || c <0 || r >= lr || c >= lc || grid[r][c] == 0 || idmap[r][c] != 0)
      return;
    idmap[r][c]= count;
    visited[r][c] = true;
    countIsland(grid, visited, idmap, r-1, c, count);
    countIsland(grid, visited, idmap, r+1, c, count);
    countIsland(grid, visited, idmap, r, c-1, count);
    countIsland(grid, visited, idmap, r, c+1, count);
  }

  private static int largestIsland1(int[][] grid) {
    int lr = grid.length;
    int lc = grid[0].length;
    int[] map = new int[Math.max(lr*lc, 3)];
    int id = 2;
    for (int r = 0; r<lr; r++){
      for (int c =0; c<lc; c++){
        if (grid[r][c] != 1)
          continue;
        map[id] = getArea(grid, r, c, id);
        id++;
      }
    }
    Set<Integer> set = new HashSet<>();
    int ans = 0;
    int tmp;
    for (int r = 0; r<lr; r++){
      for (int c =0; c<lc; c++){
        if (grid[r][c] != 0)
          continue;
        set.clear();
        tmp = connect(grid, map, set, r+1, c)
            + connect(grid, map, set, r-1, c)
            + connect(grid, map, set, r, c+1)
            + connect(grid, map, set, r, c-1)
            + 1;
        ans = Math.max(ans, tmp);
      }
    }
    return ans==0?lr*lc:ans;
  }

  private static int getArea(int[][] grid, int r, int c, int id){
    int lr = grid.length; 
    int lc = grid[0].length; 
    if (r < 0 || c <0 || r >= lr || c >= lc || grid[r][c] != 1)
      return 0;
    grid[r][c] = id;
    return  getArea(grid, r+1, c, id)
          + getArea(grid, r-1, c, id)
          + getArea(grid, r, c+1, id)
          + getArea(grid, r, c-1, id)
          + 1;
  }

  private static int connect(int[][] grid, int[] map, Set<Integer> set, int r, int c){
    int lr = grid.length; 
    int lc = grid[0].length; 
    if (r < 0 || c <0 || r >= lr || c >= lc || set.contains(grid[r][c]))
      return 0;
    set.add(grid[r][c]);
    return map[grid[r][c]];
  }


  public static void main(String[] args){
    int[][] grid = {
      {1,1,0,1,1},
      {1,0,0,0,1},
      {1,0,1,0,0},
      {1,0,1,0,1},
      {1,1,1,0,1},
    };
    System.out.println(largestIsland(grid));
    // System.out.println(largestIsland1(grid));
  }

}
