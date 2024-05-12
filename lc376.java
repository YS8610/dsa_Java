public class lc376 {
  private static int wiggleMaxLength(int[] nums) {
    int l = nums.length;
    int[][] dp = new int[l][2];
    dp[0][0] = 1;
    dp[0][1] = 1;
    for (int i =1;i<l;i++){

    }

    return 0;
  }

  public static void main(String[] args) {
    int[] nums = {1,17,5,10,13,15,10,5,16,8};
    System.out.println(wiggleMaxLength(nums));
  }
}
