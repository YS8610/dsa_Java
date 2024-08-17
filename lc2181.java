public class lc2181 {

  private static void merge(ListNode head) {
    if (head.next.val == 0 || head.next == null) return;
    ListNode np;
    np = head.next;
    head.val += np.val;
    head.next = np.next;
    np.next = null;
    merge(head);
  }

  private static ListNode mergeNodes(ListNode head) {
    ListNode cp;
    merge(head);
    cp = head;
    while (cp.next != null && cp.next.next != null) {
      merge(cp.next);
      cp = cp.next;
    }
    cp.next = null;
    return head;
  }

  public static void main(String[] args) {
    int[] head = { 0,1,0,3,0,2,2,0 };
    ListNode h = ListNode.populate(head);
    ListNode.stringify(mergeNodes(h));
  }
}
