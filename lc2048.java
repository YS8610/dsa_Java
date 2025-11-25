import java.util.Arrays;

public class lc2048 {
  public int nextBeautifulNumber(int n) {
    int[] map = new int[10];
    while (!can(map, ++n))
      ;
    return n;
  }

  public boolean can(int[] map, int n) {
    Arrays.fill(map, 0);
    int remainder;
    while (n != 0) {
      remainder = n % 10;
      map[remainder]++;
      if (remainder == 0)
        return false;
      n /= 10;
    }
    for (int i = 1; i < 10; i++) {
      if (map[i] == 0)
        continue;
      if (map[i] != i)
        return false;
    }
    return true;
  }
}
