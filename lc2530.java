import java.util.Collections;
import java.util.PriorityQueue;

public class lc2530 {

  private static long maxKelements(int[] nums, int k) {
    PriorityQueue<Integer> pq = new PriorityQueue<>(Collections.reverseOrder());
    for (int n : nums) pq.add(n);
    long ans = 0;
    int tmp;
    for (int i = 0; i < k; i++) {
      tmp = pq.poll();
      ans += tmp;
      pq.add(tmp % 3 == 0 ? tmp / 3 : tmp / 3 + 1);
    }
    return ans;
  }

  public static void main(String[] args) {
    int[] nums = { 1, 10, 3, 3, 3 };
    int k = 3;
    System.out.println(maxKelements(nums, k));
  }
}
