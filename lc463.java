import java.util.ArrayDeque;
import java.util.Deque;
import java.util.HashSet;
import java.util.List;
import java.util.Set;


public class lc463 {

  private static int sides(int[][] grid, int r, int c){
    int lenR = grid.length;
    int lenC = grid[0].length;
    int sides = 0;
    return 0;
  }
  
  private static  int islandPerimeter(int[][] grid){
    Deque<List<Integer>> stack = new ArrayDeque<>();
    Set<List<Integer>> visited = new HashSet<>();
    int ans = 0;
    int n = grid.length;
    int m = grid[0].length;
    boolean done = false;
    for(int i=0;i<n;i++){
      for (int j=0;j<m;j++){
        
        if (grid[i][j] ==1 && !visited.contains(List.of(i,j)) ){
          stack.add(List.of(i, j));
        }
        while (!stack.isEmpty()){
          List<Integer> coor = stack.pop();
          int row = coor.get(0);
          int col = coor.get(1);
          if (visited.contains(List.of(row, col))) continue;
          visited.add( List.of(row,col) );
          int side = 4;
          if (row>0 && grid[row-1][col]==1 )  {
            if ( !visited.contains(List.of(row-1, col)) ) stack.add( List.of(row-1, col ) );
            side--;
          }
          if (row<n-1 && grid[row+1][col]==1 ){
            if ( !visited.contains(List.of(row+1, col)) ) stack.add(List.of(row+1,col));
            side--;
          }
          if (col>0 && grid[row][col-1]==1 ){
            if ( !visited.contains(List.of(row, col-1)) ) stack.add(List.of(row,col-1));
            side--;
          }
          if (col<m-1 && grid[row][col+1]==1 ){
            if ( !visited.contains(List.of(row, col+1)) ) stack.add(List.of(row,col+1));
            side--;
          }
          ans+=side;
          done = true;
        }
        if (done) return ans;
      }
    }
    return ans;
  }

  // BFS and DFS
  public static void main(String[] args) {
    int[][] grid = {{1,1,0,0},{1,1,1,0},{1,1,0,0},{1,1,0,0}};
    System.out.println( islandPerimeter(grid) );
  }
}
