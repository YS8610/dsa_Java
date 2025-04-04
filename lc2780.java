import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.ArrayList;
import java.util.Map;

public class lc2780 {
  static public int minimumIndex(List<Integer> nums) {
    int l = nums.size();
    Map<Integer, Integer> map = new HashMap<>();
    for (int n : nums) {
      map.computeIfPresent(n, (k, v) -> v + 1);
      map.computeIfAbsent(n, k -> 1);
    }
    int count = 0;
    int tmp = nums.get(0);
    for (Map.Entry<Integer, Integer> entry : map.entrySet()) {
      if (entry.getValue() > count) {
        count = entry.getValue();
        tmp = entry.getKey();
      }
    }
    if (count < l/2+1)
      return -1;
    int tmpcount = 0;
    int fh, sh;
    for (int i = 0; i < l; i++) {
      tmpcount += nums.get(i) == tmp ? 1 : 0;
      fh = i + 1;
      sh = l - i - 1;
      if (fh / 2 + 1 <= tmpcount && sh / 2 + 1 <= count - tmpcount)
        return i;
    }
    return -1;
  }

  public static void main(String[] args) {
    List<Integer> nums = new ArrayList<>(Arrays.asList(1, 2, 2, 2));
    System.out.println(minimumIndex(nums));
  }
}
