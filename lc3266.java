import java.util.Arrays;

public class lc3266{
    private static int[] getFinalState(int[] nums, int k, int multiplier) {
    int l = nums.length;
    int m;
    long lm;
    int mod = 1000000000 + 7;
    for (int i =0;i<k;i++){
      m = nums[0];
      for (int j =0;j<l;j++){
        m = Math.min(m, nums[j]);
      }
      for (int j =0;j<l;j++){
        if (nums[j] == m) {
          lm = (nums[j] * (long)multiplier) % mod;
          nums[j] = (int)lm;
          break;
        }
      }
    }
    return nums;
  }

  public static void main(String[] args) {
    int[] nums = {1000000000,999999999};
    int k = 2, multiplier = 1000000000;
    System.out.println(Arrays.toString(getFinalState(nums, k, multiplier)));
  }
}