import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class lc3315 {
  static public int[] minBitwiseArray(List<Integer> nums) {
    int l = nums.size();
    int[] ans = new int[l];
    for (int i = 0, pos = 0; i < l; i++) {
      if (nums.get(i) % 2 == 0) {
        ans[i] = -1;
        continue;
      }
      pos = 0;
      while ((nums.get(i) & (1 << pos)) != 0)
        pos++;
      ans[i] = nums.get(i) ^ (1 << (pos - 1));
    }
    return ans;
  }

  public static void main(String[] args) {
    List<Integer> nums = new ArrayList<>(Arrays.asList(11,13,31));
    System.out.println(Arrays.toString(minBitwiseArray(nums)));
  }

}
