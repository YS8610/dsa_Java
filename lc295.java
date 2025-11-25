import java.util.Collections;
import java.util.PriorityQueue;

public class lc295 {
  PriorityQueue<Integer> small;
  PriorityQueue<Integer> big;
  boolean even;

  public lc295() {
    this.big = new PriorityQueue<>();
    this.small = new PriorityQueue<>(Collections.reverseOrder());
    this.even = true;
  }

  public void addNum(int num) {
    if (even) {
      this.big.add(num);
      this.small.add(this.big.poll());
    } else {
      this.small.add(num);
      this.big.add(this.small.poll());
    }
    even = !even;
  }

  public double findMedian() {
    int no = this.big.size() + this.small.size();
    if (no % 2 == 0)
      return (this.small.peek() + (double) this.big.peek()) / 2;
    else
      return this.small.size() > this.big.size() ? this.small.peek() : this.big.peek();
  }
}
