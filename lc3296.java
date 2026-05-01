import java.util.PriorityQueue;

class lc3296 {
  static public long minNumberOfSeconds(int mountainHeight, int[] workerTimes) {
    int l = workerTimes.length;
    long[] workhr = new long[l];
    // long[]{sum, time, workerTimes, index }
    PriorityQueue<long[]> pq = new PriorityQueue<>(
        (m1, m2) -> {
          if (m1[0] == m2[0])
            return Long.compare(m1[2], m2[2]);
          return Long.compare(m1[0], m2[0]);
        });
    for (int i = 0; i < l; i++)
      pq.add(new long[] { workerTimes[i], 1l, workerTimes[i], i });
    long[] tmp;
    while (mountainHeight > 0) {
      tmp = pq.poll();
      workhr[(int) tmp[3]] = tmp[0];
      tmp[0] += (++tmp[1]) * tmp[2];
      pq.add(tmp);
      mountainHeight--;
    }
    long ans = 0;
    for (int i = 0; i < l; i++)
      ans = Math.max(ans, workhr[i]);
    return ans;
  }

  public static void main(String[] args) {
    int mountainHeight = 30;
    int[] workerTimes = {5,13,5,6,9,7};
    System.out.println(minNumberOfSeconds(mountainHeight, workerTimes));
  }
}