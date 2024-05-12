public class lc231 {
  private static boolean isPowerOfTwo(int n) {
    double ans = Math.log10(n)/Math.log10(2);
    if (ans == (int) ans) return true;
    return false;
  }

  public static void main(String[] args) {
    int n = 15;
    System.out.println(isPowerOfTwo(n));
  }
}
