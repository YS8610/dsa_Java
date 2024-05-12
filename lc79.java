import java.util.List;

public class lc79 {

  private static boolean exist(char[][] board, String word) {
    int rlen = board.length;
    int clen = board[0].length;
    for (int r = 0; r < rlen; r++) {
      for (int c = 0; c < clen; c++) {
        if ( dfs(board,word,List.of(r,c),new boolean[rlen][clen]) ) return true;
      }
    }
    return false;
  }

  private static boolean dfs(
    char[][] board,
    String word,
    List<Integer> pos,
    boolean[][] visited
  ) {
    if (word.isEmpty()) return true;
    if (
      pos.get(0) < 0 ||
      pos.get(1) < 0 ||
      pos.get(0) >= board.length ||
      pos.get(1) >= board[0].length
      ) return false;
    if (visited[pos.get(0)][pos.get(1)]) return false;
    char c = word.charAt(0);
    if (board[pos.get(0)][pos.get(1)] != c) return false;
    boolean result;
    visited[pos.get(0)][pos.get(1)] =true;
    int posR = pos.get(0);
    int posC = pos.get(1);
    List<Integer> up = List.of(posR - 1, posC);
    List<Integer> down = List.of(posR + 1, posC);
    List<Integer> left = List.of(posR , posC-1);
    List<Integer> right = List.of(posR , posC+1);
    String newWord = word.length()>1?word.substring(1):"";
    result =  dfs(board,newWord,up,visited ) ||
              dfs(board,newWord,down,visited ) ||
              dfs(board,newWord,left,visited ) ||
              dfs(board,newWord,right,visited );
    visited[pos.get(0)][pos.get(1)] =false;
    return result;
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
