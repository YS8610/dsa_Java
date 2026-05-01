public class lc693 {
  public boolean hasAlternatingBits(int n) {
    if (n == 1)
      return true;
    int pos = Integer.highestOneBit(n);
    // System.out.println(pos);
    for (int i = pos, bit = 0, bit2 = 0; i > 1; i >>= 1) {
      bit = n & i;
      bit2 = n & (i >> 1);
      // System.out.printf("%d %d\n", bit , bit2);
      if (bit > 0 && bit2 > 0)
        return false;
      if (bit == 0 && bit2 == 0)
        return false;
    }
    return true;
  }
}
