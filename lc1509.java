import java.util.PriorityQueue;
import java.util.Collections;

public class lc1509 {
  public int minDifference(int[] nums) {
    int len = nums.length;
    if (len <= 4)
      return 0;
    int[] small = new int[4];
    int[] big = new int[4];
    int ans = 0;
    PriorityQueue<Integer> pq1 = new PriorityQueue<>();
    PriorityQueue<Integer> pq2 = new PriorityQueue<>(Collections.reverseOrder());
    for (int n : nums) {
      pq1.add(n);
      pq2.add(n);
    }
    for (int i = 0, j = 3; i < 4; i++) {
      small[i] = pq1.poll();
      big[j--] = pq2.poll();
    }
    ans = big[0] - small[0];
    for (int i = 0; i < 4; i++)
      ans = Math.min(ans, big[i] - small[i]);
    return ans;
  }
}
