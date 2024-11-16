import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class lc2501 {

  private static int longestSquareStreak(int[] nums) {
    Set<Integer> set = new HashSet<>();
    Set<Integer> visited = new HashSet<>();
    Map<Integer, Integer> memo = new HashMap<>();
    int LMT = (int) Math.sqrt(Integer.MAX_VALUE);
    int ans = 0;
    int subans = 0;
    int tmp;
    for (int num : nums) set.add(num);
    for (int n : set) {
      if (visited.contains(n) || n > LMT) continue;
      tmp = n * n;
      if (!set.contains(tmp)) continue;
      visited.add(n);
      subans = 1;
      while (set.contains(tmp)) {
        if (memo.containsKey(tmp)) {
          subans += memo.get(tmp);
          break;
        }
        subans++;
        visited.add(tmp);
        tmp *= tmp;
      }
      memo.put(n, subans);
      ans = Math.max(ans, subans);
    }
    return ans == 0 ? -1 : ans;
  }

  public static void main(String[] args) {
    int[] nums = {4,3,6,16,8,2};
    System.out.println(longestSquareStreak(nums));
  }
}
