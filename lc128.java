import java.util.Arrays;
import java.util.HashSet;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.Set;

public class lc128 {
  private static int longestConsecutive(int[] nums){
    Set<Integer> set = new HashSet<>();
    for (int num:nums) set.add(num);
    int tans = 0;
    int ans = 0;
    int tmp;
    for (int n :set){
      if (set.contains(n-1)) continue;
      tans = 1;
      tmp = n;
      while (set.contains(tmp+1)){
        tans++;
        tmp++;
      }
      ans = Math.max(ans, tans);
    }
    return ans;
  }
  
  private static int longestConsecutive1(int[] nums){
    Set<Integer> set = new HashSet<>(Arrays.stream(nums).boxed().toList() );
    Queue<Integer> q = new PriorityQueue<>(set );
    int counter = 0;
    int highest = 0;
    if (set.size()==0) return 0;
    if (set.size()==1) return 1;
    while(!q.isEmpty()){
      int cp = q.poll();
      if(!q.isEmpty()){
        int np = q.peek();
        if (np-cp==1) counter++;
        else {
          counter =0;
        }
        highest = highest>=counter?highest:counter;
      }
    }
    return highest>0?highest+1:1;
  }

  public static void main(String[] args) {
    int[] nums = {100,4,200,1,3,2};
    System.out.println( longestConsecutive(nums) );
    System.out.println( longestConsecutive1(nums) );
  }
}
