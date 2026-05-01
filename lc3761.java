import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class lc3761 {
  static public int minMirrorPairDistance(int[] nums) {
    int l = nums.length;
    int ans = l + 1;
    Map<Integer, List<Integer>> map = new HashMap<>();
    for (int i = 0; i < l; i++) {
      if (map.containsKey(nums[i])) {
        map.get(nums[i]).add(i);
        continue;
      }
      map.put(nums[i], new ArrayList<>(List.of(i)));
    }
    long tmp;
    List<Integer> list;
    int pos;
    for (int i = 0; i < l; i++) {
      tmp = reverse(nums[i]);
      // System.out.println(tmp);
      if (tmp >= Integer.MAX_VALUE)
        continue;
      list = map.getOrDefault((int) tmp, null);
      if (list == null)
        continue;
      pos = Collections.binarySearch(list, i + 1);
      if (pos >= 0)
        return 1;
      pos = -pos - 1;
      if (pos >= list.size())
        continue;
      ans = Math.min(ans, list.get(pos) - i);
    }
    return ans == l + 1 ? -1 : ans;
  }

  static public long reverse(int n) {
    long ans = 0;
    while (n != 0) {
      ans = n % 10 + ans * 10l;
      n /= 10;
    }
    return ans;
  }

  public static void main(String[] args) {
    int[] nums = { 21, 21, 120 };
    System.out.println(minMirrorPairDistance(nums));
  }
}
