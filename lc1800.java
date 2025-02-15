class lc1800{
  
  private static int maxAscendingSum(int[] nums) {
    int l = nums.length;
    int lp = 0;
    int rp = 1;
    int ans = 0;
    int tmp = 0;
    while (lp <l){
      rp = 1;
      tmp = nums[lp];
      while (lp + rp < l){
        if (nums[lp + rp] > nums[lp+rp-1]){
          tmp += nums[lp+rp];
          rp++;
        }
        else
          break;
      }
      lp += rp;
      ans = Math.max(ans, tmp);
    }
    return ans;
  }

  public static void main(String[] args){
    int[] nums = {3,6,10,1,8,9,9,8,9};
    System.out.println(maxAscendingSum(nums));
  }

}
