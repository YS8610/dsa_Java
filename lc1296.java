import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class lc1296 {

  private static boolean isPossibleDivide(int[] nums, int k) {
    int len = nums.length;
    if (len % k != 0) return false;
    Map<Integer, Integer> map = new HashMap<>();
    for (int i : nums) {
      if (map.containsKey(i)) map.put(i, map.get(i) + 1); else map.put(i, 1);
    }
    int[] sortedSet = map
      .keySet()
      .stream()
      .mapToInt(Integer::valueOf)
      .toArray();
    Arrays.sort(sortedSet);
    int lp = 0;
    int prev = sortedSet[0];
    for (int i = 0, n = len / k; i < n; i++) {
      for (int j = 0; j < k; j++) {
        if (j == 0) {
          while (lp < sortedSet.length && map.get(sortedSet[lp]) == 0) lp++;
          prev = sortedSet[lp];
          map.put(sortedSet[lp], map.get(sortedSet[lp]) - 1);
        } else {
          if (lp + j >= sortedSet.length) return false;
          if (map.get(sortedSet[lp + j]) <= 0) return false;
          map.put(sortedSet[lp + j], map.get(sortedSet[lp + j]) - 1);
          if (sortedSet[lp + j] - prev > 1) return false;
          prev = sortedSet[lp + j];
        }
      }
    }
    return true;
  }

  public static void main(String[] args) {
    int[] nums = { 1, 2, 3, 3, 4, 4, 5, 6 };
    int k = 4;
    System.out.println(isPossibleDivide(nums, k));
  }
}
