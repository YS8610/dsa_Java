import java.util.Arrays;

public class lc2141 {
  static public long maxRunTime(int n, int[] batteries) {
    int l = batteries.length;
    Arrays.sort(batteries);
    int[] laptops = new int[n];
    long sum = 0;
    for (int b : batteries)
      sum += 0l + b;
    long extra = sum;
    for (int i = 0; i < n; i++) {
      laptops[i] = batteries[l - n + i];
      extra -= laptops[i];
    }
    long low = laptops[0];
    long high = laptops[n - 1] + extra / n;
    long mid;
    while (low < high) {
      mid = (high + low + 1) / 2;
      if (can(laptops, extra, mid))
        low = mid;
      else
        high = mid - 1;
    }
    return high;
  }

  static private boolean can(int[] laptop, long extra, long val) {
    int l = laptop.length;
    for (int i = 0; i < l; i++) {
      if (laptop[i] >= val)
        break;
      extra -= val - laptop[i];
      if (extra < 0)
        return false;
    }
    return true;
  }

  public static void main(String[] args) {
    int n = 5;
    int[] batteries = { 8, 9, 8, 7, 5, 3, 9, 8, 5, 3 };
    System.out.println(maxRunTime(n, batteries));
  }
}
