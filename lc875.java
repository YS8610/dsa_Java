public class lc875 {

  private static int timeNeeded(int[] piles, int k) {
    int time = 0;
    for (int i = 0, n = piles.length; i < n; i++) {
      if (piles[i] % k == 0) time += piles[i] / k; else time +=
        piles[i] / k + 1;
    }
    return time;
  }

  private static int bs(int start, int end, int target, int[] piles) {
    int guess = (end - start) / 2 + start;
    int result = timeNeeded(piles, guess);
    if (end - start == 1) return end;
    if (result == target) {
      return bs(start, guess, target, piles);
      // return guess;
    } else if (result < target) return bs(
      start,
      guess,
      target,
      piles
    ); else return bs(guess, end, target, piles);
  }

  private static int minEatingSpeed(int[] piles, int h) {
    int high = 0;
    for (int i = 0, n = piles.length; i < n; i++) {
      high = Math.max(piles[i], high);
    }
    int ans = bs(1, high, h, piles);
    while (ans >= 1 && timeNeeded(piles, ans) <= h) ans--;
    return ans + 1;
  }

  public static void main(String[] args) {
    int[] piles = {30,11,23,4,20};
    int h = 5;
    System.out.println(minEatingSpeed(piles, h));
  }
}
