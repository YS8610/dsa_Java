import java.util.Arrays;
import java.util.HashSet;
import java.util.LinkedList;
import java.util.Queue;
import java.util.Set;

public class lc1034 {
  private static void dfs(int[][] grid, boolean[][] visit, int srcColor, int r, int c, int color){
    int lr = grid.length;
    int lc = grid[0].length;
    if (r < 0 || c <0|| r>=lr || c>=lc || grid[r][c] != srcColor) return;
    if (visit[r][c] || grid[r][c] != srcColor) return;
    visit[r][c] = true;
    if (r==0 || c==0 || r == lr-1 || c==lc-1
    || grid[r-1][c] != srcColor
    || grid[r+1][c] != srcColor
    || grid[r][c+1] != srcColor
    || grid[r][c-1] != srcColor
    )
      grid[r][c] = color;
    dfs(grid, visit, srcColor, r+1, c, color);
    dfs(grid, visit, srcColor, r-1, c, color);
    dfs(grid, visit, srcColor, r, c+1, color);
    dfs(grid, visit, srcColor, r, c-1, color);
  }

  private static int[][] colorBorder1(int[][] grid, int row, int col, int color) {
    int lr = grid.length;
    int lc = grid[0].length;
    boolean[][] visit =new boolean[lr][lc];
    dfs(grid, visit, grid[row][col], row, col, color);
    return grid;
  }

  private static int[][] colorBorder(int[][] grid, int row, int col, int color) {
    Queue<int[]> q = new LinkedList<>();
    int lr = grid.length;
    int lc = grid[0].length;
    boolean[][] visit =new boolean[lr][lc];
    q.add(new int[]{row, col});
    int[] tmp;
    int r, c;
    int srcColor = grid[row][col];
    Set<Integer> set = new HashSet<>();
    set.add(color);
    set.add(srcColor);
    while (!q.isEmpty()){
      for (int i=0, n=q.size();i<n;i++){
        tmp = q.poll();
        r = tmp[0];
        c = tmp[1];
        if (r < 0 || c <0|| r>=lr || c>=lc || grid[r][c] != srcColor)
          continue;
        if (visit[r][c]) continue;
        visit[r][c] = true;
        if (r==0 || c==0 || r== lr-1 || c==lc-1
        || !set.contains(grid[r+1][c])
        || !set.contains(grid[r-1][c]) 
        || !set.contains(grid[r][c+1]) 
        || !set.contains(grid[r][c-1]) )
          grid[r][c] = color;
        q.add(new int[]{r-1,c});
        q.add(new int[]{r+1,c});
        q.add(new int[]{r,c-1});
        q.add(new int[]{r,c+1});
      }
    }
    return grid;
  } 

  public static void main(String[] args) {
    int[][] grid = {
      {1,2,1,2,1,2},
      {2,2,2,2,1,2},
      {1,2,2,2,1,2}
    };
    int row = 1, col = 3, color = 1;
    System.out.println(Arrays.deepToString(colorBorder1(grid, row, col, color)));
  }
}
