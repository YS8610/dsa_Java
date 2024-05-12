public class lc268 {
  private static int missingNumber(int[] nums) {
    int len = nums.length;
    int[] memo = new int[len+1];
    for(int num:nums) memo[num]=1;
    for(int i=0;i<=len;i++) {
      if (memo[i]==0) return i;
    }
    return 0;
  }

  public static void main(String[] args) {
    int[] nums = {3,0,1};
    System.out.println(missingNumber(nums));
  }
}
