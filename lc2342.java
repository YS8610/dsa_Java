import java.util.Map;
import java.util.Comparator;
import java.util.HashMap;
import java.util.PriorityQueue;

class lc2342{
  
  private static int maximumSum(int[] nums) {
    int l = nums.length;
    Map<Integer, PriorityQueue<Integer>> map = new HashMap<>();
    int tmp;
    for (int n : nums){
      tmp = digitsum(n);
      if (map.containsKey(tmp))
        map.get(tmp).add(n);
      else{
        PriorityQueue<Integer> pq = new PriorityQueue<>(Comparator.reverseOrder());
        pq.add(n);
        map.put(tmp, pq);
      }
    }
    tmp = -1;
    for (Map.Entry<Integer, PriorityQueue<Integer>>entry:map.entrySet()){
      if (entry.getValue().size() < 2) 
        continue;
      tmp = Math.max(entry.getValue().poll() + entry.getValue().poll(), tmp);
    }
    return tmp;
  }

  private static int digitsum(int n){
    int ans = 0;
    while (n != 0){
      ans += n%10;
      n /= 10;
    }
    return ans;
  }

  public static void main(String[] args){
    int[] nums = new int[]{229,398,269,317,420,464,491,218,439,153,482,169,411,93,147,50,347,210,251,366,401};
    System.out.println(maximumSum(nums));
  }
  
}
