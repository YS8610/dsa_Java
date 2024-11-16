import java.util.PriorityQueue;

public class lc2406 {

  private static int minGroups(int[][] intervals) {
    PriorityQueue<int[]> pq = new PriorityQueue<>((m1, m2) -> {
      if (m1[0] == m2[0]) return Integer.compare(m1[1], m2[1]);
      return Integer.compare(m1[0], m2[0]);
    });
    PriorityQueue<Integer> pq1 = new PriorityQueue<>();
    int l = intervals.length;
    for (int i = 0; i < l; i++) pq.add(intervals[i]);
    int ans = 1;
    int[] tmp;
    pq1.add(pq.poll()[1]);
    while (!pq.isEmpty()) {
      tmp = pq.poll();
      if (pq1.peek() >= tmp[0]) ans++; else pq1.poll();
      pq1.add(tmp[1]);
    }
    return ans;
  }

  public static void main(String[] args) {
    int[][] intervals = { { 5, 10 }, { 6, 8 }, { 1, 5 }, { 2, 3 }, { 1, 10 } };
    System.out.println(minGroups(intervals));
  }
}
