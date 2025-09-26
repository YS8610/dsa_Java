public class lc3021 {
  public long flowerGame(int n, int m) {
    long oddn = n % 2 == 0 ? n / 2 : n / 2 + 1;
    long oddm = m % 2 == 0 ? m / 2 : m / 2 + 1;
    return oddn * (m - oddm) + (n - oddn) * oddm;
  }
}
