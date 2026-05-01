public class lc762 {
  public int countPrimeSetBits(int left, int right) {
    boolean[] primes = new boolean[33];
    primes[2] = true;
    int ans = 0;
    out: for (int i = 3, tmp = 0; i < 33; i++) {
      tmp = i / 2;
      for (int j = 2; j <= tmp; j++)
        if (i % j == 0)
          continue out;
      primes[i] = true;
    }
    for (int i = left; i <= right; i++)
      ans += primes[Integer.bitCount(i)] ? 1 : 0;
    return ans;
  }
}
