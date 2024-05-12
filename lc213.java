public class lc213 {
  private static int rob(int[] nums) {
    int n = nums.length;
    if (n==1) return nums[0];
    if (n==2) return Math.max(nums[0], nums[1]);
    if (n==3) return Math.max(nums[0], Math.max(nums[1], nums[2]));

    int[] ans = new int[n];
    ans[n-1] = nums[n-1];
    ans[n-2] = Math.max(nums[n-1], nums[n-2]);
    for (int i=n-3;i>=0;i--){
      ans[i] = Math.max(nums[i]+ ans[n-1], nums[n-2]) ;
      if (i==1) ans[i] = Math.max(ans[i+1], nums[i]+ans[i+2]-nums[n-1]);
      if (i==0) ans[i] = Math.max(ans[i+1], nums[i]+ans[i+2]-nums[n-1]);
    }
    return Math.max(ans[3], Math.max(ans[0],ans[1])) ;
  }
  public static void main(String[] args) {
    int[] nums = {1,2,3,1,7,3,5};
    System.out.println( rob(nums));
  }
}
