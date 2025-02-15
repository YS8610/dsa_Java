import java.util.Arrays;
import java.util.List;
import java.util.ArrayList;
import java.util.Deque;
import java.util.ArrayDeque;
import java.util.Map;
import java.util.HashMap;

class lc2948{
  private static int[] lexicographicallySmallestArray(int[] nums, int limit) {
    int l = nums.length;
    int[] tmp = Arrays.copyOf(nums, l);
    Arrays.sort(tmp);
    List<Deque<Integer>> list = new ArrayList<>();
    Map<Integer, Integer> map = new HashMap<>();
    int i = 0, j = 0, k = 0;
    while (i < l){
      j = 1; 
      list.add(new ArrayDeque<>());
      list.get(k).add(tmp[i]);
      map.put(tmp[i],k);
      while (i+j <l && tmp[i+j] - tmp[i+j-1] <=limit){
        list.get(k).add(tmp[i+j]);
        map.put(tmp[i+j], k);
        j++;
      }
      i += j;
      k++;
    }
    i=0;
    for (int n : nums)
      tmp[i++] = list.get(map.get(n)).pollFirst();
    return tmp;
  }

  public static void main(String[] args){
    int[] nums = {1,5,3,9,8};
    int limit = 2;
    System.out.println(Arrays.toString(lexicographicallySmallestArray(nums, limit)));
  }
}
