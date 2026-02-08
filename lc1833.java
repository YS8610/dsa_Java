public class lc1833 {
  public int maxIceCream(int[] costs, int coins) {
    int l = costs.length;
    int[] table = new int[100001];
    int small = costs[0];
    int big = costs[0];
    long sum = 0;
    int ans = 0;
    for (int c : costs) {
      table[c]++;
      small = Math.min(small, c);
      big = Math.max(big, c);
      sum += 0l + c;
    }
    if (coins >= sum)
      return l;
    for (int i = small, tmp = 0; i <= big; i++) {
      if (table[i] == 0)
        continue;
      tmp = coins / i;
      if (tmp == 0)
        break;
      coins -= (long) (Math.min(tmp, table[i]) * i);
      ans += Math.min(tmp, table[i]);
    }
    return ans;
  }
}
