public class lc3370 {
  public int smallestNumber(int n) {
    int ans = 1;
    int i = 31;
    int bitmask = 1;
    while (--i > 0)
      if ((n & (bitmask << i)) > 1)
        break;
    for (int j = 1; j <= i; j++) {
      bitmask <<= 1;
      ans |= bitmask;
    }
    return ans;
  }
}
