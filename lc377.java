public class lc377 {
  
  private static int combinationSum4(int[] nums, int target) {
    int[] memo = new int[target+1];
    memo[0] = 1;
    for (int i=0;i<=target;i++){
      if (memo[i]>0){
        for(int num:nums) {
          if (i+num<=target) memo[i+num] +=memo[i] ;
        }
      }
    }
    return memo[target];
  }

  public static void main(String[] args) {
    int[] nums = {1,2,3};
    int target = 5;
    System.out.println( combinationSum4(nums, target) );
  }
}
