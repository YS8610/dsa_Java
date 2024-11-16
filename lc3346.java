import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
import java.util.Map.Entry;

public class lc3346 {
  private static int maxFrequency(int[] nums, int k, int numOperations){
    Map<Integer,Integer> map = new HashMap<>();
    for (int n:nums){
      map.computeIfPresent(n, (key,val) -> val+1);
      map.computeIfAbsent(n, key -> 1 );
    }
    int[] set = new int[map.size()];
    int tmp=-1;
    for (Entry<Integer, Integer> entry : map.entrySet())
      set[++tmp] = entry.getKey();
    Arrays.sort(set);
    int copy = numOperations;
    for (int i=0, n=set.length; i<n;i++){
      numOperations = copy;
      tmp = Arrays.binarySearch(set, set[i]+k);
      if (tmp >= 0){
        if (Math.min(tmp-i, numOperations) > 0)
          map.put(set[i], map.get(set[i]) + Math.min(tmp-i, numOperations));
          numOperations -= Math.min(tmp-i, numOperations);
        }
        else{
          if (Math.min((-tmp-1)-1-i, numOperations) > 0)
          map.put(set[i], map.get(set[i]) + Math.min((-tmp-1)-1-i, numOperations));
          numOperations -= Math.min((-tmp-1)-1-i, numOperations);
      }
      if (numOperations == 0) continue;
      tmp = Arrays.binarySearch(set, set[i]-k);
      if (tmp >= 0){
        if (Math.min(i-tmp, numOperations) > 0)
        map.put(set[i], map.get(set[i]) + Math.min(i-tmp, numOperations));
      }
      else{
        if (Math.min(i-(-tmp-1), numOperations) > 0)
          map.put(set[i], map.get(set[i]) + Math.min(i-(-tmp-1), numOperations));
      }
    }
    int ans = 0;
    for (Entry<Integer, Integer> entry : map.entrySet())
      ans = Math.max(entry.getValue(), ans);
    return ans;
  }

  public static void main(String[] args) {
    int[] nums = {1,4,4,6,8,8,10,14};
    int k = 3, numOperations = 2;
    System.out.println(maxFrequency(nums, k, numOperations));
  }
}
