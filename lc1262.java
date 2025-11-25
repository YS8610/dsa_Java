import java.util.PriorityQueue;

public class lc1262 {
  public int maxSumDivThree(int[] nums) {
    int sum = 0;
    int remainder = 0;
    PriorityQueue<Integer> pq1 = new PriorityQueue<>();
    PriorityQueue<Integer> pq2 = new PriorityQueue<>();
    int tmp = 0, tmp2 = 0;
    for (int n : nums) {
      sum += n;
      tmp = n % 3;
      if (tmp == 2)
        pq2.add(n);
      if (tmp == 1)
        pq1.add(n);
    }
    remainder = sum % 3;
    if (remainder == 0)
      return sum;
    if (remainder == 1) {
      tmp = pq1.isEmpty() ? 0 : pq1.poll();
      tmp2 = pq2.size() >= 2 ? pq2.poll() + pq2.poll() : 0;
      if (tmp == 0 && tmp2 == 0)
        return 0;
      if (tmp == 0)
        return sum - tmp2;
      if (tmp2 == 0)
        return sum - tmp;
      return tmp <= tmp2 ? sum - tmp : sum - tmp2;
    }
    // remainder == 2
    tmp = pq1.size() >= 2 ? pq1.poll() + pq1.poll() : 0;
    tmp2 = pq2.isEmpty() ? 0 : pq2.poll();
    if (tmp == 0 && tmp2 == 0)
      return 0;
    if (tmp == 0)
      return sum - tmp2;
    if (tmp2 == 0)
      return sum - tmp;
    return tmp <= tmp2 ? sum - tmp : sum - tmp2;
  }
}
