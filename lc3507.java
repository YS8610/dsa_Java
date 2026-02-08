import java.util.ArrayList;
import java.util.List;

public class lc3507 {
  public int minimumPairRemoval(int[] nums) {
    int ans = 0;
    List<Integer> list = new ArrayList<>();
    for (int n : nums)
      list.add(n);
    while (!can(list)) {
      process(list);
      ans++;
    }
    return ans;
  }

  public void process(List<Integer> nums) {
    int l = nums.size();
    int small = nums.get(0) + nums.get(1);
    int index = 0;
    for (int i = 1; i < l; i++)
      small = Math.min(small, nums.get(i) + nums.get(i - 1));
    for (int i = 1, tmp = 0; i < l; i++) {
      tmp = nums.get(i) + nums.get(i - 1);
      if (tmp != small)
        continue;
      nums.set(i - 1, tmp);
      index = i;
      break;
    }
    nums.remove(index);
  }

  public boolean can(List<Integer> nums) {
    if (nums.size() == 1)
      return true;
    int l = nums.size();
    for (int i = 1; i < l; i++)
      if (nums.get(i) < nums.get(i - 1))
        return false;
    return true;
  }
}
