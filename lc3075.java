import java.util.Arrays;
import java.util.Collections;
import java.util.PriorityQueue;

public class lc3075 {

  private static long maximumHappinessSum(int[] happiness, int k) {
    long ans = 0;
    int tmp;
    PriorityQueue<Integer> q = new PriorityQueue<>(Collections.reverseOrder());
    for (int h : happiness)
      q.add(h);
    for (int i = 0; i < k; i++) {
      tmp = q.poll() - i;
      if (tmp < 0)
        break;
      ans += Math.max(tmp, 0);
    }
    return ans;
  }

  public long maximumHappinessSum1(int[] happiness, int k) {
    Arrays.sort(happiness);
    int l = happiness.length;
    long ans = 0;
    int turn = 0;
    while (--k >= 0 && --l >= 0)
      ans += Math.max(0, 0l + happiness[l] - (turn++));
    return ans;
  }

  public static void main(String[] args) {
    int[] happiness = { 2, 3, 4, 5 };
    int k = 1;
    System.out.println(maximumHappinessSum(happiness, k));
  }
}
