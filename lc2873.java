public class lc2873 {
  static public long maximumTripletValue(int[] nums) {
    int l = nums.length;
    int[] prefix = new int[l];
    int[] postfix = new int[l];
    prefix[0] = nums[0];
    postfix[l - 1] = nums[l - 1];
    for (int i = 1; i < l; i++)
      prefix[i] = Math.max(prefix[i - 1], nums[i]);
    for (int i = l - 2; i >= 0; i--)
      postfix[i] = Math.max(nums[i], postfix[i + 1]);
    long ans = 0;
    for (int i = 1, n = l - 1; i < n; i++)
      ans = Math.max(ans, (prefix[i - 1] - nums[i]) * (long) postfix[i + 1]);
    return ans;
  }

  public static void main(String[] args) {
    int[] nums = {12,6,1,2,7};
    System.out.println(maximumTripletValue(nums));
  }
}
