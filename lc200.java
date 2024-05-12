import java.util.ArrayDeque;
import java.util.Deque;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

class lc200{
  private static int numIslands(char[][] grid) {
    Deque<List<Integer>> stack = new ArrayDeque<>();
    Set<List<Integer>> visited = new HashSet<>();
    int ans = 0;
    int rowLen = grid.length;
    int colLen = grid[0].length;
    // searching for 1 using nested for loop
    for (int row=0;row<rowLen;row++){
      for (int col=0; col<colLen;col++){
        // skip if coor is already searched
        if (visited.contains(List.of(row, col))) continue;
        if ( grid[row][col]==('1') ){
          stack.add(List.of(row, col));
          ans++;
        }
        Set<List<Integer>> added = new HashSet<>();
        while(!stack.isEmpty()){
          List<Integer> coor = stack.pop();
          visited.add(coor);
          int r = coor.get(0);
          int c = coor.get(1);
          added.add(List.of(r,c));
          if (r>0 && grid[r-1][c]=='1'){
            List<Integer> loc = List.of(r-1,c);
            if ( !visited.contains(loc) ){
              if ( !added.contains(loc) ){
                stack.add(loc);
                added.add(loc);
              }
            }
          }
          if (r<rowLen-1 && grid[r+1][c]=='1'){
            List<Integer> loc = List.of(r+1,c);
            if ( !visited.contains(loc) ){
              if ( !added.contains(loc) ){
                stack.add(loc);
                added.add(loc);
              }
            }
          }
          if (c>0 && grid[r][c-1]=='1'){
            List<Integer> loc = List.of(r,c-1);
            if ( !visited.contains(loc) ){
              if ( !added.contains(loc) ){
                stack.add(loc);
                added.add(loc);
              }
            }
          }
          if (c<colLen-1 && grid[r][c+1]=='1'){
            List<Integer> loc = List.of(r,c+1);
            if ( !visited.contains(loc) ){
              if ( !added.contains(loc) ){
                stack.add(loc);
                added.add(loc);
              }
            }
          }
          // if (c<colLen-1 && grid[r][c+1]=='1'){
          //   if ( !visited.contains(List.of(r, c+1)) ) stack.add(List.of(r, c+1));
          // }
        }
      }
    }
    return ans;
  }


  private static int numIslands1(char[][] grid) {
    Deque<List<Integer>> stack = new ArrayDeque<>();
    int ans = 0;
    int rowLen = grid.length;
    int colLen = grid[0].length;
    // searching for 1 using nested for loop
    for (int row=0;row<rowLen;row++){
      for (int col=0; col<colLen;col++){
        // skip if coor is already searched
        if ( grid[row][col]==('1') ){
          stack.add(List.of(row, col));
          ans++;
        }
        while(!stack.isEmpty()){
          List<Integer> coor = stack.pollFirst();
          int r = coor.get(0);
          int c = coor.get(1);
          grid[r][c]='0';
          if (r>0 && grid[r-1][c]=='1') stack.add(List.of(r-1, c));
          if (r<rowLen-1 && grid[r+1][c]=='1') stack.add(List.of(r+1, c));
          if (c>0 && grid[r][c-1]=='1') stack.add(List.of(r, c-1));
          if (c<colLen-1 && grid[r][c+1]=='1') stack.add(List.of(r, c+1));
        }
      }
    }
    return ans;
  }
  // recursion 
  private static int numIslands2(char[][] grid) {
    int ans = 0;
    int rowLen = grid.length;
    int colLen = grid[0].length;
    // searching for 1 using nested for loop
    for (int row=0;row<rowLen;row++){
      for (int col=0; col<colLen;col++){
        // skip if coor is already searched
        if ( grid[row][col]=='1' ){
          ans++;
          dfs(grid,row,col);
        }
      }
    }
    return ans;
  }

  private static void dfs(char[][] grid, int r, int c){
    if (r<0 || c<0 || r>=grid.length || c>=grid[0].length) return;
    if (grid[r][c]=='0') return;
    grid[r][c] = '0';
    dfs(grid,r-1,c );
    dfs(grid,r+1,c );
    dfs(grid,r,c+1 );
    dfs(grid,r,c-1 );
  }
  // bfs
  public static void main(String[] args) {
    char[][] grid = {
      {'1','1','1','1','1'},
      {'1','1','1','1','1'},
      {'1','1','1','1','1'},
      {'1','1','1','1','1'}
    };
    System.out.println( numIslands(grid) );
    // System.out.println( numIslands1(grid) );
    // System.out.println( numIslands2(grid) );
  }
}