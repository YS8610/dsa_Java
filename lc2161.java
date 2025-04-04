import java.util.Arrays;

public class lc2161 {

  private static int[] pivotArray(int[] nums, int pivot) {
    int l = nums.length;
    int[] ans = new int[l];
    int small = 0;
    int p = 0;
    for (int n : nums) {
      if (n == pivot)
        p++;
      else if (n < pivot)
        small++;
    }
    int s = 0;
    int ppivot = small;
    int pbig = ppivot + p;
    for (int n : nums) {
      if (n < pivot)
        ans[s++] = n;
      else if (n == pivot)
        ans[ppivot++] = pivot;
      else
        ans[pbig++] = n;
    }
    return ans;
  }

  public static void main(String[] args) {
    int[] nums = {-3,4,3,2};
    int pivot = 2;
    System.out.println(Arrays.toString(pivotArray(nums, pivot)));
  }
}