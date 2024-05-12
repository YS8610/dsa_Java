import java.util.Arrays;

public class lc1 {
  private static int[] twoSum(int[] nums, int target) {
    for (int i=0, n=nums.length; i<n;i++ ){
      // if (nums[i]>target) continue;
      for (int j=n-1; j>i;j--){
        // if (nums[j]>target) continue;
        if (nums[i]+nums[j] == target) return new int[]{i,j};
      }
    }
    return null;
  }

  private static int[] twoSum1(int[] nums, int target) {
    int[] temp = Arrays.copyOf(nums,nums.length);
    Arrays.sort(temp);
    int[] ans = new int[2];
    for (int i=0, n=nums.length;i<n-1;i++){
      int remainder = target - temp[i];
      int index = Arrays.binarySearch(temp, i+1, n, remainder);
      if (index<0) continue;
      else {
        boolean n1Found=false, n2Found=false;
        for (int j=0;j<n;j++){
          if (nums[j]==temp[i] && !n1Found){
            ans[0] = j;
            n1Found=true;
            continue;
          }
          if (nums[j]==temp[index] && !n2Found){
            ans[1] = j;
            n2Found=true;
          } 
          if (n2Found && n1Found) break;
        }
        return ans;
      }
    }
    return new int[]{0};
  }

  public static void main(String[] args) {
    int[] nums = {-3,4,3,90};
    int target = 0;
    System.out.println( Arrays.toString( twoSum(nums,target) ) );
    System.out.println( Arrays.toString( twoSum1(nums,target) ) );
  }
}
