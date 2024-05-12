import java.util.Arrays;

public class lc2971 {
  private static long largestPerimeter(int[] nums) {
    Arrays.sort(nums);
    int len = nums.length;
    long[] nums1 = new long[len];
    for(int i=0;i<len;i++) nums1[i] = (long) nums[i];
    long[] memo = new long[len];
    memo[0] = (long) nums[0];
    for (int i =1; i<len;i++){
      memo[i] = memo[i-1]+(long)nums[i];
    }
    int pos;
    for (int i=len-2; i>=1;i--){
      pos=Arrays.binarySearch(nums1, memo[i]);
      if (pos>=3){
        if (pos-1>i) return nums[pos-1]+memo[i];
      }
      else if (pos <0){
        if (pos*-1-2>i && pos*-1-1<=len) return nums[pos*-1-2]+memo[i];
      }
    }
    return -1l;
  }
  
  public static void main(String[] args) {
    int[] nums = {50,12,2,3,4};
    System.out.println(largestPerimeter(nums));
  }
}
