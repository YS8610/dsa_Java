public class lc713 {
  private static int numSubarrayProductLessThanK(int[] nums, int k) {
    int len = nums.length;
    if (k==0) return 0;
    if (len == 1) return k>nums[0]?1:0;
    int rp =0;
    int lp = 0;
    int sum = nums[0];
    int ans = 0;
    while (rp < len) {
      if (rp == 0) sum = nums[lp];
      else sum *= nums[rp];
      if (sum >= k) {
        sum /= nums[rp];
        break;
      }
      rp++;
    }
    ans = rp;
    rp--;
    for (lp=1;lp<len;lp++){
      if (rp < lp) rp = lp;
      if (rp == lp) sum = nums[lp];
      else sum /= nums[lp-1];
      if (sum >= k) {
        sum /= nums[rp];
        continue;
      }
      rp++;
      while (rp<len){
        if (rp == lp) sum = nums[lp];
        else sum *= nums[rp];
        if (sum >= k) {
          sum /= nums[rp];
          break;
        }
        rp++;
      }
      ans += rp - lp;
      rp--;
    }
    return ans;
  }

  public static void main(String[] args) {
    int[] nums = {10,9,10,4,3,8,3,3,6,2,10,10,9,3};
    int k = 1;
    System.out.println(numSubarrayProductLessThanK(nums, k));
  }
}
