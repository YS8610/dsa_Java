import java.util.Arrays;

public class lc1356 {
  public int[] sortByBits(int[] arr) {
    int l = arr.length;
    Integer[] tmp = new Integer[l];
    for (int i = 0; i < l; i++)
      tmp[i] = arr[i];
    Arrays.sort(tmp, (m1, m2) -> {
      int b1 = Integer.bitCount(m1);
      int b2 = Integer.bitCount(m2);
      if (b1 == b2)
        return Integer.compare(m1, m2);
      return Integer.compare(b1, b2);
    });
    for (int i = 0; i < l; i++)
      arr[i] = tmp[i];
    return arr;
  }
}
