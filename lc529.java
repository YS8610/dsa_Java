public class lc529 {
  public char[][] updateBoard(char[][] board, int[] click) {
    int rc = click[0];
    int cc = click[1];
    if (board[rc][cc] == 'M') {
      board[rc][cc] = 'X';
      return board;
    }
    int lr = board.length;
    int lc = board[0].length;
    int[][] bmap = new int[lr][lc];
    for (int i = 0; i < lr; i++)
      for (int j = 0; j < lc; j++)
        if (board[i][j] == 'X' || board[i][j] == 'M')
          bomb(bmap, i, j);
    dfs(board, bmap, rc, cc);
    return board;
  }

  public void dfs(char[][] board, int[][] bmap, int r, int c) {
    int lr = board.length;
    int lc = board[0].length;
    if (r < 0 || c < 0 || r >= lr || c >= lc)
      return;
    if (board[r][c] != 'E')
      return;
    if (bmap[r][c] > 0) {
      board[r][c] = (char) (bmap[r][c] + '0');
      return;
    }
    board[r][c] = 'B';
    dfs(board, bmap, r + 1, c);
    dfs(board, bmap, r - 1, c);
    dfs(board, bmap, r, c + 1);
    dfs(board, bmap, r, c - 1);
    dfs(board, bmap, r + 1, c + 1);
    dfs(board, bmap, r - 1, c - 1);
    dfs(board, bmap, r + 1, c - 1);
    dfs(board, bmap, r - 1, c + 1);
  }

  public void bomb(int[][] bmap, int r, int c) {
    int lr = bmap.length;
    int lc = bmap[0].length;
    int[][] dir = {
        { r + 1, c },
        { r - 1, c },
        { r, c + 1 },
        { r, c - 1 },
        { r + 1, c + 1 },
        { r - 1, c - 1 },
        { r + 1, c - 1 },
        { r - 1, c + 1 }
    };
    for (int[] d : dir) {
      if (d[0] < 0 || d[1] < 0 || d[0] >= lr || d[1] >= lc)
        continue;
      bmap[d[0]][d[1]]++;
    }
  }
}
