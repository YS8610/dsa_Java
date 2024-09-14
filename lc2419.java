public class lc2419 {
  private static int longestSubarray(int[] nums) {
    int l = nums.length;
    int m =0;
    for (int n:nums) m = Math.max(n, m);
    int i=0;
    int j=0;
    int ans=1;
    while (i < l){
      j = 0;
      if (nums[i] == m){
        while (i+j <l && nums[i+j]==m) j++;
        ans = Math.max(ans, j);
      }
      if (j == 0) i++;
      else i +=j;
    }
    return ans;
  }

  public static void main(String[] args) {
    int[] nums = {1,2,3,3,2,2};
    System.out.println(longestSubarray(nums));
  }
}
