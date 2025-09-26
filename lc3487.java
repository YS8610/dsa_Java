public class lc3487 {
  public int maxSum(int[] nums) {
    boolean[] visited = new boolean[101];
    int ans = 0;
    int biggest = -101;
    for (int n : nums) {
      biggest = Math.max(biggest, n);
      if (n <= 0 || visited[n])
        continue;
      ans += n;
      visited[n] = true;
    }
    if (biggest <= 0)
      return biggest;
    return ans;
  }
}
