import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class lc1865 {
  Map<Integer, Integer> m1;
  Map<Integer, Integer> m2;
  int[] n2;

  public lc1865(int[] nums1, int[] nums2) {
        m1 = new HashMap<>();
        m2 = new HashMap<>();
        for (int n : nums1){
            m1.computeIfPresent(n, (k,v) -> v+1);
            m1.computeIfAbsent(n, (k) -> 1);
        }
        for (int n: nums2){
            m2.computeIfPresent(n, (k,v) -> v+1);
            m2.computeIfAbsent(n, (k) -> 1);
        }
        n2 = Arrays.copyOf(nums2, nums2.length);  
    }

  public void add(int index, int val) {
    int tmp = n2[index];
    m2.computeIfPresent(tmp, (k, v) -> v - 1);
    m2.remove(tmp, 0);
    m2.computeIfPresent(tmp + val, (k, v) -> v + 1);
    m2.computeIfAbsent(tmp + val, (k) -> 1);
    n2[index] += val;
  }

  public int count(int tot) {
    int ans = 0;
    int tmp;
    for (Map.Entry<Integer, Integer> entry : m1.entrySet()) {
      tmp = tot - (int) entry.getKey();
      if (tmp <= 0)
        continue;
      ans += (int) entry.getValue() * m2.getOrDefault(tmp, 0);
    }
    return ans;
  }
}
