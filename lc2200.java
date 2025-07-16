import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class lc2200 {
  static public List<Integer> findKDistantIndices(int[] nums, int key, int k) {
    int l = nums.length;
    int[] pos = new int[l];
    List<Integer> ans = new ArrayList<>();
    Arrays.fill(pos, l + 1);
    for (int i = 0, lp = 0, rp = 0; i < l; i++) {
      if (nums[i] != key)
        continue;
      lp = i;
      rp = i;
      while (lp >= 0 && pos[lp] > (i - lp)) {
        pos[lp] = i - lp;
        lp--;
      }
      while (rp < l && pos[rp] >= (rp - i)) {
        pos[rp] = rp - i;
        rp++;
      }
    }
    for (int i = 0; i < l; i++)
      if (pos[i] <= k)
        ans.add(i);
    return ans;
  }

  public static void main(String[] args) {
    int[] nums = {3,4,9,1,3,9,5};
    int key = 9, k = 1;
    System.out.println(findKDistantIndices(nums, key, k).toString());
  }
}
