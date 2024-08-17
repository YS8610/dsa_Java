import java.util.Collections;
import java.util.PriorityQueue;

public class lc703 {

  PriorityQueue<Integer> pq;
  int no;

  public lc703(int k, int[] nums) {
    this.pq = new PriorityQueue<>();
    this.no = k;
    for (int n : nums) pq.add(n);
    while (this.pq.size() > k) this.pq.poll();
  }

  public int add(int val) {
    if (
      !pq.isEmpty() && this.pq.size() >= this.no && this.pq.peek() > val
    ) return this.pq.peek();
    pq.add(val);
    while (this.pq.size() > this.no) this.pq.poll();
    return this.pq.peek();
  }

  public static void main(String[] args) {
    lc703 kthLargest = new lc703(2, new int[] { 0 });
    System.out.println(kthLargest.add(-1)); // return 4
    System.out.println(kthLargest.add(1)); // return 5
    System.out.println(kthLargest.add(-2)); // return 5
    System.out.println(kthLargest.add(-4)); // return 8
    System.out.println(kthLargest.add(3)); // return 8
  }
}
