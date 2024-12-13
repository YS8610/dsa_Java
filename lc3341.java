import java.util.Arrays;
import java.util.PriorityQueue;

public class lc3341 {

  private static boolean can(int r, int c, int[][] moveTime) {
    return r >= 0 && c >= 0 && r < moveTime.length && c < moveTime[0].length;
  }

  private static int minTimeToReach(int[][] moveTime) {
    int lr = moveTime.length;
    int lc = moveTime[0].length;
    int[][] map = new int[lr][lc];
    for (int[] m : map) Arrays.fill(m, Integer.MAX_VALUE);
    PriorityQueue<int[]> pq = new PriorityQueue<>((m1, m2) ->
      Integer.compare(m1[2], m2[2])
    );

    pq.add(new int[] { 0, 0, 0 });
    int[] tmp;
    int r, c, t;
    while (!pq.isEmpty()) {
      tmp = pq.poll();
      r = tmp[0];
      c = tmp[1];
      t = tmp[2];
      if (t >= map[r][c]) continue;
      map[r][c] = Math.min(map[r][c], t);
      if (can(r + 1, c, moveTime)) pq.add(
        new int[] { r + 1, c, Math.max(t, moveTime[r + 1][c]) + 1 }
      );
      if (can(r - 1, c, moveTime)) pq.add(
        new int[] { r - 1, c, Math.max(t, moveTime[r - 1][c]) + 1 }
      );
      if (can(r, c - 1, moveTime)) pq.add(
        new int[] { r, c - 1, Math.max(t, moveTime[r][c - 1]) + 1 }
      );
      if (can(r, c + 1, moveTime)) pq.add(
        new int[] { r, c + 1, Math.max(t, moveTime[r][c + 1]) + 1 }
      );
    }
    return map[lr - 1][lc - 1];
  }

  public static void main(String[] args) {
    int[][] moveTime = {
      { 94, 79, 62, 27, 69, 84 },
      { 6, 32, 11, 82, 42, 30 },
    };
    System.out.println(minTimeToReach(moveTime));
  }
}
