import java.util.Collections;
import java.util.PriorityQueue;
import java.util.Queue;

public class lc215 {
  private static int findKthLargest(int[] nums, int k){
    Queue<Integer> q = new PriorityQueue<>(Collections.reverseOrder());
    for( int num:nums) q.offer(num);
    int ans=0;
    for (int i =0; i<k;i++) ans = q.poll();
    return ans;
  }

  public static void main(String[] args) {
    int[] nums = {3,2,3,1,2,4,5,5,6};
    int k = 4;

    System.out.println( findKthLargest(nums, k) );
  }
}
