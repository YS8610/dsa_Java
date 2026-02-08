import java.util.Arrays;
import java.util.PriorityQueue;

public class lc2402 {
  public int mostBooked(int n, int[][] meetings) {
    if (n == 1)
      return 0;
    int[] rooms = new int[n];
    Arrays.sort(meetings, (m1, m2) -> Integer.compare(m1[0], m2[0]));
    // ending time, room id
    PriorityQueue<long[]> pq = new PriorityQueue<>((m1, m2) -> {
      if (m1[0] == m2[0])
        return Long.compare(m1[1], m2[1]);
      return Long.compare(m1[0], m2[0]);
    });
    for (int i = 0; i < n; i++)
      pq.add(new long[] { 0, i });
    long[] top;
    long endingTime;
    for (int[] m : meetings) {
      top = pq.poll();
      while (top[0] < m[0]) {
        pq.add(new long[] { m[0], top[1] });
        top = pq.poll();
      }
      rooms[(int) top[1]]++;
      endingTime = top[0] <= m[0] ? m[1] : 0l + top[0] + m[1] - m[0];
      pq.add(new long[] { endingTime, top[1] });
    }
    int ans = n - 1;
    for (int i = n - 1, timeUsed = rooms[n - 1]; i >= 0; i--) {
      if (timeUsed > rooms[i])
        continue;
      timeUsed = rooms[i];
      ans = i;
    }
    return ans;
  }
}
