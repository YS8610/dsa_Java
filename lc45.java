public class lc45 {
  
  private static int jump(int[] nums){
    int n = nums.length;
    if (n==1) return 0;
    if (n==2 && nums[0]>0) return 1;
    int[] memo = new int[n];
    memo[0] = nums[0];
    int counter = 1;
    if (nums[0]>=n-1) return 1;
    for(int i=1;i<n;i++){
      memo[i] = Math.max( nums[i], memo[i-1] -1);
      counter ++;
      if (i + memo[i]>=n-1) return counter;
    }
    return 0;
  }
  private static int jump1(int[] nums){
    int n = nums.length;
    if (n==1) return 0;
    if (n==2 && nums[0]>0) return 1;
    int[] memo = new int[n];
    memo[0] = nums[0];
    int counter = 0;
    for (int i=0; i<n;){
      int max = 0;
      int ind = 0;
      if (i+nums[i]>=n-1) return counter+1;
      for(int j=i+1; j<=i+nums[i];j++){
        if (nums[j]+j>max) {
          max= nums[j]+j;
          ind = j;
        }
      }
      i = ind;
      counter++;
    }
    return counter;
  }

  public static void main(String[] args) {
    // int[] nums = {3,1,10,100,1,1,1,1,1,0,1,1,1,1,1,1,1};
    int[] nums = {2,3,0,1,4};
    System.out.println( jump1(nums) );
  }
}
