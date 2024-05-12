import java.util.HashMap;
import java.util.Map;

public class lc169 {
  private static int majorityElement(int[] nums){
    Map<Integer,Integer> map = new HashMap<>();
    int n = nums.length;
    if (n==1) return nums[0];
    
    for (int a :nums){
      if (map.containsKey(a)){
        int count = map.get(a)+1;
        if (count>n/2) return a;
        map.put(a, count);
      } 
      else map.put(a, 1);
    }
    return 0;
  }
  public static void main(String[] args) {
    int[] nums = {2,2,1,1,1,2,2};
    System.out.println( majorityElement(nums) );
  }
}
