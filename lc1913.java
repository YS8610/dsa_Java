import java.util.Arrays;

public class lc1913 {
  private static int maxProductDifference(int[] nums) {
    int len = nums.length;
    Arrays.sort(nums);
    return nums[len-1]*nums[len-2]-nums[0]*nums[1];
  }

  public static void main(String[] args) {
    int[] nums = {5,6,2,7,4};
    System.out.println( maxProductDifference(nums) );
  }
}
