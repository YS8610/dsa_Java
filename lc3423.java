public class lc3423 {
  static public int maxAdjacentDistance(int[] nums) {
    int l = nums.length;
    int ans = 0;
    ans = Math.max(Math.abs(nums[0] - nums[l - 1]), Math.abs(nums[0] - nums[1]));
    for (int i = 1, tmp=0; i < l; i++, tmp = 0){
      tmp = Math.max(Math.abs(nums[i] - nums[i - 1]), Math.abs(nums[i] - nums[(i + 1) % l]));
      ans = Math.max(tmp, ans);
    }
    return ans;
  }

  public static void main(String[] args){
    int[] nums = {-4,-2,-3};
    System.out.println(maxAdjacentDistance(nums));
  }
}
