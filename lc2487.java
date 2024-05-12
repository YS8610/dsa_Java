import java.util.ArrayDeque;
import java.util.Deque;

public class lc2487 {
  private static ListNode removeNodes(ListNode head) {
    Deque<ListNode> stack = new ArrayDeque<>();
    ListNode cp;
    ListNode ans;
    cp = head;
    while (cp != null){
      if (stack.isEmpty()) {
        stack.add(cp);
        cp = cp.next;
        continue;
      }
      while (!stack.isEmpty() && stack.peekLast().val < cp.val){
        stack.removeLast();
      }
      stack.add(cp);
      cp = cp.next;
    }
    ans = stack.pollFirst();
    cp = ans;
    while (!stack.isEmpty()){
      cp.next = stack.removeFirst();
      cp = cp.next;
    }
    return ans;
  }

  private static ListNode removeNodes1(ListNode head) {
    Deque<ListNode> stack = new ArrayDeque<>();
    ListNode cp;
    ListNode ans;
    cp = head;
    while (cp != null){
      if (stack.isEmpty()) {
        stack.add(cp);
        cp = cp.next;
        continue;
      }
      while (!stack.isEmpty() && stack.peekLast().val < cp.val){
        stack.removeLast();
      }
      if (!stack.isEmpty()) stack.peekLast().next = cp;
      stack.add(cp);
      cp = cp.next;
    }
    ans = stack.pollFirst();
    return ans;
  }

  public static void main(String[] args) {
    ListNode head = ListNode.populate(new int[]{5});
    ListNode ans = removeNodes1(head);
    ListNode head1 = ListNode.populate(new int[]{5});
    ListNode ans1 = removeNodes(head1);
    ListNode.stringify(ans);
    ListNode.stringify(ans1);

  }
}
