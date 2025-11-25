import java.util.List;
import java.util.TreeSet;

public class lc3318 {
  public int[] findXSum(int[] nums, int k, int x) {
    int l = nums.length;
    int[] ans = new int[Math.max(1, l - k + 1)];
    for (int i = 0, n = l - k + 1; i < n; i++)
      ans[i] = count(nums, i, k, x);
    return ans;
  }

  public int count(int[] nums, int pos, int k, int x) {
    TreeSet<List<Integer>> set = new TreeSet<>((m1, m2) -> {
      if (m2.get(0) == m1.get(0))
        return Integer.compare(m2.get(1), m1.get(1));
      return Integer.compare(m2.get(0), m1.get(0));
    });
    int[] map = new int[51];
    int count = 0;
    int ans = 0;
    for (int i = pos, n = pos + k; i < n; i++)
      map[nums[i]]++;
    for (int i = 0; i < 51; i++) {
      if (map[i] == 0)
        continue;
      set.add(List.of(map[i], i));
    }
    for (List<Integer> s : set) {
      ans += s.get(0) * s.get(1);
      count++;
      if (count >= x)
        break;
    }
    return ans;
  }
}
