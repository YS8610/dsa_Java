import java.util.ArrayList;
import java.util.List;

public class lc2095 {

  private static ListNode deleteMiddle(ListNode head) {
    List<ListNode> l = new ArrayList<>();
    ListNode cp = head;
    while (cp != null) {
      l.add(cp);
      cp = cp.next;
    }
    int len = l.size();
    if (len == 1) return null;
    if (len == 2) {
      head.next = null;
      return head;
    }
    cp = l.get(len / 2);
    ListNode np = cp.next;
    cp.next = null;
    l.get(len / 2 - 1).next = np;
    return head;
  }

  public static void main(String[] args) {
    ListNode head = ListNode.populate(new int[] { 1, 3, 4, 7, 1, 2, 6 });
    deleteMiddle(head);
    ListNode.stringify(head);
  }
}
