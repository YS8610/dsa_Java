public class lc1009 {

  private static int bitwiseComplement(int n) {
    if (n == 0) return 1;
    int m = 1 << 31;
    int ans = 0;
    int i = 0;
    while ((m & n) == 0 && i++ >= 0) m >>= 1;
    m = 1;
    for (int j = 0, o = 32 - i; j < o; j++) {
      if ((m & n) == 0) ans += m;
      m <<= 1;
    }
    return ans;
  }

  public static void main(String[] args) {
    int n = 5;
    System.out.println(bitwiseComplement(n));
  }
}
