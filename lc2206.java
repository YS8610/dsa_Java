import java.util.Arrays;

public class lc2206 {
  private static boolean divideArray(int[] nums) {
    int l = nums.length;
    Arrays.sort(nums);
    for (int i=0;i<l;i+=2)
        if (nums[i] != nums[i+1])
            return false;
    return true;
  }

  public static void main(String[] args) {
    int[] nums = {9,9,19,10,9,12};
    System.out.println(divideArray(nums));
  }
}

