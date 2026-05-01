class lc868 {
  public int binaryGap(int n) {
    int ans = 0;
    for (int i = 0, bit = 1, tmp = -1; i < 30; i++) {
      bit = 1 << i;
      if ((n & bit) > 0) {
        if (tmp < 0)
          tmp = i;
        else {
          ans = Math.max(ans, i - tmp);
          tmp = i;
        }
      }
    }
    return ans;
  }
}