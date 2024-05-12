import java.util.Arrays;
import java.util.PriorityQueue;
import java.util.Queue;

public class lc41 {
  
  private static int firstMissingPositive(int[] nums) {
    Queue<Integer> q = new PriorityQueue<>();
    for (int num:nums){ 
      if (num>0) q.offer(num);
    }
    if (q.isEmpty()) return 1;
    // do first iteration
    int e = q.peek();
    if (e>1) return 1;
    while(!q.isEmpty()){
      e = q.poll();
      if (!q.isEmpty()){
        int e1 = q.peek();
        if (e1-e>1) return e+1;
      } 
      else return e+1;
    }
    return e+1;
  }

  private static int firstMissingPositive1(int[] nums) {
    int len = nums.length;
    // all -ve num turn to zero
    for (int i =0;i<len;i++) nums[i] = nums[i]<0?0:nums[i];
    // -ve num and -(len) num refer to smallest +ve present
    for (int i =0;i<len;i++){
      if (nums[i]>= 1 && nums[i] <= len ){
        if (nums[nums[i]-1] > 0 ) nums[nums[i]-1] *= nums[nums[i]-1]>=0?-1:1;
        // -ve num change from 0 to -len-1 if possible small num found
        else if (nums[nums[i]-1] == 0) nums[nums[i]-1] = -len-1;
      }
      // change the nums[i] is changed to -ve
      else if (nums[i] < 0 && nums[i] >= -len){
        if (nums[-nums[i]-1]!=0) nums[-nums[i]-1] *=nums[-nums[i]-1]>=0?-1:1;
        else nums[-nums[i]-1] = -len-1;
      }
    }
    // System.out.println(Arrays.toString(nums));
    for (int i=0;i<len;i++){
      if (nums[i]>=0) return i+1;
    }
    return len+1;
  }

  public static void main(String[] args) {
    int[] nums = {2,2,4,0,1,3,3,3,4,3};
    // System.out.println( firstMissingPositive(nums) );
    System.out.println( firstMissingPositive1(nums) );
  }
}
