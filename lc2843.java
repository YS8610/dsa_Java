import java.util.Arrays;

public class lc2843 {
  public int countSymmetricIntegers(int low, int high) {
    int[] array = new int[5];
    int count;
    int ans = 0;
    int tmp;
    for (int i = low; i <= high; i++) {
      Arrays.fill(array, -1);
      count = 0;
      tmp = 0;
      fillarray(i, array, 0);
      for (int a : array)
        count += a != -1 ? 1 : 0;
      if ((count & 1) == 1)
        continue;
      for (int j = 0, n = count / 2; j < n; j++)
        tmp += array[j];
      for (int j = count / 2; j < count; j++)
        tmp -= array[j];
      ans += tmp == 0 ? 1 : 0;
    }
    return ans;
  }

  private static void fillarray(int n, int[] array, int idx) {
    if (n <= 0)
      return;
    array[idx] = n % 10;
    fillarray(n / 10, array, idx + 1);
  }
}
