import java.util.Arrays;

public class lc33 {
  
  private static int search(int[] nums, int target){
    int n = nums.length;
    if (n==1) return nums[0]==target?0:-1;
    if (n<=3){
      for (int i=0; i<n;i++) if (nums[i]==target) return i;
      return -1;
    }
    int firstE = nums[0];
    if (firstE < nums[n-1]){
      int ind = Arrays.binarySearch(nums, target);
      return ind>=0?ind:-1;
    }
    int lp = 0;
    int rp = n;
    int cp = lp + (rp-lp)/2;
    while (rp-lp>1){
      if (nums[cp] > firstE) lp = cp;
      else if (nums[cp] < firstE) rp = cp;
      cp = lp + (rp-lp)/2;
    }
    int ind0 = nums[lp]>=nums[rp]?rp:lp;
    if (target>=firstE){
      int ans = Arrays.binarySearch(nums, 0, ind0, target);
      return ans>=0?ans:-1;
    }
    else{
      int ans = Arrays.binarySearch(nums, ind0, n, target);
      return ans>=0?ans:-1;
    }
  }

  public static void main(String[] args) {
    int[] nums = {4,5,6,7,0,1,2};
    // int[] nums = {0,1,2,3,4};
    // int[] nums = {4,5,6,7,0,1,2,3};
    // int[] nums = {4,5,6,7,0,1,2,3};
    int target = 4;
    System.out.println( search(nums, target) );
  }
}
