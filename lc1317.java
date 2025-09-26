public class lc1317 {
  public int[] getNoZeroIntegers(int n) {
    for (int i = 1, j = n / 2 + 1; i < j; i++) {
      if (zero(i))
        continue;
      if (!zero(n - i))
        return new int[] { i, n - i };
    }
    return new int[2];
  }

  private boolean zero(int n) {
    while (n > 0) {
      if (n % 10 == 0)
        return true;
      n /= 10;
    }
    return false;
  }
}
