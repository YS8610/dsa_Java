import java.util.PriorityQueue;

public class lc2462 {
  public long totalCost(int[] costs, int k, int candidates) {
    int l = costs.length;
    int lp = 0, rp = l - 1;
    PriorityQueue<int[]> pq = new PriorityQueue<>((m1, m2) -> {
      if (m1[0] == m2[0])
        return Integer.compare(m1[1], m2[1]);
      return Integer.compare(m1[0], m2[0]);
    });
    long ans = 0;
    int tmp = 2 * candidates;
    while (lp <= rp && pq.size() < tmp) {
      if (lp == rp) {
        pq.add(new int[] { costs[lp], lp });
        lp++;
        continue;
      }
      pq.add(new int[] { costs[lp], lp });
      pq.add(new int[] { costs[rp], rp });
      lp++;
      rp--;
    }
    int[] top;
    for (int i = 0; i < k; i++) {
      top = pq.poll();
      ans += top[0];
      if (lp > rp)
        continue;
      if (top[1] >= rp)
        pq.add(new int[] { costs[rp], rp-- });
      else
        pq.add(new int[] { costs[lp], lp++ });
    }
    return ans;
  }
}
