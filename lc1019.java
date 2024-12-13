import java.util.ArrayDeque;
import java.util.Deque;

public class lc1019 {

  public int[] nextLargerNodes(ListNode head) {
    int i = 0;
    ListNode cp = head;
    Deque<int[]> s = new ArrayDeque<>();
    while (cp != null && ++i >= 0) cp = cp.next;
    int[] ans = new int[i];
    cp = head;
    i = 0;
    int[] tmp;
    while (cp != null) {
      while (!s.isEmpty() && s.peekLast()[0] < cp.val) {
        tmp = s.removeLast();
        ans[tmp[1]] = cp.val;
      }
      s.addLast(new int[] { cp.val, i });
      i++;
      cp = cp.next;
    }
    return ans;
  }
}
