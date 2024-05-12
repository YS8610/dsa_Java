import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class lc260 {
  private static int[] singleNumber(int[] nums){
    Map<Integer,Integer> map = new HashMap<>();
    for (int num:nums){
      if (map.containsKey(num)) map.put(num, Integer.valueOf(map.get(num))+1);
      else map.put(num,1);
    }
    int[] ans = new int[2];
    int counter = 0;
    for (int key : map.keySet()){
      if (map.get(key) == 1 ){
        ans[counter] = key ;
        counter++;
      }
    }
    return ans;
  }
  
  public static void main(String[] args) {
    int[] nums = {1,2,1,3,2,5};
    System.out.println( Arrays.toString(singleNumber(nums)) );
  }
}
