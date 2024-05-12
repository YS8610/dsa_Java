import java.util.Arrays;

public class lc34 {
  private static int[] searchRange(int[] nums, int target){
    int index = Arrays.binarySearch(nums, target);
    int n = nums.length;
    if (index <0) return new int[]{-1,-1};
    int lp = index;
    int rp = index;
    while (lp>0 && nums[lp]==target){
      int temp = Arrays.binarySearch(nums, 0, lp, target);
      if (temp<0) break;
      else lp = temp;
    }
    while (rp<n && nums[rp]==target){
      int temp = Arrays.binarySearch(nums, rp+1, n, target);
      if (temp<0) break;
      else rp = temp;
    }
    return new int[]{lp,rp};
  }

  public static void main(String[] args) {
    int[] nums = {5,7,7,8,8,10};
    int target = 8;

    System.out.println( Arrays.toString(searchRange(nums, target)) );
  }
}
