import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class lc3741 {
  public int minimumDistance(int[] nums) {
    int l = nums.length;
    int ans = -1;
    Map<Integer, List<Integer>> map = new HashMap<>();
    for (int i = 0; i < l; i++) {
      if (map.containsKey(nums[i]))
        map.get(nums[i]).add(i);
      else
        map.put(nums[i], new ArrayList<>(List.of(i)));
    }
    for (Map.Entry<Integer, List<Integer>> entry : map.entrySet()) {
      List<Integer> list = entry.getValue();
      if (list.size() < 3)
        continue;
      for (int i = 0, tmp = 0, n = list.size() - 2; i < n; i++) {
        tmp = list.get(i + 2) - list.get(i + 1) + list.get(i + 1) - list.get(i) + list.get(i + 2) - list.get(i);
        ans = ans == -1 ? tmp : Math.min(ans, tmp);
      }
    }
    return ans;
  }
}
