import java.util.Arrays;

public class lc2563 {

  private static int move1(int[] nums, int i, int lower) {
    int pos1 = Arrays.binarySearch(nums, i + 1, nums.length, lower - nums[i]);
    if (pos1 >= 0) {
      while (pos1 >= 0) pos1 =
        Arrays.binarySearch(nums, i + 1, pos1, lower - nums[i]);
      return -pos1 - 1;
    }
    pos1 = -pos1 - 1;
    if (pos1 == i) pos1++;
    if (pos1 >= nums.length) pos1 = nums.length - 1;
    return pos1;
  }

  private static int move2(int[] nums, int i, int upper) {
    int pos2 = Arrays.binarySearch(nums, i + 1, nums.length, upper - nums[i]);
    if (pos2 >= 0) {
      while (pos2 + 1 < nums.length && nums[pos2 + 1] == nums[pos2]) pos2++;
      return pos2;
    }
    pos2 = -pos2 - 2;
    return pos2 >= nums.length ? nums.length - 1 : pos2;
  }

  public long countFairPairs(int[] nums, int lower, int upper) {
    int l = nums.length;
    if (l == 1) return 0;
    long ans = 0;
    Arrays.sort(nums);
    int pos1 = 0;
    int pos2 = 0;
    for (int i = 0; i < l - 1; i++) {
      if (
        nums[i] + nums[i + 1] > upper || nums[i] + nums[l - 1] < lower
      ) continue;
      pos1 = move1(nums, i, lower);
      pos2 = move2(nums, i, upper);
      ans += pos2 - pos1 + 1;
    }
    return ans;
  }
}
