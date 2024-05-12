import java.util.Arrays;
import java.util.HashSet;
import java.util.PriorityQueue;
import java.util.Queue;
import java.util.Set;

public class lc128 {
  private static int longestConsecutive(int[] nums){
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
    int[] nums = {-6,-1,-1,9,-8,-6,-6,4,4,-3,-8,-1};
    System.out.println( longestConsecutive(nums) );
  }
}
