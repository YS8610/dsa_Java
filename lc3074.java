import java.util.Arrays;

public class lc3074 {
  public int minimumBoxes(int[] apple, int[] capacity) {
    int total = 0;
    int ans = 0;
    int pos = capacity.length - 1;
    Arrays.sort(capacity);
    for (int a : apple)
      total += a;
    while (pos >= 0 && total > 0) {
      total -= capacity[pos--];
      ans++;
    }
    return ans;
  }
}
