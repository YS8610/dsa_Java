import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class lc2610 {

  private static List<List<Integer>> findMatrix(int[] nums) {
    Map<Integer, Integer> map = new HashMap<>();
    int temp = 0;
    for (int i = 0, n = nums.length; i < n; i++) {
      if (map.containsKey(nums[i])) map.put(
        nums[i],
        map.get(nums[i]) + 1
      ); else map.put(nums[i], 1);
    }
    List<List<Integer>> ans = new ArrayList<>();
    for (int k : map.keySet()) {
      if (ans.size() >= map.get(k)) {
        for (int i = 0, n = map.get(k); i < n; i++) ans.get(i).add(k);
      } else {
        temp = map.get(k) - ans.size();
        for (int i = 0, n = ans.size(); i < n; i++) ans.get(i).add(k);
        for (int i = 0; i < temp; i++) {
          ans.add(new ArrayList<>(List.of(k)));
        }
      }
    }
    return ans;
  }

  public static void main(String[] args) {
    int[] nums = {1,3,4,1,2,3,1};
    System.out.println( findMatrix(nums).toString() );
  }
}
