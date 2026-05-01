import java.util.HashSet;
import java.util.Set;

public class lc3719 {
  public int longestBalanced(int[] nums) {
    int l = nums.length;
    int ans = 0;
    if (l == 1)
      return 0;
    Set<Integer> even = new HashSet<>();
    Set<Integer> odd = new HashSet<>();
    for (int i = 0; i < l; i++) {
      even.clear();
      odd.clear();
      if (nums[i] % 2 == 0)
        even.add(nums[i]);
      else
        odd.add(nums[i]);
      for (int j = i + 1; j < l; j++) {
        if (nums[j] % 2 == 0)
          even.add(nums[j]);
        else
          odd.add(nums[j]);
        if (even.size() == odd.size())
          ans = Math.max(ans, j - i + 1);
      }
    }
    return ans;
  }
}
