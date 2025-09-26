public class lc2749 {
  static public int makeTheIntegerZero(int num1, int num2) {
    long tmp = 0;
    int k = 0;
    while (++k >= 0) {
      tmp = num1 - (long) k * num2;
      if (tmp < k)
        return -1;
      if (Long.bitCount(tmp) <= k)
        return k;
    }
    return -1;
  }

  public static void main(String[] args) {
    int num1 = 3, num2 = -2;
    System.out.println(makeTheIntegerZero(num1, num2));
  }
}
