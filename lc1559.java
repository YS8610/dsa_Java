import java.util.ArrayDeque;
import java.util.Deque;

public class lc1559 {
  static public boolean containsCycle(char[][] grid) {
    int lr = grid.length;
    int lc = grid[0].length;
    boolean[][] visited = new boolean[lr][lc];
    for (int r = 0; r < lr; r++) {
      for (int c = 0; c < lc; c++) {
        if (visited[r][c])
          continue;
        if (bfs(grid, visited, r, c))
          return true;
      }
    }
    return false;
  }

  static public boolean bfs(char[][] grid, boolean[][] visited, int r, int c) {
    int lr = grid.length;
    int lc = grid[0].length;
    if (r >= lr || r < 0 || c >= lc || c < 0)
      return false;
    if (visited[r][c])
      return false;
    char letter = grid[r][c];
    // r, c, r0, c0
    Deque<int[]> q = new ArrayDeque<>();
    q.add(new int[] { r, c, -1, -1 });
    int[] top;
    int r1, c1, r0, c0;
    while (!q.isEmpty()) {
      top = q.pollFirst();
      r1 = top[0];
      c1 = top[1];
      r0 = top[2];
      c0 = top[3];
      if (r1 >= lr || r1 < 0 || c1 >= lc || c1 < 0)
        continue;
      if (grid[r1][c1] != letter)
        continue;
      visited[r1][c1] = true;
      if (r1 == r && c1 == c && r0 != -1 && c0 != -1)
        return true;
      // up
      if (!(r1 - 1 == r0 && c1 == c0))
        q.add(new int[] { r1 - 1, c1, r1, c1 });
      // down
      if (!(r1 + 1 == r0 && c1 == c0))
        q.add(new int[] { r1 + 1, c1, r1, c1 });
      // left
      if (!(r1 == r0 && c1 - 1 == c0))
        q.add(new int[] { r1, c1 - 1, r1, c1 });
      // right
      if (!(r1 == r0 && c1 + 1 == c0))
        q.add(new int[] { r1, c1 + 1, r1, c1 });
    }
    return false;
  }

  public static void main(String[] args) {
    char[][] grid = {{'c','c','c','a'},{'c','d','c','c'},{'c','c','e','c'},{'f','c','c','c'}};
    System.out.println(containsCycle(grid));
  }
}
