import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Random;

public class lc398 {
  int[] nums;
  Map<Integer,List<Integer>> memo;

  public lc398(int[] nums) {
    this.nums = nums;
    this.memo = new HashMap<>();
    for (int i=0, n=nums.length; i<n;i++){
      if (memo.containsKey(nums[i])) memo.get(nums[i]).add(i);
      else memo.put(nums[i], new ArrayList<>( Arrays.asList(i)));
    }
  }
  
  public int pick(int target) {
    List<Integer> results = this.memo.get(target);
    int n = results.size();
    if (n==1) return results.get(0);
    Random rand = new Random();
    int ind = rand.nextInt(n);
    return results.get(ind);
  }

  public static void main(String[] args) {
    int[] tst = {1,2,3,3,3};
    int[] testcase = {3,1,3};
    lc398 sol = new lc398(tst);
    for (int i:testcase){
      System.out.println( sol.pick(i)); 
    }
    
  }
}
