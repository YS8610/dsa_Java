import java.util.HashMap;
import java.util.Map;

public class lc137 {
  private static int singleNumber(int[] nums){
    Map<Integer,Integer> map = new HashMap<>();
    for (int num: nums){
      if (map.containsKey(num)) map.put(num, Integer.valueOf( map.get(num))+1);
      else map.put(num,1);
    }
    for (int i : map.keySet()){
      if (map.get(i) == 1) return i;
    }
    return 0;
  }

  public static void main(String[] args) {
    int[] nums = {0,1,0,1,0,1,99};
    System.out.println( singleNumber(nums));
  }
}
