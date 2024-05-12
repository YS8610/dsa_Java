import java.util.HashMap;
import java.util.Map;

public class lc1679 {

  private static int maxOperations(int[] nums, int k) {
    if (nums.length == 1) return 0;
    Map<Integer, Integer> map = new HashMap<>();
    int ans = 0;
    int diff;
    for (int num : nums) {
      if (map.containsKey(num)) map.put(num, map.get(num) + 1); 
      else map.put( num,1 );
    }
    for (int key : map.keySet()) {
      diff = k - key;
      if (diff == key) {
        while (map.get(key) >= 2) {
          ans++;
          map.put(key, map.get(key) - 2);
        }
      } else if (diff != key && map.containsKey(diff)) {
        while (map.get(key) >= 1 && map.get(diff) >= 1) {
          ans++;
          map.put(key, map.get(key) - 1);
          map.put(diff, map.get(diff) - 1);
        }
      }
    }
    return ans;
  }

  public static void main(String[] args) {
    int[] nums = { 1, 2, 3, 4 };
    int k = 5;
    System.out.println(maxOperations(nums, k));
  }
}
