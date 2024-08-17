import java.util.PriorityQueue;

public class lc1508 {
  private static int rangeSum(int[] nums, int n, int left, int right) {
    PriorityQueue<Integer> pq = new PriorityQueue<>();
    int l = nums.length;
    int mod = (int)Math.pow(10, 9) + 7;
    int[] map = new int[l];
    map[0] = nums[0];
    for (int i=1;i<l;i++){
      map[i] = map[i-1] + nums[i];
    }
    for (int i =0; i<l;i++){
      for (int j =i; j<l;j++){
        if (i==j){
          pq.add(nums[i]);
          continue;
        }
        if (i == 0){
          pq.add(map[j]);
          continue;
        }
        pq.add(map[j] - map[i-1]);
      }
    }
    int ll = left - 1;
    int ans = 0;
    for (int i = 0; i<right;i++){
      if (i < ll){
        pq.poll();
        continue;
      }
      ans = (ans + pq.poll())%mod;
    }
    return ans;
  }

  public static void main(String[] args) {
    int[] nums = {1,2,3,4}; 
    int n = 4, left = 1, right = 5;
    System.out.println(rangeSum(nums, n, left, right));
  }
}
