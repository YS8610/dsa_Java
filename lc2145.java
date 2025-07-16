public class lc2145 {
  public int numberOfArrays(int[] differences, int lower, int upper) {
    long small = 0;
    long big = 0;
    long sum = 0;
    for (int d : differences) {
      sum += d;
      small = Math.min(small, sum);
      big = Math.max(big, sum);
    }
    long ans = (upper - lower + 1l) - (big - small);
    return (int) Math.max(ans, 0l);
  }
}
