public class lc53 {
  private static int maxSubArray1(int[] nums){
    int n = nums.length;
    int lp =0;
    int rp = n-1;
    int max = 0;
    int result = 0;
    for (int num:nums) result+=num;
    max = result;
    while (lp<rp){
      result=0;
      if ( nums[lp]<=nums[rp] ) lp++;
      if (nums[lp]> nums[rp]) rp--;

      for (int i=lp;i<=rp;i++) result += nums[i];
      max = Math.max(max, result);
    }
    return max;
  }

  private static int maxSubArray(int[] nums){
    int max = nums[0];
    int result = nums[0];
    
    for (int i=1,n=nums.length;i<n;i++){
      result +=nums[i];
      result = Math.max(nums[i], result);
      max = Math.max(max, result);
    }
    return max;
  }
// kadane algorithm
  public static void main(String[] args) {
    int[] nums = {-2,1,-3,4,-1,2,1,-5,4};
    System.out.println( maxSubArray(nums));
  }
}
