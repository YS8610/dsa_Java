import java.util.ArrayList;
import java.util.List;

public class lc357 {
  private static int dfs(int n, List<Integer> a) {
    int sum = 0;
    if (!a.isEmpty() && a.get(0) == 0) return 0;
    // check for repeated num
    int[] map = new int[10];
    for (int num : a) {
      map[num] += 1;
      if (map[num] > 1) return 0;
    }
    if (n == 0) return 1;
    for (int i = 0; i <= 9; i++) {
      a.add(i);
      sum += dfs(n - 1, a);
      a.remove(a.size() - 1);
    }
    return sum;
  }

  private static int countNumbersWithUniqueDigits(int n) {
    if (n == 0) return 1;
    if (n == 1) return 10;
    if (n == 2) return 91;

    return dfs(n, new ArrayList<>()) + countNumbersWithUniqueDigits(n - 1);
  }

  public static void main(String[] args) {
    int n = 4;
    System.out.println(countNumbersWithUniqueDigits(n));
  }
}
