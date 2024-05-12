import java.util.Arrays;

public class lc1480 {
  private static int[] runningSum(int[] nums) {
    for (int i=1, n=nums.length;i<n;i++)
      nums[i]+= nums[i-1];
    return nums;
  }

  public static void main(String[] args) {
    int[] nums = {1,2,3,4};
    System.out.println(Arrays.toString(runningSum(nums)));
  }
}
