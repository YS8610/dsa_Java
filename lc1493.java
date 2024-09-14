import java.util.ArrayList;
import java.util.List;

public class lc1493 {

  private static int longestSubarray(int[] nums) {
    List<Integer> list = new ArrayList<>(nums.length);
    int l = nums.length;
    int i = 0, j = 0;
    while (i < l) {
      if (nums[i] == 0) {
        list.add(0);
        i++;
        continue;
      }
      j = 0;
      while (i + j < l && nums[i + j] == 1) j++;
      list.add(j);
      i += j;
    }
    int lsize = list.size();
    if (lsize == 1) {
      if (list.get(0) <= 1) return 0;
      return list.get(0) - 1;
    }
    if (lsize == 2) {
      return Math.max(list.get(0), list.get(1));
    }

    int sum = 0;
    int ans = 0;
    for (int k = 0, n = lsize - 2; k < n; k++) {
      if (k == 0) sum =
        list.get(k) + list.get(k + 1) + list.get(k + 2); else sum =
        sum - list.get(k - 1) + list.get(k + 2);
      ans = Math.max(sum, ans);
    }
    return ans;
  }

  public static void main(String[] args) {
    int[] nums = {0,1,1,1,0,1,1,0,1};
    System.out.println(longestSubarray(nums));
  }
}
