import java.util.Arrays;

public class lc3011 {

  private static int setbit(int n, int[] bitmask) {
    int ans = 0;
    for (int i : bitmask) if ((n & i) > 0) ans++;
    return ans;
  }

  private static boolean canSortArray(int[] nums) {
    int i = 0;
    int j = 0;
    int l = nums.length;
    int[] bitmask = new int[32];
    int tmp = 1;
    for (int k = 0; k < 31; k++) {
      bitmask[k] = tmp;
      tmp <<= 1;
    }
    bitmask[31] = Integer.MAX_VALUE;
    int[] memo = new int[l];
    for (int ii = 0; ii < l; ii++) memo[ii] = setbit(nums[ii], bitmask);
    while (i < l - 1) {
      j = 1;
      while (i + j < l && memo[i] == memo[i + j]) j++;
      if (j > 1) {
        Arrays.sort(nums, i, i + j);
        i += j;
      } else i++;
    }
    tmp = nums[0];
    for (int ii = 1; ii < l; ii++) {
      if (nums[ii] < tmp) return false;
      tmp = nums[ii];
    }
    return true;
  }

  public static void main(String[] args) {
    int[] nums = {8,4,2,30,15};
    System.out.println(canSortArray(nums));
  }
}
