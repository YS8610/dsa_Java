import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.TreeSet;

public class lc3321 {
  static public long[] findXSumHard(int[] nums, int k, int x) {
    int l = nums.length;
    TreeSet<int[]> topSet = new TreeSet<>((m1, m2) -> {
      if (m1[1] == m2[1])
        return Integer.compare(m1[0], m2[0]);
      return Integer.compare(m1[1], m2[1]);
    });
    TreeSet<int[]> remainSet = new TreeSet<>((m1, m2) -> {
      if (m2[1] == m1[1])
        return Integer.compare(m2[0], m1[0]);
      return Integer.compare(m2[1], m1[1]);
    });
    Map<Integer, Integer> map = new HashMap<>();
    long[] ans = new long[l - k + 1];
    int[] top, rm, ad;
    long sum = 0;
    // start new window
    for (int i = 0; i < k; i++)
      map.put(nums[i], map.getOrDefault(nums[i], 0) + 1);
    for (Map.Entry<Integer, Integer> entry : map.entrySet()) {
      sum += 1l * entry.getValue() * entry.getKey();
      topSet.add(new int[] { entry.getKey(), entry.getValue() });
    }
    while (topSet.size() > x) {
      top = topSet.first();
      topSet.remove(top);
      remainSet.add(top);
      sum -= 1l * top[0] * top[1];
    }
    ans[0] = sum;
    // sliding window
    for (int i = 1, n = l - k + 1; i < n; i++) {
      // removing number
      rm = new int[] { nums[i - 1], map.get(nums[i - 1]) };
      map.put(nums[i - 1], map.get(nums[i - 1]) - 1);
      if (remainSet.contains(rm)) {
        remainSet.remove(rm);
        if (rm[1] > 1)
          remainSet.add(new int[] { nums[i - 1], map.get(nums[i - 1]) });
        else
          map.remove(nums[i - 1]);
      } else {
        topSet.remove(rm);
        sum -= nums[i - 1];
        if (rm[1] > 1)
          topSet.add(new int[] { nums[i - 1], map.get(nums[i - 1]) });
        else
          map.remove(nums[i - 1]);
      }
      // adding number
      // number not in top or remain set
      if (!map.containsKey(nums[i + k - 1])) {
        map.put(nums[i + k - 1], 1);
        ad = new int[] { nums[i + k - 1], 1 };
        remainSet.add(ad);
      }
      // number should be top or remain set
      else {
        ad = new int[] { nums[i + k - 1], map.get(nums[i + k - 1]) };
        map.put(nums[i + k - 1], map.get(nums[i + k - 1]) + 1);
        if (topSet.contains(ad)) {
          topSet.remove(ad);
          topSet.add(new int[] { nums[i + k - 1], map.get(nums[i + k - 1]) });
          sum += nums[i + k - 1];
        } else {
          remainSet.remove(ad);
          remainSet.add(new int[] { nums[i + k - 1], map.get(nums[i + k - 1]) });
        }
      }
      // promotion
      if (!remainSet.isEmpty()) {
        if (topSet.size() < x) {
          top = remainSet.first();
          remainSet.remove(top);
          topSet.add(top);
          sum += top[0] * top[1] * 1l;
        } else if (topSet.first()[1] < remainSet.first()[1] ||
            (topSet.first()[1] == remainSet.first()[1] &&
                topSet.first()[0] < remainSet.first()[0])) {
          top = topSet.first();
          rm = remainSet.first();
          topSet.remove(top);
          remainSet.remove(rm);
          sum -= 1l * top[0] * top[1];
          topSet.add(rm);
          remainSet.add(top);
          sum += 1l * rm[0] * rm[1];
        }
      }
      ans[i] = sum;
    }
    return ans;
  }

  public static void main(String[] args) {
    int[] nums = { 1000000000, 1000000000, 1000000000, 1000000000, 1000000000, 1000000000 };
    int k = 6, x = 1;
    System.out.println(Arrays.toString(findXSumHard(nums, k, x)));
  }
}
