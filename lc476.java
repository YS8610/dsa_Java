public class lc476 {

  private static int findComplement(int num) {
    int m = 1 << 31;
    int ans = 0;
    int i = 0;
    while ((m & num) == 0 && i++ >= 0) m >>= 1;
    m = 1;
    for (int j = 0, n = 32 - i; j < n; j++) {
      if ((m & num) == 0) ans += m;
      m <<= 1;
    }
    return ans;
  }

  public static void main(String[] args) {
    int num = 5;
    System.out.println(findComplement(num));
  }
}
