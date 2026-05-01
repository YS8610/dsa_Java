import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class lc2121 {
  public long[] getDistances(int[] nums) {
    int l = nums.length;
    long[] ans = new long[l];
    Map<Integer, List<Long>> prefix = new HashMap<>();
    for (int i = 0; i < l; i++) {
      if (!prefix.containsKey(nums[i])) {
        List<Long> list = new ArrayList<>(List.of(0l));
        prefix.put(nums[i], list);
      }
      int len = prefix.get(nums[i]).size();
      long tmp = prefix.get(nums[i]).get(len - 1);
      prefix.get(nums[i]).add(0l + i + tmp);
    }
    // System.out.println(prefix.toString());
    Map<Integer, Integer> freq = new HashMap<>();
    for (int i = 0; i < l; i++) {
      freq.put(nums[i], freq.getOrDefault(nums[i], 0) + 1);
      int pos = freq.get(nums[i]);
      List<Long> list = prefix.get(nums[i]);
      int len = list.size();
      if (len == 2) {
        ans[i] = 0;
        continue;
      }
      long total = list.get(len - 1);
      long tmpsum = 1l * pos * i - list.get(pos);
      tmpsum += total - list.get(pos) - 1l * (len - 1 - pos) * i;
      ans[i] = tmpsum;
    }
    return ans;
  }
}
