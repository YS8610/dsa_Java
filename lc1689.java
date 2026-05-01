public class lc1689 {
  public int minPartitions(String n) {
    int l = n.length();
    int ans = 0;
    for (int i = 0; i < l; i++)
      ans = Math.max(ans, n.charAt(i) - '0');
    return ans;
  }
}
