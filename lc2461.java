import java.util.HashMap;
import java.util.HashSet;
import java.util.Map;
import java.util.Set;

public class lc2461 {
  private static long maximumSubarraySum(int[] nums, int k) {
    int l = nums.length;
    Set<Integer>s = new HashSet<>();
    Map<Integer, Integer> map = new HashMap<>();
    long sum=0;
    long ans = 0;
    // construct the window
    for (int j=0;j<k;j++){
      sum+=nums[j];
      if (map.containsKey(nums[j])) {
        map.put(nums[j], map.get(nums[j])+1);
        s.add(nums[j]);
        continue;
      }
      map.computeIfAbsent(nums[j], key -> 1);
    }
    if (s.size() == 0) ans = Math.max(ans, sum);
    // sliding the window
    for(int i =1, n=l-k; i<=n;i++){
      // remove key and decrement value
      int tmp = map.get(nums[i-1]);
      if (tmp ==1) map.remove(nums[i-1]);
      else map.put(nums[i-1], tmp-1);
      if (tmp == 2) s.remove(nums[i-1]);
      sum = sum - nums[i-1] + nums[i+k-1];
      // add key and increment value
      if (map.containsKey(nums[i+k-1])){
        map.put(nums[i+k-1], map.get(nums[i+k-1])+1);
        s.add(nums[i+k-1]);
        continue;
      }
      map.computeIfAbsent(nums[i+k-1], key -> 1);
      if (s.size() == 0) ans = Math.max(ans, sum);
    }
    return ans;
  }

  public static void main(String[] args) {
    int[] nums = {1,1,1,7,8,9};
    int k = 3;
    System.out.println(maximumSubarraySum(nums, k));
  }
}
