import java.util.ArrayDeque;
import java.util.Deque;

public class lc206 {
  private static ListNode reverseList(ListNode head) {
    Deque<ListNode> stack = new ArrayDeque<>();
    ListNode current = head;
    while(current !=null){ 
      stack.push(current);
      current = current.next;
    }
    if (stack.isEmpty()) return null;
    ListNode tail = stack.pop();
    ListNode cur = tail;
    while(!stack.isEmpty()){
      cur.next = stack.pop();
      cur = cur.next;
    }
    cur.next = null;
    return tail;
  }
  public static void main(String[] args) {
    ListNode a = new ListNode(1);
    ListNode b = new ListNode(2);
    ListNode c = new ListNode(3);
    ListNode d = new ListNode(4);
    a.next = b;
    b.next = c;
    c.next = d;

    reverseList(a);
  }
}
