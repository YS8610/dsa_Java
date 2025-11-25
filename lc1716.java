public class lc1716 {
  public int totalMoney(int n) {
    int week = n / 7;
    int remainder = n % 7;
    int ans = 0;
    int tmp = 1 + 2 + 3 + 4 + 5 + 6 + 7;
    for (int i = 0; i < week; i++)
      ans += tmp + i * 7;
    for (int i = 0; i < remainder; i++)
      ans += (week + 1) + i;
    return ans;
  }
}
