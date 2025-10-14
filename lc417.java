import java.util.List;
import java.util.ArrayList;
import java.util.Deque;
import java.util.ArrayDeque;

public class lc417 {
  static public List<List<Integer>> pacificAtlantic(int[][] heights) {
    int lr = heights.length;
    int lc = heights[0].length;
    List<List<Integer>> ans = new ArrayList<>(lr * lc);
    int[][] po = new int[lr][lc];
    int[][] ao = new int[lr][lc];
    bfs(heights, po, true);
    bfs(heights, ao, false);
    for (int r = 0; r < lr; r++)
      for (int c = 0; c < lc; c++)
        if (po[r][c] + ao[r][c] >= 2)
          ans.add(List.of(r, c));
    return ans;
  }

  static public void bfs(int[][] heights, int[][] v, boolean up) {
    int lr = heights.length;
    int lc = heights[0].length;
    Deque<int[]> q = new ArrayDeque<>();
    int[] tmp;
    if (up) {
      for (int i = 0; i < lc; i++)
        q.add(new int[] { 0, i });
      for (int j = 1; j < lr; j++)
        q.add(new int[] { j, 0 });
    } else {
      for (int i = 0; i < lc; i++)
        q.add(new int[] { lr - 1, i });
      for (int j = 0, n = lr - 1; j < n; j++)
        q.add(new int[] { j, lc - 1 });
    }
    while (!q.isEmpty()) {
      tmp = q.pollFirst();
      if (v[tmp[0]][tmp[1]] > 0)
        continue;
      v[tmp[0]][tmp[1]]++;
      // up
      if (can(heights, tmp[0] - 1, tmp[1], tmp[0], tmp[1]))
        q.add(new int[] { tmp[0] - 1, tmp[1] });
      // down
      if (can(heights, tmp[0] + 1, tmp[1], tmp[0], tmp[1]))
        q.add(new int[] { tmp[0] + 1, tmp[1] });
      // left
      if (can(heights, tmp[0], tmp[1] - 1, tmp[0], tmp[1]))
        q.add(new int[] { tmp[0], tmp[1] - 1 });
      // right
      if (can(heights, tmp[0], tmp[1] + 1, tmp[0], tmp[1]))
        q.add(new int[] { tmp[0], tmp[1] + 1 });
    }
  }

  public static boolean can(int[][] heights, int r, int c, int or, int oc) {
    int lr = heights.length;
    int lc = heights[0].length;
    if (r < 0 || r >= lr || c < 0 || c >= lc)
      return false;
    if (heights[or][oc] <= heights[r][c])
      return true;
    return false;
  }

  public static void main(String[] args){
    int[][] heights = {{1,2,2,3,5},{3,2,3,4,4},{2,4,5,3,1},{6,7,1,4,5},{5,1,1,2,4}};
    System.out.println(pacificAtlantic(heights).toString());
  }
}
