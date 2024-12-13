import java.util.HashMap;
import java.util.Map;
import java.util.PriorityQueue;

public class lc1387 {

  private static int power(int x, Map<Integer, Integer> memo) {
    if (x == 1) return 0;
    if (memo.containsKey(x)) return memo.get(x);
    int ans = 1;
    if ((x & 1) == 0) ans += power(x / 2, memo); 
    else ans += power(3 * x + 1, memo);
    memo.put(x, ans);
    return ans;
  }

  public int getKth(int lo, int hi, int k) {
    Map<Integer, Integer> memo = new HashMap<>();
    PriorityQueue<Integer> pq = new PriorityQueue<>((m1, m2) -> {
      if (power(m1, memo) == power(m2, memo)) return Integer.compare(m1, m2);
      return Integer.compare(power(m1, memo), power(m2, memo));
    });
    for (int i = lo; i <= hi; i++) pq.add(i);
    int ans = 0;
    while (--k >= 0 && !pq.isEmpty()) ans = pq.poll();
    return ans;
  }
}
