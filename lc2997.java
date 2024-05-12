public class lc2997 {

  private static int minOperations(int[] nums, int k) {
    int[] memo = new int[32];
    int[] kbinary = new int[32];
    int i = 31;
    int tmp;
    int ans = 0;
    tmp = k;
    while (tmp / 2 != 0) {
      kbinary[i] = tmp % 2;
      tmp /= 2;
      i--;
    }
    kbinary[i] = tmp % 2;
    tmp = nums[0];
    for (int j=1,n=nums.length;j<n;j++) {
      tmp ^= nums[j];
    }
    i = 31;
    while (tmp / 2 != 0) {
      memo[i] = tmp % 2;
      tmp /= 2;
      i--;
    }
    memo[i] = tmp % 2;

    for (int j = 0; j < 32; j++) {
      if (memo[j] != kbinary[j]) ans++;
    }
    return ans;
  }

  public static void main(String[] args) {
    int[] nums = {2,1,3,4};
    int k = 1;
    System.out.println(minOperations(nums, k));
  }
}
