import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

public class lc403 {

  private static boolean canCross(int[] stones) {
    int n = stones.length;
    if (stones[1] > 1) return false;
    if (n == 2 && stones[1] == 1) return true;
    List<Set<Integer>> dp = new ArrayList<>(n);
    Map<Integer, Integer> map = new HashMap<>();
    dp.add(new HashSet<>(List.of(1)));
    map.put(0, 0);
    for (int i = 1; i < n; i++) {
      map.put(stones[i], i);
      dp.add(new HashSet<>());
    }
    dp.get(1).addAll(List.of(1));
    for (int i = 2; i < n; i++) {
      for (int step : dp.get(i - 1)) {
        if (map.containsKey(stones[i - 1] + step)) {
          dp.get(map.get(stones[i - 1] + step)).add(step);
        }
        if (map.containsKey(stones[i - 1] + step + 1)) {
          dp.get(map.get(stones[i - 1] + step + 1)).add(step + 1);
        }
        if (step - 1 > 0 && map.containsKey(stones[i - 1] + step - 1)) {
          dp.get(map.get(stones[i - 1] + step - 1)).add(step - 1);
        }
      }
    }
    System.out.println(dp.toString());
    return !dp.get(dp.size() - 1).isEmpty();
  }

  public static void main(String[] args) {
    int[] stones = { 0, 1, 3, 4 };
    // System.out.println( canCross(stones) );
    System.out.println(canCross(stones));
  }
}
