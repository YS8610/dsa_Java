public class lc1526 {
  public int minNumberOperations(int[] target) {
    int l = target.length;
    int ans = target[0];
    for (int i = 1, diff = 0; i < l; i++) {
      diff = target[i] - target[i - 1];
      ans += diff > 0 ? diff : 0;
    }
    return ans;
  }
}
