public class lc1611 {
  public int minimumOneBitOperations(int n) {
    int[] bit = new int[31];
    for (int i = 0, bm = 1; i < 31; i++)
      bit[i] = bm << i;
    return solve(bit, n);
  }

  public int solve(int[] bit, int n) {
    if (n == 0)
      return 0;
    if (n == 1)
      return 1;
    int leftmost = 30;
    for (int i = 30; i >= 0; i--) {
      if ((bit[i] & n) <= 0)
        continue;
      leftmost = i;
      break;
    }
    return (2 << leftmost) - 1 - solve(bit, n ^ bit[leftmost]);
  }
}
