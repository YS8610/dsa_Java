import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class lc229 {
  
  private static List<Integer> majorityElement(int[] nums){
    int len = nums.length;
    Map<Integer,Integer> memo = new HashMap<>();
    for(int num:nums){
      if (memo.containsKey(num)){
        memo.put(num, Integer.valueOf(memo.get(num))+1 );
      } 
      else{
        memo.put(num, 1);
      }
    }
    List<Integer> ans = new ArrayList<>();
    memo.forEach((k,v) -> {
      if (v>len/3) ans.add(k);
    } );
    return ans;
  }
  public static void main(String[] args) {
    int[] nums = {1,2};
    System.out.println( majorityElement(nums));
  }
}
