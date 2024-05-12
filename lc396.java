public class lc396 {
  
  private static int maxRotateFunction(int[] nums) {
    int n = nums.length;
    int maxResult=0;
    // initialize result value
    for (int i =0;i<n;i++){
      maxResult += nums[i]*i;
    }
    // starting the loop
    for (int i =1; i<n;i++){
      int result = 0;
      int counter =0;

      for (int j = i;j<n;j++){
        if (counter!=0) result += nums[j]*counter;
        counter++;
      }
      for (int j=0;j<i;j++){
        if (counter!=0) result += nums[j]*counter;
        counter++;
      }
      // System.out.println(result);
      maxResult = Math.max(maxResult, result);
    }
    return maxResult;
  }



  public static void main(String[] args) {
    int[] nums = {100};
    System.out.println( maxRotateFunction(nums) );
  }
}
