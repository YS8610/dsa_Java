public class lc3452 {
  private static int sumOfGoodNumbers(int[] nums, int k) {
    int l = nums.length;
    int ans = 0;
    for (int i =0; i<l; i++){
      // both side
      if (i+k >= l && i-k < 0)
        ans += nums[i];
      // left side out
        else if (i - k <0)
          ans += nums[i] > nums[i+k]? nums[i] : 0;
        else if (i + k >= l)
          ans += nums[i] > nums[i-k]? nums[i] : 0;
        else
          ans += nums[i] > nums[i-k] && nums[i] >nums[i+k]? nums[i] : 0;
    }
    return ans;
  }

  public static void main(String[] args) {
    int[] nums = {1,3,2,1,5,4};
    int k = 2;
    System.out.println(sumOfGoodNumbers(nums, k));
  }
}
