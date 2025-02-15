import java.util.List;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Set;
import java.util.HashSet;
import java.util.Collections;

class lc164{
  
  private static int maximumGap(int[] nums) {
    int l = nums.length;
    if (l < 2) return 0;
    Set<Integer> set = new HashSet<>();
    for (int n : nums)
      set.add(n);
    int low = Collections.min(set);
    int high = Collections.max(set);
    if (set.size() <= 2)
      return high - low;
    int gap = (high - low) / (l-1);
    List<List<Integer>> bucket = new ArrayList<>(l+1);
    for (int i =0, n=l+1;i<n;i++)
      bucket.add(new ArrayList<>());
    int tmp;
    for (int s :set){
      tmp = (s-low)/gap;
      bucket.get(tmp).add(s);
    }
    int[][] map = new int[l+1][2];
    for (int[] m : map)
      Arrays.fill(m, -1);
    for (int i=0, n=l+1;i<n;i++){
      if (bucket.get(i).isEmpty())
        continue;
      map[i][0] = Collections.min(bucket.get(i));
      map[i][1] = Collections.max(bucket.get(i));
    }
    
    return 0;
  }

  public static void main(String[] args){
    int[] nums = {2,4,3,6,9,1};
    System.out.println(maximumGap(nums));
  }
}
