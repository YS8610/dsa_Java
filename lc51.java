import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;


public class lc51 {
  private static void dfs(char[][] board, int n, int r, int c , List<List<String>> ans, int[] prev){
    if (r < 0 || c < 0 || r >= board.length || c >= board.length) return;
    int l = board.length;
    if (n == 0) {
      List<String> subans = new ArrayList<>();
      for(int i =0;i<l;i++){
        for(int j=0;j<l;j++){
          if (board[i][j]!='Q') board[i][j]='.';
        }
        subans.add(String.valueOf(board[i]));
      }
      ans.add(subans);
      return;
    }
    // marking board for prev queen placement
    if (prev[0]>=0 && prev[1]>=0){
      // mark horizon
      for (int col =0;col<l;col++)
        if (board[prev[0]][col] !='Q') board[prev[0]][col] = 'x';
      // mark vertical
      for (int row = 0; row<l;row++)
        if (board[row][prev[1]] !='Q') board[row][prev[1]] = 'x';
      // mark diagonal
      int[][] dia = new int[4][2];
      for (int i=1;i<l;i++){
        dia[0][0] = prev[0]+i;
        dia[0][1] = prev[1]+i;
        dia[1][0] = prev[0]-i;
        dia[1][1] = prev[1]-i;
        dia[2][0] = prev[0]-i;  
        dia[2][1] = prev[1]+i;
        dia[3][0] = prev[0]+i;  
        dia[3][1] = prev[1]-i;
        for (int j=0;j<4;j++){
          if (dia[j][0] < 0 || dia[j][1] < 0 || dia[j][0] >= board.length || dia[j][1] >= board.length) continue;
          if (board[dia[j][0]][dia[j][1]] != 'Q') board[dia[j][0]][dia[j][1]] = 'x';
        }
      }
    }
    if (board[r][c] == 'Q' || board[r][c]== 'x') return;
    // backtracking
      board[r][c] = 'Q';
      n--;
      dfs(Arrays.stream(board).map(arr->Arrays.copyOf(arr, l)).toArray(char[][]::new), n, r+1, c+1, ans, new int[]{r,c});
      dfs(Arrays.stream(board).map(arr->Arrays.copyOf(arr, l)).toArray(char[][]::new), n, r-1, c-1, ans, new int[]{r,c});
      dfs(Arrays.stream(board).map(arr->Arrays.copyOf(arr, l)).toArray(char[][]::new), n, r+1, c-1, ans, new int[]{r,c});
      dfs(Arrays.stream(board).map(arr->Arrays.copyOf(arr, l)).toArray(char[][]::new), n, r-1, c+1, ans, new int[]{r,c});
      board[r][c] = ' ';
  }
  
  private static List<List<String>> solveNQueens(int n) {
    List<List<String>> ans = new ArrayList<>();
    dfs(new char[n][n], n, 0, 0, ans, new int[]{-1,-1});
    return ans;
  }

  public static void main(String[] args) {
    int n=4;
    System.out.println(solveNQueens(n));
  }
}
