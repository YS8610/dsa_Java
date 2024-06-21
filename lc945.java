import java.util.Arrays;

public class lc945 {

  private static int minIncrementForUnique(int[] nums) {
    int i = 0;
    int ans = 0;
    Arrays.sort(nums);
    for (int n : nums) {
      i = Math.max(i, n);
      ans += i - n;
      i++;
    }
    return ans;
  }

  public static void main(String[] args) {
    int[] nums = {3,2,1,2,1,7};
    System.out.println(minIncrementForUnique(nums));
  }
}
