import java.util.HashSet;
import java.util.Set;

public class lc2799 {
  private static int countCompleteSubarrays(int[] nums) {
    int l = nums.length;
    Set<Integer> set = new HashSet<>();
    for (int n : nums)
      set.add(n);
    int m = set.size();
    int ans = 0;

    for (int i = 0; i < l && l-1-i>=m; i++) {
      set.clear();
      for (int j = i; j < l; j++) {
        set.add(nums[j]);
        if (set.size() == m)
          ans++;
        if (set.size() > m)
          break;
      }
    }
    return ans;
  }

  public static void main(String argv[]){
    int[] nums = {1,3,1,2,2};
    System.out.println(countCompleteSubarrays(nums));
  }
}
