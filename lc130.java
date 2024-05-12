import java.util.Arrays;

public class lc130 {

  private static void solve(char[][] board) {
    int rlen = board.length;
    int clen = board[0].length;
    // left col = 0
    for (int r = 1, m = rlen - 1; r < m; r++) {
      dfs(board, r, 0);
    }
    // right col = clen-1
    for (int r = 1, m = rlen - 1; r < m; r++) {
      dfs(board, r, clen - 1);
    }
    // top row = 0
    for (int c = 1, m = clen - 1; c < m; c++) {
      dfs(board, 0, c);
    }
    // bottom row = rlen-1
    for (int c = 1, m = clen - 1; c < m; c++) {
      dfs(board, rlen - 1, c);
    }
    for (int r = 0; r < rlen; r++) {
      for (int c = 0; c < clen; c++) {
        // border of the board
        if (r == 0 || c == 0 || r == rlen - 1 || c == clen - 1) {
          if (board[r][c] == '1') board[r][c] = 'O';
        }
        // within the board
        else {
          if (board[r][c] == '1') board[r][c] = 'O'; else board[r][c] = 'X';
        }
      }
    }
  }

  private static void dfs(char[][] board, int row, int col) {
    int rlen = board.length;
    int clen = board[0].length;
    if (row < 0 || col < 0 || row >= rlen || col >= clen) return;
    if (board[row][col] != 'O') return;
    board[row][col] = '1';
    if (row == 0) dfs(board, row + 1, col); 
    else if (row == rlen - 1) dfs( board, row - 1, col);
    else if (col == 0) dfs(board, row, col + 1); 
    else if (col == clen - 1) dfs(board, row, col - 1); 
    else {
      // up
      dfs(board, row + 1, col);
      // down
      dfs(board, row - 1, col);
      // left
      dfs(board, row, col - 1);
      // right
      dfs(board, row, col + 1);
    }
  }

  public static void main(String[] args) {
    char[][] board = {
      { 'O', 'X', 'X', 'O' },
      { 'X', 'O', 'O', 'X' },
      { 'X', 'X', 'O', 'X' },
      { 'X', 'O', 'O', 'X' },
    };
    solve(board);
    System.out.println(Arrays.deepToString(board));
  }
}
