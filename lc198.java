public class lc198 {
  private static int rob(int[] nums) {
    int n= nums.length;
    if(n==1) return nums[0];
    if(n==2) return Math.max(nums[0], nums[1]);

    int[] ans = new int[n];
    ans[n-1] = nums[n-1];
    ans[n-2] = Math.max(nums[n-1], nums[n-2]);
    for (int i=n-3; i>=0;i--){
      ans[i] = Math.max( ans[i+1],ans[i+2]+nums[i] );
    }
    return Math.max(ans[0], ans[1]);
  }

  public static void main(String[] args) {
    int[] nums = {2,7,9,3,1};
    System.out.println( rob(nums) );
  }
}
