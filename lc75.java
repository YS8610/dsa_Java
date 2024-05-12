import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;

public class lc75 {
  private static void sortColors(int[] nums){
    Map<Integer,Integer> map = new HashMap<>();
    for (int i=0; i<3;i++) map.put(i,0);
    for (int num:nums){
      map.put(num, map.get(num)+1 );
    }
    int count0 = map.get(0);
    int count1 = map.get(1);
    int count2 = map.get(2);
    for (int i=0, n = count0;i<n;i++) nums[i] = 0;
    for (int i=count0, n = count0+count1 ; i<n;i++) nums[i] = 1;
    for (int i=count0+count1, n = count0+count1+count2 ; i<n;i++) nums[i] = 2;

  }

  public static void main(String[] args) {
    int[] nums = {2,2,1,1};
    sortColors(nums);
    System.out.println( Arrays.toString(nums) );
  }
}
