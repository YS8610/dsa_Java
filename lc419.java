public class lc419 {

  private static int countBattleships(char[][] board) {
    int rlen = board.length;
    int clen = board[0].length;
    int ans =0;
    boolean[][] visited = new boolean[rlen][clen];
    for (int r=0;r<rlen;r++){
      for(int c=0;c<clen;c++){
        if (visited[r][c]) continue;
        if (board[r][c]=='.') continue;
        if (board[r][c]=='X'){
          ans++;
          dfs(board, visited, r, c);
        }
      }
    }
    return ans;
  }

  private static void dfs(char[][] board, boolean[][] visited, int r, int c ){
    if ( r<0||c<0||r>=board.length||c>=board[0].length ) return ;
    if (visited[r][c]) return;
    if ( board[r][c]=='.') return;
    
    visited[r][c] = true;
    dfs(board, visited, r+1, c);
    dfs(board, visited, r, c+1);
    dfs(board, visited, r-1, c);
    dfs(board, visited, r, c-1);
  }

  public static void main(String[] args) {
    char[][] board = {
      { 'X', '.', '.', 'X' },
      { '.', '.', '.', 'X' },
      { '.', '.', '.', 'X' },
    };
    System.out.println( countBattleships(board) );
  }
}
