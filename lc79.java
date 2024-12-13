import java.util.List;

public class lc79 {

  private static boolean dfs(char[][] board, String word, int i, int r, int c){
    if (i >= word.length()) return true;
    if (r < 0 || r>=board.length || c < 0 || c >=board[0].length) return false;
    if (board[r][c] != word.charAt(i)) return false;
    char tmp = board[r][c];
    board[r][c] = 0;
    boolean ans = 
      dfs(board, word, i+1, r+1, c)||
      dfs(board, word, i+1, r, c+1)||
      dfs(board, word, i+1, r-1, c)||
      dfs(board, word, i+1, r, c-1);
    board[r][c] = tmp;
    return ans;
  }
  
  private static boolean exist(char[][] board, String word){
    boolean ans = false;
    char[][] copy = new char[board.length][board[0].length];
    for (int r =0; r<board.length;r++)
      for (int c =0; c<board[0].length;c++)
        copy[r][c] = board[r][c];

    for (int r =0; r<board.length;r++){
      for (int c =0; c<board[0].length;c++){
        if (dfs(board, word, 0, r, c)) return true;
        // for (int row =0; row<board.length;row++)
        //   for (int col =0; col<board[0].length;col++)
        //     board[row][col] = copy[row][col];
      }
    }
    return ans;
  }

  public static void main(String[] args) {
    char[][] board = {
      { 'A','B','C','E' },
      { 'S','F','E','S' },
      { 'A','D','E','E' },
    };
    String word = "ABCESEEEFS";
    System.out.println(exist(board, word));
  }
}
