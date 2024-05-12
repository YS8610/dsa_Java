import java.util.Arrays;

public class lc561 {
  
  private static int arrayPairSum(int[] nums) {
    Arrays.sort(nums);
    int ans = 0;
    for (int i=0, n=nums.length;i<n;i+=2){
      ans += Math.min(nums[i],nums[i+1] );
    }
    return ans;
  }

  public static void main(String[] args) {
    int[] nums = {6,2,6,5,1,2};
    System.out.println( arrayPairSum(nums) );
  }
}
