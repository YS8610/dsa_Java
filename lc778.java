import java.util.PriorityQueue;

public class lc778 {
  static public int swimInWater(int[][] grid) {
    int lr = grid.length;
    int lc = grid[0].length;
    PriorityQueue<int[]> pq = new PriorityQueue<>((m1, m2) -> Integer.compare(m1[2], m2[2]));
    pq.add(new int[] { 0, 0, grid[0][0], grid[0][0] });
    boolean[][] res = new boolean[lr][lc];
    int[] tmp;
    int r, c, g, t;
    while (!pq.isEmpty()) {
      tmp = pq.poll();
      r = tmp[0];
      c = tmp[1];
      g = tmp[2];
      t = tmp[3];
      if (r < 0 || c < 0 || r >= lr || c >= lc)
        continue;
      if (res[r][c])
        continue;
      t = Math.max(t, grid[r][c]);
      res[r][c] = true;
      if (r == lr - 1 && c == lc - 1)
        return t;
      pq.add(new int[] { r + 1, c, getval(grid, r + 1, c), t });
      pq.add(new int[] { r - 1, c, getval(grid, r - 1, c), t });
      pq.add(new int[] { r, c + 1, getval(grid, r, c + 1), t });
      pq.add(new int[] { r, c - 1, getval(grid, r, c - 1), t });
    }
    return grid[lr - 1][lc - 1];
  }

  static public int getval(int[][] grid, int r, int c) {
    int lr = grid.length;
    int lc = grid[0].length;
    if (r < 0 || c < 0 || r >= lr || c >= lc)
      return -1;
    return grid[r][c];
  }

  public static void main(String[] args){
    int[][] grid = {{0,1,2,3,4},{24,23,22,21,5},{12,13,14,15,16},{11,17,18,19,20},{10,9,8,7,6}};
    System.out.println(swimInWater(grid));
  }
}
