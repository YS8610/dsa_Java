class lc123 {
  public int maxProfit(int[] prices) {
    int l = prices.length;
    int[] part1 = new int[l];
    int[] part2 = new int[l];
    int ans = 0;
    for (int i = l - 1, tmp = 0; i >= 0; i--) {
      tmp = Math.max(tmp, prices[i]);
      part2[i] = tmp - prices[i];
    }
    for (int i = l - 1, tmp = Integer.MIN_VALUE; i >= 0; i--) {
      tmp = Math.max(tmp, part2[i]);
      part2[i] = Math.max(part2[i], tmp);
      ans = Math.max(ans, part2[i]);
    }
    for (int i = 0, tmp = prices[0]; i < l; i++) {
      tmp = Math.min(tmp, prices[i]);
      part1[i] = prices[i] - tmp;
    }
    for (int i = 0, tmp = Integer.MIN_VALUE; i < l; i++) {
      tmp = Math.max(tmp, part1[i]);
      part1[i] = Math.max(part1[i], tmp);
    }
    for (int i = 0; i < l; i++) {
      if (i == l - 1) {
        ans = Math.max(part1[i], ans);
        break;
      }
      ans = Math.max(part1[i] + part2[i + 1], ans);
    }
    return ans;
  }
}