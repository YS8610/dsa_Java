public class lc525 {
  private static int findMaxLength(int[] nums){
    int n = nums.length;
    if (n<=1) return 0;
    int[] memo = new int[n];
    memo[0] = nums[0];
    for (int i=1;i<n;i++){
      memo[i]= memo[i-1] + nums[i];
    }
    int maxLen = 0;
    outloop:
    for (int i=2;i<=n;i+=2){
      int sum = memo[i-1];
      if ( i/2 == sum ){
        maxLen = i;
        continue outloop;
      } 
      for (int j=1; j<=n-i;j++){
        sum = sum - nums[j-1]+nums[j+i-1];
        if ( i/2 == sum ){
          maxLen = i;
          continue outloop;
        } 
      }
    }
    return maxLen;
  }

  public static void main(String[] args) {
    int[] nums = {0,0,1,0,0,0,1,1};
    System.out.println( findMaxLength(nums) );
  }
}
