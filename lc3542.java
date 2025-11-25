import java.util.ArrayDeque;
import java.util.Deque;
import java.util.HashSet;
import java.util.Set;

public class lc3542 {
  static public int minOperations(int[] nums) {
    int l = nums.length;
    return dfs(nums, 0, l);
  }

  // start inclusive, end exclusive
  static public int dfs(int[] nums, int start, int end) {
    if (start >= nums.length)
      return 0;
    if (start == end)
      return 0;
    if (end - start == 1)
      return nums[start] == 0 ? 0 : 1;
    Set<Integer> set = new HashSet<>();
    int low = nums[start];
    for (int i = start; i < end; i++) {
      low = Math.min(low, nums[i]);
      set.add(nums[i]);
    }
    if (set.size() == 1)
      return set.contains(0) ? 0 : 1;
    int ans = low == 0 ? 0 : 1;
    int lp = start, rp = lp;
    while (lp < end) {
      if (nums[lp] == low) {
        lp++;
        continue;
      }
      rp = lp;
      while (rp < end && nums[rp] != low)
        rp++;
      ans += dfs(nums, lp, rp);
      lp = rp;
    }
    return ans;
  }

  static int minOperations1(int[] nums) {
    int l = nums.length;
    int ans = 0;
    Deque<Integer> stack = new ArrayDeque<>();
    for (int i = 0; i < l; i++) {
      if (stack.isEmpty()) {
        stack.add(nums[i]);
        ans += nums[i] == 0 ? 0 : 1;
        continue;
      }
      while (!stack.isEmpty() && stack.peekLast() > nums[i])
        stack.pollLast();
      if (stack.isEmpty())
        ans += nums[i] == 0 ? 0 : 1;
      else if (!stack.isEmpty() && stack.peekLast() != nums[i] && nums[i] != 0)
        ans++;
      stack.add(nums[i]);
    }
    return ans;
  }

  public static void main(String[] args) {
    int[] nums = { 3, 1, 2, 1 };
    System.out.println(minOperations1(nums));
  }
}
