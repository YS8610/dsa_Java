import java.util.Arrays;

public class lc2149 {

  private static int[] rearrangeArray(int[] nums) {
    int len = nums.length;
    int[] pos = new int[len / 2];
    int[] neg = new int[len / 2];
    int a = 0;
    int b = 0;
    for (int num : nums) {
      if (num > 0) {
        pos[a] = num;
        a++;
      } else {
        neg[b] = num;
        b++;
      }
    }
    for (int i = 0; i < len; i += 2) {
      nums[i] = pos[i / 2];
    }
    for (int i = 1; i < len; i += 2) {
      nums[i] = neg[i / 2];
    }

    return nums;
  }

  public static void main(String[] args) {
    int[] nums = { 3, 1, -2, -5, 2, -4 };
    System.out.println(Arrays.toString(rearrangeArray(nums)));
  }
}
