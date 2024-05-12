import java.util.HashMap;
import java.util.Map;

public class lc287 {
  private static int findDuplicate(int[] nums){
    Map<Integer,Integer> map = new HashMap<>();
    for (int num:nums){
      if (map.containsKey(num)) {
        // map.put(num, Integer.valueOf(map.get(num)+1));
        return num;
      }
      else map.put(num,1);
    }
    return 0;
  }

  private static int findDuplicate1(int[] nums){
    int len = nums.length;
    int sum = 0;
    int correctsum = 0;
    int diff;
    for (int i :nums) sum += i;
    for (int i=1; i<len;i++) correctsum += i;
    diff = sum - correctsum;

  }


  public static void main(String[] args) {
    int[] nums = {3,1,3,4,2};
    System.out.println( findDuplicate(nums));
  }
}
