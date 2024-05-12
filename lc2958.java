import java.util.HashMap;
import java.util.Map;

public class lc2958 {
  private static int maxSubarrayLength(int[] nums, int k) {
    Map<Integer,Integer> map = new HashMap<>();
    int lp = 0, rp = 0;
    int len = nums.length;
    if (len == 1) return 1;
    int ans=0;
    while (lp <len){
      while(rp <len){
        if (lp==len-1) return ans;
        if (lp !=0 && rp == lp && lp <len -1) {
          map.put(nums[lp],1);
          rp++;
        }
        if (map.containsKey(nums[rp])) {
          if (map.get(nums[rp]) >= k ) break;
          map.put(nums[rp], map.get(nums[rp])+1);
        }
        else map.put(nums[rp], 1);
        rp++;
      }
      rp--;
      ans = Math.max(ans, rp - lp + 1);
      lp++;
      if (lp>0) map.put(nums[lp-1], map.get(nums[lp-1])-1);
      rp++;
    }
    return ans;
  }

  public static void main(String[] args) {
    int[] nums = {2,2,1,2};
    // int[] nums = {1,2,3,1,2,3,1,2};
    int k = 1;
    System.out.println(maxSubarrayLength(nums, k));
  }
}
