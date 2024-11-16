import java.util.Arrays;
import java.util.HashSet;
import java.util.Set;

public class lc3301 {
  private static long maximumTotalSum(int[] maximumHeight) {
    Arrays.sort(maximumHeight);
    long ans = 0;
    int prev = maximumHeight[maximumHeight.length-1];
    Set<Integer> set = new HashSet<>();
    for (int i=maximumHeight.length-1; i>= 0; i--){
      if (!set.contains(maximumHeight[i])){
        set.add(maximumHeight[i]);
        ans += maximumHeight[i];
        prev = maximumHeight[i];
        continue;
      }
      prev = Math.min(prev - 1, maximumHeight[i]);
      if (prev <= 0 ) return -1;
      set.add(prev);
      ans+=prev;
    }
    return ans;
  }

  public static void main(String[] args) {
    int[] maximumHeight = {3,3,80,80,100};
    System.out.println(maximumTotalSum(maximumHeight));
  }
}
