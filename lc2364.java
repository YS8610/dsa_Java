import java.util.Map;
import java.util.HashMap;

class lc2364{

  private static long countBadPairs(int[] nums) {
    int l = nums.length;
    Map<Integer, Integer> map = new HashMap<>();
    int tmp;
    long total = 0;
    for (int i =0; i<l;i++){
      tmp = nums[i] - i;
      map.computeIfPresent(tmp, (k,v) -> v+1);
      map.computeIfAbsent(tmp, (k) -> 1);
      total += i;
    }
    for (Map.Entry<Integer, Integer> entry:map.entrySet())
      for (int i=0, n=entry.getValue();i<n;i++)
        total -= i;
    return total;    
  }

  public static void main(String[] args){
    int[] nums = {4,1,3,3};
    System.out.println(countBadPairs(nums));
  }
}
