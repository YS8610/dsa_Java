import java.util.Arrays;
import java.util.Collections;

import java.util.PriorityQueue;
import java.util.Queue;

public class lc239 {
  
  private static int[] maxSlidingWindow(int[] nums, int k){
    int n = nums.length;
    Queue<Integer> q = new PriorityQueue<>(Collections.reverseOrder());
    for(int i=0; i<k;i++) q.offer(nums[i]);
    int[] ans = new int[n-k+1];
    ans[0] = q.peek();
    for (int lp=1; lp<n-k+1;lp++){
      q.remove(nums[lp-1] );
      q.offer(nums[lp+k-1]);
      ans[lp] = q.peek();
    }
    return ans;
  }

  public static void main(String[] args) {
    int[] nums = {1,3,-1,-3,5,3,6,7};
    int k = 3;
    System.out.println( Arrays.toString(maxSlidingWindow(nums, k)) );
  }
}
