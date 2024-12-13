import java.util.HashMap;
import java.util.Map;

public class lc1072 {

  public int maxEqualRowsAfterFlips(int[][] matrix) {
    Map<String, Integer> map = new HashMap<>();
    for (int[] m : matrix) {
      if (m[0] != 0) {
        for (int i = 0; i < m.length; i++) m[i] ^= 1;
      }
      StringBuilder a = new StringBuilder();
      for (int i = 0; i < m.length; i++) a.append((char) (m[i] + '0'));
      String hash = a.toString();
      map.computeIfPresent(hash, (k, v) -> v + 1);
      map.computeIfAbsent(hash, k -> 1);
    }
    int ans = 1;
    for (Map.Entry<String, Integer> entry : map.entrySet()) ans =
      Math.max(ans, entry.getValue());
    return ans;
  }
}
