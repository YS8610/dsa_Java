import java.util.HashMap;
import java.util.Map;

public class lc1590 {
  static public int minSubarray(int[] nums, int p) {
    int l = nums.length;
    int ans = l;
    Map<Integer, Integer> map = new HashMap<>();
    map.put(0, 0);
    int sum = 0;
    for (int n : nums)
      sum = (sum + n) % p;
    int remainder = sum % p;
    if (remainder == 0)
      return 0;
    sum = 0;
    for (int i = 0, r = 0, x = 0; i <= l; i++) {
      sum = sum + (i == 0 ? 0 : nums[i - 1]);
      r = sum % p;
      x = (r - remainder + p) % p;
      if (map.containsKey(x))
        ans = Math.min(ans, i - map.get(x));
      map.put(r, i);
    }
    return ans == l ? -1 : ans;
  }

  public static void main(String[] args) {
    int[] nums = { 1000000000, 1000000000, 1000000000 };
    int p = 3;
    System.out.println(minSubarray(nums, p));
  }
}
