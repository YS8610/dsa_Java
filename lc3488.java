import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class lc3488 {
  static public List<Integer> solveQueries(int[] nums, int[] queries) {
    Map<Integer, List<Integer>> map = new HashMap<>();
    int l = nums.length;
    for (int i = 0; i < l; i++) {
      if (map.containsKey(nums[i])) {
        map.get(nums[i]).add(i);
        continue;
      }
      map.put(nums[i], new ArrayList<>(Arrays.asList(i)));
    }
    List<Integer> ans = new ArrayList<>();
    for (int q : queries) {
      if (!map.containsKey(nums[q])) {
        ans.add(-1);
        continue;
      }
      ans.add(solve(map.get(nums[q]), q, nums.length));
    }
    return ans;
  }

  static public int solve(List<Integer> list, int index, int len) {
    int l = list.size();
    if (l == 1)
      return -1;
    int pos = Collections.binarySearch(list, index);
    int right = list.get((pos + 1) % l);
    int left = list.get((pos - 1 + l) % l);
    int ans = -1;
    if (right >= index)
      ans = right - index;
    else
      ans = len - index + right;
    if (left <= index)
      ans = Math.min(ans, index - left);
    else
      ans = Math.min(ans, index + len - left);
    return ans;
  }

  public static void main(String[] args) {
    int[] nums = {1,3,1,4,1,3,2}, queries = {0,3,5};
    System.out.println(solveQueries(nums, queries));
  }
}
