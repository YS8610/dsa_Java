import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class lc2094 {
  public int[] findEvenNumbers(int[] digits) {
    int[] map = new int[10];
    for (int d : digits)
      map[d]++;
    List<Integer> list = new ArrayList<>(450);
    int[] tmpmap = new int[10];
    int tmp;
    out: 
    for (int i = 100; i < 999; i += 2) {
      Arrays.fill(tmpmap, 0);
      tmp = i;
      while (tmp != 0) {
        tmpmap[tmp % 10]++;
        tmp /= 10;
      }
      for (int j = 0; j < 10; j++)
        if (tmpmap[j] > map[j])
          continue out;
      list.add(i);
    }
    int[] ans = new int[list.size()];
    int len = 0;
    for (int n : list)
      ans[len++] = n;
    return ans;
  }
}
