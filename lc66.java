public class lc66 {
  public int[] plusOne(int[] digits) {
    int l = digits.length;
    int extra = 1;
    for (int i = l - 1; i >= 0; i--) {
      if (extra == 0)
        break;
      if (digits[i] < 9) {
        digits[i] += extra;
        extra = 0;
        continue;
      }
      digits[i] = 0;
      extra = 1;
    }
    if (extra == 0)
      return digits;
    int[] ans = new int[l + 1];
    ans[0] = 1;
    for (int i = 0; i < l; i++)
      ans[i + 1] = digits[i];
    return ans;
  }
}
