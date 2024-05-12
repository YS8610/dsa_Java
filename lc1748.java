import java.util.HashMap;
import java.util.Map;

public class lc1748 {
  private static int sumOfUnique(int[] nums){
    Map<Integer,Integer> map = new HashMap<>();
    for (int num:nums){
      if (map.containsKey(num)) map.put(num, map.get(num)+1);
      else map.put(num,1);
    }
    int ans = 0;
    for (int key : map.keySet()){
      if (map.get(key) ==1 ) ans +=key;
    }
    return ans;
  }
  public static void main(String[] args) {
    int[] nums = {1,2,3,4,5};
    System.out.println( sumOfUnique(nums) );
  }
}
