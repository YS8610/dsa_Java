import java.util.Arrays;

public class lc1608 {
  private static int specialArray(int[] nums) {
    Arrays.sort(nums);
    for (int i = 1; i <=1000; i++){
      for (int j = 0, n=nums.length; j<n;j++){
        if (i <= nums[j]){
          if (n - (j) == i) return i;
          break;
        } 
      }
    }
    return -1;
  }

  public static void main(String[] args) {
    int[] nums = { 3, 5 };
    System.out.println(specialArray(nums));
  }
}
