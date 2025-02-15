import java.util.PriorityQueue;

class lc3066{

  private static int minOperations(int[] nums, int k) {
    PriorityQueue<Long> pq = new PriorityQueue<>();
    for (int n : nums)
      pq.add((long)n);
    if (pq.peek() >= k)
      return 0;
    int ans = 0;
    long tmp1, tmp2;
    while (pq.size() >= 2){
      tmp1 = pq.poll();
      tmp2 = pq.poll();
      pq.add(Math.min(tmp1, tmp2) * 2 + Math.max(tmp1, tmp2));
      ans++;
      if (pq.peek() >= k)
        break;
    }
    return ans;
  }

  public static void main(String[] args){
    int[] nums = {1,1,2,4,9};
    int k = 10;
    System.out.println(minOperations(nums, k));
  }

}

