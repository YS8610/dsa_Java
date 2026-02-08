import java.util.HashSet;
import java.util.Set;

public class lc2975 {
  public int maximizeSquareArea(int m, int n, int[] hFences, int[] vFences) {
    Set<Integer> hset = new HashSet<>();
    int ans = 0;
    int MOD = 1000000007;
    for (int i = 0, l = hFences.length; i < l; i++) {
      hset.add(hFences[i] - 1);
      for (int j = i + 1; j < l; j++)
        hset.add(Math.abs(hFences[i] - hFences[j]));
      hset.add(m - hFences[i]);
    }
    hset.add(m - 1);
    for (int i = 0, l = vFences.length, tmp = 0; i < l; i++) {
      tmp = vFences[i] - 1;
      if (hset.contains(tmp))
        ans = Math.max(ans, tmp);
      for (int j = i + 1; j < l; j++) {
        tmp = Math.abs(vFences[i] - vFences[j]);
        if (hset.contains(tmp))
          ans = Math.max(ans, tmp);
      }
      tmp = n - vFences[i];
      if (hset.contains(tmp))
        ans = Math.max(ans, tmp);
    }
    if (hset.contains(n - 1))
      ans = Math.max(ans, n - 1);
    return ans == 0 ? -1 : (int) ((1l * ans * ans) % MOD);
  }
}
