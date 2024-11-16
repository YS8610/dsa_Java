import java.util.ArrayList;
import java.util.List;

public class lc19 {

  public ListNode removeNthFromEnd(ListNode head, int n) {
    ListNode fast = head;
    ListNode slow = head;
    ListNode pp = null;
    for (int i=0; i<n;i++)
      fast = fast.next;
    while (fast != null){
      fast = fast.next;
      pp = slow;
      slow = slow.next;
    }
    if (pp !=null)
      pp.next = slow.next;
    else
      head = slow.next;
    slow.next= null;
    return head;
  }

  public ListNode removeNthFromEnd1(ListNode head, int n) {
    List<ListNode> memo = new ArrayList<>(30);
    ListNode cp = head;
    while (cp != null) {
      memo.add(cp);
      cp = cp.next;
    }
    if (memo.size() == 1) return null;
    if (memo.size() == n) {
      memo.get(0).next = null;
      return memo.get(1);
    }
    ListNode pp = memo.get(memo.size() - n - 1);
    if (n == 1) {
      pp.next = null;
      return head;
    }
    cp = pp.next;
    pp.next = cp.next;
    return head;
  }
}
