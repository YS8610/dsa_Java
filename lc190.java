public class lc190 {
  public int reverseBits(int n) {
    int ans = 0;
    for (int i = 0, bit = 1; i < 31; i++) {
      bit = 1 << i;
      if ((n & bit) == 0)
        continue;
      ans |= 1 << (31 - i);
    }
    return ans;
  }
}
