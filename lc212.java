import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class lc212 {

  private static class Trie {

    Trie[] nodes;
    boolean end;
    String word;

    Trie() {
      end = false;
      word = "";
      nodes = new Trie[26];
    }
  }

  private static void dfs(
    char[][] board,
    Trie root,
    int r,
    int c,
    Set<String> ans
  ) {
    if (root.end) ans.add(root.word);
    if (r < 0 || r >= board.length || c < 0 || c >= board[0].length) return;
    if (board[r][c] == 0) return;
    if (root.nodes[board[r][c] - 'a'] == null) return;
    char tmp = board[r][c];
    Trie cp = root.nodes[board[r][c] - 'a'];
    board[r][c] = 0;
    dfs(board, cp, r + 1, c, ans);
    dfs(board, cp, r - 1, c, ans);
    dfs(board, cp, r, c + 1, ans);
    dfs(board, cp, r, c - 1, ans);
    board[r][c] = tmp;
  }

  public List<String> findWords(char[][] board, String[] words) {
    Trie head = new Trie();
    Trie cp = head;
    Set<String> ans = new HashSet<>();
    for (String w : words) {
      cp = head;
      for (int i = 0, n = w.length(); i < n; i++) {
        if (cp.nodes[w.charAt(i) - 'a'] == null) cp.nodes[w.charAt(i) - 'a'] =
          new Trie();
        cp = cp.nodes[w.charAt(i) - 'a'];
      }
      cp.end = true;
      cp.word = w;
    }
    char[][] copy = new char[board.length][board[0].length];
    for (int r = 0; r < board.length; r++) for (
      int c = 0;
      c < board[0].length;
      c++
    ) copy[r][c] = board[r][c];
    for (int r = 0; r < board.length; r++) {
      for (int c = 0; c < board[0].length; c++) {
        cp = head;
        dfs(board, cp, r, c, ans);
        // for (int row =0; row<board.length;row++)
        //   for (int col =0; col<board[0].length;col++)
        //     board[row][col] = copy[row][col];
      }
    }
    return new ArrayList<>(ans);
  }
}
