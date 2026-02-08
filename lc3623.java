import java.util.HashMap;
import java.util.Map;

public class lc3623 {
  public int countTrapezoids(int[][] points) {
    int MOD = 1000000007;
    Map<Integer, Integer> map = new HashMap<>();
    for (int[] pt : points)
      map.compute(pt[1], (k, v) -> v == null ? 1 : v + 1);
    long[] pts = new long[map.size()];
    int j = 0;
    for (var entry : map.entrySet()) {
      long v = entry.getValue() - 1;
      pts[j++] = (v * (v + 1) / 2) % MOD;
    }
    long ans = 0;
    long sum = 0;
    for (int i = map.size() - 2; i >= 0; i--) {
      sum = (sum + pts[i + 1]) % MOD;
      ans = (ans + pts[i] * sum % MOD) % MOD;
    }
    return (int) ans;
  }
}
