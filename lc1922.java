public class lc1922 {
  static final int MOD = 1000000007;

  static public int countGoodNumbers(long n) {
    long prime = n / 2;
    long even = (n & 1) == 0 ? prime : prime + 1;
    return (int) ((expon(5, even) * (long) expon(4, prime)) % MOD);
  }

  static private int expon(int a, long pow) {
    int result = 1;
    while (pow > 0) {
      if (pow % 2 == 1)
        result = (int) (result * (long) a % MOD);
      a = (int) (a * (long) a % MOD);
      pow /= 2;
    }
    return result;
  }

  public static void main(String[] args) {
    int n = 50;
    System.out.println(countGoodNumbers(n));
  }
}
