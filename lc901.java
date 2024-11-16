import java.util.ArrayDeque;
import java.util.Deque;

public class lc901 {

  Deque<int[]> stack;

  public lc901() {
    this.stack = new ArrayDeque<>();
  }

  public int next(int price) {
    if (this.stack.isEmpty()) {
      stack.add(new int[] { price, 1 });
      return 1;
    }
    int[] px = new int[] { price, 1 };
    while (!stack.isEmpty() && stack.peekLast()[0] <= price) {
      px[1] += stack.pollLast()[1];
    }
    stack.add(px);
    return px[1];
  }
}
