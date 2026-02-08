public class lc1532 {
  public int countOdds(int low, int high) {
    if (low == high)
      return low % 2;
    if (low % 2 == 1)
      return 1 + (high - low) / 2;
    return (high - low - 1) / 2 + 1;
  }
}
