import java.util.Arrays;

public class lc2191 {

  private static int transform(int[] mapping, int a) {
    int ans = 0;
    int n = 1;
    while (a / 10 > 0) {
      ans += mapping[a % 10] * n;
      n *= 10;
      a /= 10;
    }
    ans += mapping[a % 10] * n;
    return ans;
  }

  private static int[] sortJumbled(int[] mapping, int[] nums) {
    Integer[] b = new Integer[nums.length];
    for (int i = 0, n = nums.length; i < n; i++) b[i] = nums[i];
    Arrays.sort(
      b,
      (m1, m2) ->
        Integer.compare(transform(mapping, m1), transform(mapping, m2))
    );
    for (int i = 0, n = nums.length; i < n; i++) nums[i] = b[i];
    return nums;
  }

  public static void main(String[] args) {
    int[] mapping = {8,9,4,0,2,1,3,5,7,6}, nums = {991,338,38};
    System.out.println(Arrays.toString(sortJumbled(mapping, nums)));
  }
}
