import java.util.ArrayDeque;
import java.util.Deque;

public class lc84 {
  static public int largestRectangleArea(int[] heights) {
    Deque<int[]> stack = new ArrayDeque<>();
    Deque<int[]> s2 = new ArrayDeque<>();
    int ans = 0;
    int l = heights.length;
    int len;
    for (int i = 0; i < l; i++) {
      ans = Math.max(ans, heights[i]);
      if (stack.isEmpty()) {
        stack.add(new int[] { heights[i], i });
        continue;
      }
      while (!stack.isEmpty() && stack.peekLast()[0] > heights[i])
        s2.add(stack.pollLast());
      if (heights[i] != 0)
        stack.add(new int[] { heights[i], s2.isEmpty() ? i : s2.peekLast()[1] });
      while (!s2.isEmpty()) {
        len = i - s2.peekLast()[1];
        ans = Math.max(ans, len * s2.peekLast()[0]);
        s2.pollLast();
      }
    }
    while (!stack.isEmpty()) {
      len = l - stack.peekFirst()[1];
      ans = Math.max(ans, len * stack.peekFirst()[0]);
      stack.pollFirst();
    }
    return ans;
  }

  public static void main(String[] args) {
    int[] heights = { 5, 2, 7, 6 };
    System.out.println(largestRectangleArea(heights));
  }
}
