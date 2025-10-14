import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class lc18 {
  static public List<List<Integer>> fourSum(int[] nums, int target) {
    int l = nums.length;
    if (l < 4)
      return new ArrayList<>();
    Map<Long, Integer> map = new HashMap<>();
    List<List<Integer>> ans = new ArrayList<>();
    Arrays.sort(nums);
    long tmp;
    for (int i = l - 1; i >= 0; i--) {
      if (map.containsKey((long)nums[i]))
        continue;
      map.put((long) nums[i], i);
    }
    for (int i = 0, n = l - 3; i < n; i++) {
      if (i > 0 && nums[i] == nums[i - 1])
        continue;
      for (int j = i + 1, m = l - 2; j < m; j++) {
        if (j > i + 1 && nums[j] == nums[j - 1])
          continue;
        for (int k = j + 1, o = l - 1, pos = 0; k < o; k++) {
          if (k > j + 1 && nums[k] == nums[k - 1])
            continue;
          tmp = (long) nums[i] + nums[j] + nums[k];
          if (Long.compare(tmp + nums[k + 1], target) > 0)
            break;
          pos = map.getOrDefault(target - tmp, -1);
          if (pos == -1)
            continue;
          ans.add(new ArrayList<>(Arrays.asList(nums[i], nums[j], nums[k], nums[pos])));
        }
      }
    }
    return ans;
  }

  public static void main(String[] args) {
    int[] nums = { 1000000000, 1000000000, 1000000000, 1000000000 };
    System.out.println(fourSum(nums, -294967296).toString());
  }
}
