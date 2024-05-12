public class lc300 {

  private static int lengthOfLIS(int[] nums) {
    int n = nums.length;
    if (n == 1) return 1;
    int ans = 1;
    int cp = 0;
    int[] memo = new int[n];
    memo[0] = 1;
    for (int r = 1; r < n; r++) {
      memo[r] = 1;
      cp = 0;
      while (cp < r) {
        if (nums[cp] < nums[r]) memo[r] = Math.max(memo[r], memo[cp] + 1);
        cp++;
      }
      ans = Math.max(ans, memo[r]);
    }
    return ans;
  }

  public static void main(String[] args) {
    int[] nums = { 10, 9, 2, 5, 3, 7, 101, 18 };
    System.out.println(lengthOfLIS(nums));
  }
}
