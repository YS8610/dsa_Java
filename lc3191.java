public class lc3191 {
  private static int minOperations(int[] nums) {
    int l = nums.length;
    int z = 0;
    int ans = 0;
    for (int i = 0; i < l; i++)
      z += nums[i] == 0 ? 1 : 0;
    if (z % 3 != 0)
      return -1;
    for (int i = 0; i < l - 2; i++) {
      if (nums[i] == 0) {
        for (int j = i; j < i+3 && j <l; j++)
          nums[j] ^= 1;
        ans++;
      }
    }
    return ans;
  }

  public static void main(String[] args) {
    int[] nums = {0,1,1,1,0,0};
    System.out.println(minOperations(nums));
  }
}
