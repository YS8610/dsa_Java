public class lc1015 {
  public int smallestRepunitDivByK(int k) {
    if ((k & 1) == 0)
      return -1;
    boolean[] visited = new boolean[k];
    int tmp = 1;
    int l = 1;
    while (tmp < k) {
      tmp = tmp * 10 + 1;
      l++;
    }
    if (tmp == k)
      return l;
    int remainder = tmp % k;
    while (remainder != 0) {
      l++;
      if (visited[remainder])
        return -1;
      visited[remainder] = true;
      remainder = (remainder * 10 + 1) % k;
    }
    return l;
  }
}
