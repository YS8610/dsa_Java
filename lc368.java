import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class lc368 {
  static public List<Integer> largestDivisibleSubset(int[] nums) {
    int l = nums.length;
    Arrays.sort(nums);
    List<Integer> ans = null;
    Map<Integer, List<Integer>> memo = new HashMap<>();
    for (int i = 0; i < l; i++) {
      List<Integer> tmp = dfs(nums, i, memo);
      if (ans == null)
        ans = tmp;
      else
        ans = ans.size() > tmp.size() ? ans : tmp;
    }
    return ans;
  }

  private static List<Integer> dfs(int[] nums, int idx, Map<Integer, List<Integer>> memo) {
    if (idx >= nums.length)
      return new ArrayList<>();
    if (memo.containsKey(idx))
      return memo.get(idx);
    List<Integer> ans = new ArrayList<>(Arrays.asList(nums[idx]));
    for (int i = idx+1; i < nums.length; i++) {
      List<Integer> tmp = new ArrayList<>(Arrays.asList(nums[idx]));;
      if (nums[i] % nums[idx] != 0)
        continue;
      tmp.addAll(dfs(nums, i, memo));
      ans = ans.size() > tmp.size() ? ans : tmp;
    }
    memo.put(idx, ans);
    return ans;
  }

  public static void main(String[] args) {
    int[] nums = {10,9,8,3,6,55,856,132};
    System.out.println(largestDivisibleSubset(nums).toString());
  }
}
