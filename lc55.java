import java.util.Arrays;

public class lc55 {
  private static boolean canJump(int[] nums){
    int n = nums.length;
    boolean[] memo = new boolean[n];
    Arrays.fill(memo, false);
    memo[0] = true;
    if (n==1) return true;
    for (int i=0;i<n;i++){
      if (memo[i]){
        int j = 1;
        while (j<=nums[i] && i+j <n){
          memo[i+j] = true;
          j++;
          if (memo[n-1]) return true; 
        }
      }
    }
    return false;
  }

  private static boolean canJump1(int[] nums){
    int n = nums.length;
    if (n==1) return true;
    if(n>=2 && nums[0]==0) return false;
    int[] memo = new int[n];
    memo[0] = nums[0];
    for(int i=1;i<n;i++){
      memo[i] = Math.max( nums[i], memo[i-1] -1);
      if (memo[i] ==0 && i!=n-1 ) return false;
      if (i + memo[i]>n-1) return true;
    }
    return true;
  }
  public static void main(String[] args) {
    int[] nums = {1,2,3,4};
    System.out.println( canJump(nums) );
    System.out.println( canJump1(nums) );
  }
}
