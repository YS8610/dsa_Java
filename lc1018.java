import java.util.ArrayList;
import java.util.List;

public class lc1018 {
  public List<Boolean> prefixesDivBy5(int[] nums) {
    int l = nums.length;
    List<Boolean> ans = new ArrayList<>(l);
    ans.add(nums[0] == 0);
    for (int i = 1, tmp = nums[0]; i < l; i++) {
      tmp = (tmp * 2 + nums[i]) % 5;
      ans.add(tmp == 0);
    }
    return ans;
  }
}
