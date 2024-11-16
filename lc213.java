import java.util.HashMap;
import java.util.Map;

public class lc213 {
  private static int dfs(int[] nums, int end, int i, Map<Integer,Integer> memo){
    if (i >= end) return 0;
    if (memo.containsKey(i)) return memo.get(i);
    int res = Math.max(dfs(nums, end, i+1, memo), dfs(nums, end, i+2, memo)+nums[i]);
    memo.put(i, res);
    return res;
  }

  private static int rob(int[] nums) {
    if (nums.length==1) return nums[0];
    int rob1st = dfs(nums, nums.length-1, 0, new HashMap<>()) ;
    int rob2nd = dfs(nums, nums.length, 1, new HashMap<>());
    return Math.max(rob1st, rob2nd);
    }
  
  public static void main(String[] args) {
    int[] nums = {1,2,3,1,7,3,5};
    System.out.println( rob(nums));
  }
}
