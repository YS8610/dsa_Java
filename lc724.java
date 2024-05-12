public class lc724 {
  private static int pivotIndex(int[] nums){
    int n = nums.length;
    int[] memo = new int[n];
    memo[0] = nums[0];
    for(int i=1;i<n;i++){
      memo[i] += memo[i-1]+nums[i];
    }
    for (int i=0;i<n;i++){
      if (i==0) {
        if (memo[n-1] - nums[0]==0) return 0;
      }
      else{
        int result = memo[i-1] - ( memo[n-1] - memo[i] );
        if (result == 0) return i;
      }
    }
    return -1;
  }

  public static void main(String[] args) {
    int[] nums = {1,7,3,6,5,6};
    System.out.println( pivotIndex(nums) );
  }
}
