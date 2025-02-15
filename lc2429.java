public class lc2429 {

  private static int minimizeXor(int num1, int num2) {
    int mask = 1;
    int setbit = 0;
    int ans = 0;
    for (int i = 0; i < 30; i++) {
      if ((mask & num2) > 0) setbit++;
      mask <<= 1;
    }
    for (int i = 0; i < 30 && setbit > 0; i++, mask >>= 1) {
      if ((mask & num1) > 0 && setbit > 0) {
        ans |= mask;
        setbit--;
      }
    }
    mask = 1;
    while (setbit > 0) {
      if ((ans & mask) == 0) {
        ans |= mask;
        setbit--;
      }
      mask <<= 1;
    }
    return ans;
  }

  public static void main(String[] args) {
    int num1 = 3, num2 = 5;
    System.out.println(minimizeXor(num1, num2));
  }
}
