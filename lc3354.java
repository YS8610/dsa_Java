import java.util.Arrays;

public class lc3354 {
  private static boolean can(int[] nums, int pos, int dir) {
    int l = nums.length;
    while (pos < l && pos >= 0) {
      if (nums[pos] == 0)
        pos += dir;
      else {
        nums[pos]--;
        dir *= -1;
        pos += dir;
      }
    }
    for (int n : nums)
      if (n != 0)
        return false;
    return true;
  }

  // simulation
  private static int countValidSelections(int[] nums) {
    int l = nums.length;
    int ans = 0;
    // right
    for (int i = 0; i < l; i++) {
      if (nums[i] != 0)
        continue;
      if (can(Arrays.copyOf(nums, l), i, 1))
        ans++;
      if (can(Arrays.copyOf(nums, l), i, -1))
        ans++;
    }
    return ans;
  }

  // prefix
  public int countValidSelections1(int[] nums) {
    int l = nums.length;
    int ans = 0;
    int[] prefix = new int[l];
    prefix[0] = nums[0];
    for (int i = 1; i < l; i++)
      prefix[i] += prefix[i - 1] + nums[i];
    int total = prefix[l - 1];
    if (total == 0)
      return l * 2;
    for (int i = 0, right = 0, left = 0; i < l; i++) {
      if (nums[i] != 0)
        continue;
      left = prefix[i];
      right = total - prefix[i];
      if (left == right)
        ans += 2;
      else if (left + 1 == right || left == right + 1)
        ans++;
    }
    return ans;
  }

  public static void main(String[] args) {
    int[] nums = { 1, 0, 2, 0, 3 };
    System.out.println(countValidSelections(nums));
  }
}
