
public class lc1760 {
  private static boolean can(int[] nums, int guessSize, int maxOp){
    int ops = 0;
    for (int n:nums){
      if (n <= guessSize) continue;
      ops += n / guessSize + (n%guessSize==0?-1:0);
    }
    return ops<=maxOp;
  }
  
  private static int minimumSize(int[] nums, int maxOperations) {
    int sum =nums[0];
    for (int n:nums) sum = Math.max(sum,n);
    int lp = 1;
    int rp = sum;
    int m = (rp - 1)/2+lp;
    while (lp < rp){
      if (can(nums, m, maxOperations)) rp = m;
      else lp = m;
      m = (rp - lp)/2+lp;
      if (rp - lp == 1) break;
    }
    if (can(nums, lp, maxOperations))
      return lp;
    return rp;
  }

  public static void main(String[] args) {
    int[] nums = {9};
    int maxOperations = 2;
    System.out.println(minimumSize(nums, maxOperations));
  }
}
