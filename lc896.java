public class lc896 {
  
  private static boolean isMonotonic(int[] nums) {
    int n = nums.length;
    if (n==1) return true;
    for (int i=1;i<n;i++){
      if (nums[i-1] == nums[i]) continue;
      else if (nums[i-1] < nums[i]) {
        while(i<n){
          if (nums[i-1]>nums[i]) return false;
          i++;
        }
      }
      else{
        while (i<n){
          if (nums[i-1]<nums[i]) return false;
          i++;
        }
      }
    }
    return true;
  }

  public static void main(String[] args) {
    int[] nums = {1,2,2,3};
    System.out.println( isMonotonic(nums) );
  }

}
