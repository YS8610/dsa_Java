import java.util.Arrays;

public class lc912 {
  private static void merge(int[] nums, int[] ls, int[] rs){
    int i = 0, j = 0, k = 0;
    int ll = ls.length;
    int lr = rs.length;
    while (i < ll && j <lr){
      if (ls[i] <= rs[j]) nums[k] = ls[i++];
      else nums[k] = rs[j++];
      k++;
    }
    while (i < ll) nums[k++] = ls[i++];
    while (j <lr) nums[k++] = rs[j++];
  }
  
  private static void mergesort(int[] nums){
    int len = nums.length;
    if (len < 2) return;

    int mid = len/2;
    int[] ls = Arrays.copyOfRange(nums, 0, mid);
    int[] rs = Arrays.copyOfRange(nums, mid, len);
    mergesort(ls);
    mergesort(rs);
    merge(nums,ls,rs);
  }
  
  private static int[] sortArray(int[] nums) {
    mergesort(nums);
    return nums;
  }
  
  public static void main(String[] args) {
    int[] nums = {5,1,1,2,0,0};
    System.out.println(Arrays.toString(sortArray(nums)));
  }
}
