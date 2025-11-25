import java.util.Arrays;

public class lc3289 {
  public int[] getSneakyNumbers(int[] nums) {
    int l = nums.length;
    int[] map = new int[l - 2];
    int[] ans = new int[2];
    int j = 0;
    for (int n : nums) {
      map[n]++;
      if (map[n] == 2)
        ans[j++] = n;
    }
    return ans;
  }
}
