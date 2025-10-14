public class lc2139 {
  public int minMoves(int target, int maxDoubles) {
    int ans = 0;
    while (maxDoubles > 0 && target > 2) {
      // odd
      if ((target & 1) == 1) {
        target = (target - 1) / 2;
        ans += 2;
      } else {
        target /= 2;
        ans++;
      }
      maxDoubles--;
    }
    if (target == 1)
      return ans;
    return ans + target - 1;
  }
}
