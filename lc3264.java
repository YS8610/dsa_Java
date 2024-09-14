import java.util.Arrays;

public class lc3264 {

  private static int[] getFinalState(int[] nums, int k, int multiplier) {
    int l = nums.length;
    int m;
    for (int i =0;i<k;i++){
      m = nums[0];
      for (int j =0;j<l;j++){
        m = Math.min(m, nums[j]);
      }
      for (int j =0;j<l;j++){
        if (nums[j] == m) {
          nums[j] *= multiplier;
          break;
        }
      }
    }
    return nums;
  }

  public static void main(String[] args) {
    int[] nums = {2,1,3,5,6};
    int k = 5, multiplier = 2;
    System.out.println(Arrays.toString(getFinalState(nums, k, multiplier)));
  }
}